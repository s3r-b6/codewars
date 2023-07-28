
fn good_vs_evil(good: &str, evil: &str) -> String {
    let good_army: Vec<u8> = good.split(' ').map(|el| el.parse().unwrap()).collect();
    let evil_army: Vec<u8> = evil.split(' ').map(|el| el.parse().unwrap()).collect();

    let good_score = {
        good_army[0] * 1
            + good_army[1] * 2
            + good_army[2] * 3
            + good_army[3] * 3
            + good_army[4] * 4
            + good_army[5] * 10
    };

    let evil_score = {
        evil_army[0] * 1
            + evil_army[1] * 2
            + evil_army[2] * 2
            + evil_army[3] * 2
            + evil_army[4] * 3
            + evil_army[5] * 5
            + evil_army[6] * 10
    };

    if good_score == evil_score {
        return String::from("Battle Result: No victor on this battle field");
    } else if good_score > evil_score {
        return String::from("Battle Result: Good triumphs over Evil");
    } else {
        return String::from("Battle Result: Evil eradicates all trace of Good");
    }
}
