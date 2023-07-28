
fn is_valid_ip(ip: &str) -> bool {
    if ip == "0.0.0.0" {
        return true;
    }
    let ip_parts: Vec<&str> = ip.split(".").collect();
    if ip_parts.len() != 4 {
        return false;
    }
    for ele in ip_parts {
        if ele.len() == 0 {
            return false;
        }
        if !ele.chars().all(|e| e.is_ascii_digit()) {
            return false;
        }
        if ele.starts_with("0") && ele.len() > 1 {
            return false;
        }
        if ele.parse::<u16>().unwrap() > 255 as u16 {
            return false;
        }
    }
    true
}
