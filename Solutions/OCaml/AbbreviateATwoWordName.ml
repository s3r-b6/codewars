let abbrev_name (name : string) : string =
  let space_i = String.index name ' ' in
  let char_1 = Char.uppercase_ascii name.[0] in
  let char_2 = Char.uppercase_ascii name.[space_i + 1] in
  String.concat "" [ String.make 1 char_1; "."; String.make 1 char_2 ]
;;

print_endline (abbrev_name "Sam Harris")
