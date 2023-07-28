pub mod structs;

use std::{
    fs::File,
    io::{BufRead, BufReader},
};

use regex::Regex;
use structs::Solution;

fn main() {
    let solutions = get_solutions();

    for sol in solutions {
        let (name, extension) = sol.get_filename();
        println!("Writing file {}{}", name, extension);
        sol.to_file().unwrap();
    }
}

fn get_solutions() -> Vec<Solution> {
    let file = File::open(r"/home/ser/Desktop/codewars/codewars_parser/src/sol.html").unwrap();
    let mut buffer = String::new();
    let mut buf_reader = BufReader::new(file);

    let mut started_solutions = false;

    let mut solution_string = String::new();
    let mut solutions = vec![];

    let mut current_lang = String::new();
    let mut current_title = String::new();
    while let Ok(line) = buf_reader.read_line(&mut buffer) {
        if line == 0 {
            break;
        }

        if buffer.contains("a href=\"/kata/") {
            current_title = buffer.to_string().replace(['\n', '\t'], "");
            while !current_title.contains("</") {
                let _ = buf_reader.read_line(&mut buffer);
                current_title += &buffer.replace(['\n', '\t'], "");
            }
        } else if buffer.contains("h6") {
            current_lang = buffer.to_string();
        } else if buffer.contains("markdown prose max-w-none") {
            started_solutions = true;
        }

        if started_solutions {
            if buffer.contains("bulleted-text mt-2 mb-4") {
                started_solutions = false;
                solutions.push(parse_tags(&current_lang, &current_title, &solution_string));
                solution_string.clear();
            } else {
                solution_string.push_str(buffer.as_str());
            }
        }
        buffer.clear();
    }

    solutions
}

fn parse_tags(current_lang: &String, current_title: &String, str: &String) -> Solution {
    let regex = Regex::new(r"<.+?([\n|\r]\s+?|\t+?)?>").unwrap();

    let title = regex
        .replace_all(current_title, "")
        .replace("</a", "")
        .trim()
        .to_string();

    let lang = regex
        .replace_all(&current_lang, "")
        .replace(":", "")
        .trim()
        .to_string();

    let contents = regex
        .replace_all(&str, "")
        .to_string()
        .replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&amp;", "&");

    Solution::new(title, lang, contents)
}
