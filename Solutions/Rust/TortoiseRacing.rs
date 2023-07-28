
fn race(v1: i32, v2: i32, g: i32) -> Option<Vec<i32>> {
    if v1 >= v2 {
        return None;
    }

    let time = (g * 3600) / (v2 - v1);
    let (hours, minutes, seconds) = (time / 3600, (time % 3600) / 60, time % 60);

    return Some(vec![hours, minutes, seconds]);
}
