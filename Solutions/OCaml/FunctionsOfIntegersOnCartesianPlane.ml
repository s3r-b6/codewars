let sumin (n : int) : int =
  let rec loop_1 (x : int ref) (acc : int) =
    let rec loop_2 (y : int ref) (x_y_acc : int) =
      if !y <= n then loop_2 (ref (!y + 1)) (x_y_acc + min !x !y) else x_y_acc
    in
    if !x <= n then loop_1 (ref (!x + 1)) acc + loop_2 (ref 1) 0 else acc
  in

  loop_1 (ref 1) 0

let sumax (n : int) : int =
  let rec loop_1 (x : int ref) (acc : int) =
    let rec loop_2 (y : int ref) (x_y_acc : int) =
      if !y <= n then loop_2 (ref (!y + 1)) (x_y_acc + max !x !y) else x_y_acc
    in
    if !x <= n then loop_1 (ref (!x + 1)) acc + loop_2 (ref 1) 0 else acc
  in

  loop_1 (ref 1) 0

let sumsum (n : int) : int =
  let rec loop_1 (x : int ref) (acc : int) =
    let rec loop_2 (y : int ref) (x_y_acc : int) =
      if !y <= n then loop_2 (ref (!y + 1)) (x_y_acc + (!x + !y)) else x_y_acc
    in
    if !x <= n then loop_1 (ref (!x + 1)) acc + loop_2 (ref 1) 0 else acc
  in

  loop_1 (ref 1) 0
