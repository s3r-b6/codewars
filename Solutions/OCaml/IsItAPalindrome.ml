let rec is_palindrome (s : string) : bool =
  let s = String.lowercase_ascii s in
  let len = String.length s in
  match len with
  | 0 | 1 -> true
  | _ -> s.[0] = s.[len - 1] && is_palindrome (String.sub s 1 (len - 2))
