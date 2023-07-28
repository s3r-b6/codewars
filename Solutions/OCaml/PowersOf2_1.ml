let rec pow2 x = match x with 0 -> 1 | 1 -> 2 | x -> 2 * pow2 (x - 1)
let rec listOfn y = if y < 0 then [] else listOfn (y - 1) @ [ y ]
let powersOfTwo n = List.map pow2 (listOfn n)
