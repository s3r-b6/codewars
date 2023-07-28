
fn high(input: &str) -> &str {
    //The previous solution used a pointless map; also, reversing the iterator
    //solves the returning the first highest scored problem when using max_by_key
    input
        .split(' ')
        .rev()
        .max_by_key(|str| str.chars().map(|ch| ch as u16 % 32).sum::<u16>())
        .unwrap()
}
