let make_negative (number : int) : int =
  if number == 0 then 0 else if number < 0 then number else 0 - number
