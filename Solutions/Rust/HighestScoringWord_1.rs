
fn high(input: &str) -> &str {
    input
        .split(' ')
        .map(|str| {
            let val = str.chars().map(|ch| (ch as u8 % 32) as i32).sum::<i32>();
            (str, val)
        })
        .fold(None, |max, current| match max {
            None => Some(current),
            Some((_max_str, max_score)) if current.1 > max_score => Some(current),
            _ => max,
        })
        .unwrap()
        .0
}
