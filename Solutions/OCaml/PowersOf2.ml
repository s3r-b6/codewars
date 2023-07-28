let rec powersOfTwo n =
  let rec pow2 x = match x with 0 -> 1 | x -> 2 * pow2 (x - 1) in
  match n with 0 -> [ 1 ] | x -> powersOfTwo (n - 1) @ [ pow2 n ]
