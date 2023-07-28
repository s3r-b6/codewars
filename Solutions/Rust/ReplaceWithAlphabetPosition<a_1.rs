
fn alphabet_position(text: &str) -> String {
    let positions: Vec<String> = text
        .to_lowercase()
        .as_bytes()
        .iter()
        .map(|c| {
            if *c >= 97 as u8 && *c <= 122 as u8 {
                format!("{} ", c % 32)
            } else {
                "".to_string()
            }
        })
        .collect();

    positions.join("").trim_end().to_string()
}
