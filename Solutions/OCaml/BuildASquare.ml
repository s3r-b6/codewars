let generate_shape (n : int) : string =
  let str = String.make n '+' in
  let rec build_shape n acc =
    if n == 0 then acc
    else build_shape (n - 1) (String.concat "\n" [ acc; str ])
  in
  build_shape (n - 1) str
