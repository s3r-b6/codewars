
fn sort_array(arr: &[i32]) -> Vec<i32> {
    let mut ordered_odds = vec![];
    let mut answer = vec![];

    for ele in arr {
        if ele & 1 == 1 {
            ordered_odds.push(ele);
            answer.push(-1);
        } else {
            answer.push(*ele);
        }
    }

    ordered_odds.sort();

    for i in 0..ordered_odds.len() {
        for h in 0..answer.len() {
            if answer[h] == -1 {
                answer[h] = *ordered_odds[i];
                break;
            } else {
                continue;
            }
        }
    }

    answer
}
