
fn to_camel_case(text: &str) -> String {
    text.split(['-', '_']).fold(String::new(), |acc, str| {
        if !acc.eq("") {
            let initial = &str.chars().nth(0).unwrap().to_ascii_uppercase().to_string();
            let str_end = &str[1..str.len()];
            String::from_iter([&acc, initial, str_end])
        } else {
            String::from_iter([&acc, str])
        }
    })
}
