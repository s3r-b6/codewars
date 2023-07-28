
fn alphabet_position(text: &str) -> String {
    //filtering the map instead of doing a map makes more sense and is indeed cleaner
    text.to_lowercase()
        .bytes()
        .filter(|c| c >= &97 && c <= &122)
        .map(|c| format!("{}", c % 32))
        .collect::<Vec<String>>()
        .join(" ")
}
