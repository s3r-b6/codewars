let find_next_power (val_ : int) (pow : int) : int =
  let rec power a = function
    | 0 -> 1
    | 1 -> a
    | n ->
        let b = power a (n / 2) in
        b * b * if n mod 2 = 0 then 1 else a
  in
  let rec new_cube n =
    let num = power n pow in
    if num > val_ then num else new_cube (n + 1)
  in
  new_cube 1
