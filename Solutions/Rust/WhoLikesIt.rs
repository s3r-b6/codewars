
fn likes(names: &[&str]) -> String {
    //rusts match is amazing
    match names.len() {
        0 => String::from("no one likes this"),
        1 => return format!("{} likes this", names[0]),
        2 => return format!("{} and {} like this", names[0], names[1]),
        3 => return format!("{}, {} and {} like this", names[0], names[1], names[2]),
        l => return format!("{}, {} and {} others like this", names[0], names[1], l - 2),
    }
}
