
fn likes(likes: &[&str]) -> String {
    if likes.len() > 1 {
        if likes.len() <= 3 {
            format!(
                "{} and {} like this",
                likes[..likes.len() - 1].join(", "),
                likes[likes.len() - 1]
            )
        } else {
            format!(
                "{} and {} like this",
                likes[..2].join(", "),
                format!("{} others", likes.len() - 2)
            )
        }
    } else if likes.len() == 1 {
        format!("{} likes this", likes[likes.len() - 1])
    } else {
        String::from("no one likes this")
    }
}
