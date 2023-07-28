let rec is_uppercase (s : string) : bool =
  if String.length s == 0 then true
  else
    let first_byte = Char.code s.[0] in
    if not (first_byte >= 97 && first_byte <= 122) then
      if String.length s > 1 then
        is_uppercase (String.sub s 1 (String.length s - 1))
      else true
    else false
