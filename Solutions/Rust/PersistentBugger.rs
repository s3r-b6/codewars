
fn persistence(mut num: u64) -> u64 {
    let mut times = 0;
    while num > 9 {
        let mut len = (num.to_string().len() - 1) as i32;
        let mut num2 = 1;
        while len >= 0 {
            num2 *= num % 10;
            num /= 10;
            len -= 1;
        }
        num = num2;
        times += 1;
    }
    return times;
}
