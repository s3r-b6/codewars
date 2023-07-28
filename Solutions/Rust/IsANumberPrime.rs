
fn is_prime(x: i64) -> bool {
    if x <= 1 {
        return false;
    }

    let x_sqrt = (x as f64).sqrt().floor() as i64;

    for y in 2..=x_sqrt {
        if x % y == 0 {
            return false;
        }
    }

    return true;
}
