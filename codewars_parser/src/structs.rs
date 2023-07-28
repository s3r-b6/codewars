use std::{
    fs::{self, File},
    io::{Error, Write},
    path::Path,
    process::{Command, Stdio},
    string::FromUtf8Error,
};

pub struct Solution {
    name: String,
    language: String,
    content: String,
}

impl Solution {
    pub fn new(name: String, language: String, content: String) -> Self {
        Solution {
            name,
            language,
            content,
        }
    }

    #[allow(dead_code)]
    pub fn to_string(&self) -> String {
        format!(
            "Name: {}\nLang: {}\n{}",
            self.name, self.language, self.content
        )
    }

    pub fn camel_case_name(&self) -> String {
        self.name
            .replace(['"', '\'', '\\', '/', '!', '?', '.', ','], "")
            .split(['-', '_', ' '])
            .fold(String::new(), |acc, str| {
                let str = match acc.as_str() {
                    "" => str.to_string(),
                    _ => {
                        if str.len() >= 1 {
                            str[..1].to_ascii_uppercase() + &str[1..]
                        } else {
                            str.to_string()
                        }
                    }
                };
                String::from_iter([acc, str])
            })
    }

    pub fn format_contents(&self) -> Result<String, FromUtf8Error> {
        let mason_bins = "/home/ser/.local/share/nvim/mason/bin";
        let child_process = match self.language.as_str() {
            "Java" => Some(
                Command::new(format!("{}/google-java-format", mason_bins))
                    .arg("-")
                    .stdin(Stdio::piped())
                    .stdout(Stdio::piped())
                    .spawn(),
            ),
            "OCaml" => Some(
                Command::new("ocamlformat")
                    .arg("--enable-outside-detected-project")
                    .arg("-")
                    .arg("--impl")
                    .stdin(Stdio::piped())
                    .stdout(Stdio::piped())
                    .spawn(),
            ),
            "Rust" => Some(
                Command::new("rustfmt")
                    .stdin(Stdio::piped())
                    .stdout(Stdio::piped())
                    .spawn(),
            ),
            "TypeScript" | "JavaScript" => Some(
                Command::new(format!("{}/prettier", mason_bins))
                    .stdin(Stdio::piped())
                    .arg("--parser")
                    .arg("typescript")
                    .stdout(Stdio::piped())
                    .spawn(),
            ),
            _ => None,
        };

        if let Some(child_process) = child_process {
            let mut child_process = child_process.unwrap();
            {
                let stdin = child_process.stdin.as_mut().expect("Failed to open stdin");
                stdin
                    .write_all(self.content.as_bytes())
                    .expect("Failed to write to stdin");
            }

            let output = child_process
                .wait_with_output()
                .expect("Failed to wait for child process");

            let formatted_content =
                String::from_utf8(output.stdout).expect("Failed to parse output");

            Ok(formatted_content)
        } else {
            Ok(self.content.clone())
        }
    }
    pub fn get_filename(&self) -> (String, String) {
        let extension = match self.language.as_str() {
            "Java" => ".java",
            "Rust" => ".rs",
            "TypeScript" => ".ts",
            "JavaScript" => ".js",
            "OCaml" => ".ml",
            _ => panic!("unknown lang?"),
        };
        let name = self.camel_case_name();

        (name, extension.to_string())
    }

    pub fn get_path(&self) -> String {
        format!(r"/home/ser/Desktop/codewars/Solutions/{}/", self.language)
    }

    pub fn to_file(&self) -> Result<(), Error> {
        let contents = self.format_contents().unwrap();
        let lang_path = self.get_path();
        let (filename, extension) = self.get_filename();

        let mut file_path = format!("{}{}{}", lang_path, filename, extension);
        if Path::new(&file_path).exists() {
            let mut num = 1;
            file_path = format!("{}{}_{}{}", lang_path, filename, num.to_string(), extension);
            while Path::new(&file_path).exists() {
                num += 1;
                file_path = format!("{}{}_{}{}", lang_path, filename, num.to_string(), extension);
            }
        }

        fs::create_dir_all(&lang_path).unwrap();
        let mut file = File::create(&file_path)?;
        file.write_all(contents.as_bytes())?;

        Ok(())
    }
}
