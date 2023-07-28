
fn multiplication_table(len: usize) -> Vec<Vec<usize>> {
    let mut answer = vec![];
    for i in 1..=len {
        let mut inner_vec = vec![];
        for j in 1..=len {
            inner_vec.push(i * j);
        }
        answer.push(inner_vec);
    }

    answer
}
