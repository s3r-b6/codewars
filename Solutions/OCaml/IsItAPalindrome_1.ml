let is_palindrome (s : string) : bool =
  if String.length s <= 1 then true
  else
    let result = ref true in
    let len = String.length s in
    let s = String.lowercase_ascii s in
    for i = 0 to (len / 2) - 1 do
      if not (Char.equal (String.get s i) (String.get s (len - 1 - i))) then
        result := false
    done;
    !result
