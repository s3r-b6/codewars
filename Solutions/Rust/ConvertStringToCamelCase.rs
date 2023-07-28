//Totally forgot that you could concat to Strings like that
fn to_camel_case(text: &str) -> String {
    text.split(['-', '_']).fold(String::new(), |acc, str| {
        let str = if !acc.eq("") {
            str[..1].to_ascii_uppercase() + &str[1..]
        } else {
            str.to_string()
        };

        acc + &str
    })
}
