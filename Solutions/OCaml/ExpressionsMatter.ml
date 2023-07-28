let expression_matter a b c =
  let l =
    [ a * b * c; a + b + c; (a * b) + c; a + (b * c); (a + b) * c; a * (b + c) ]
  in

  List.fold_left max min_int l
