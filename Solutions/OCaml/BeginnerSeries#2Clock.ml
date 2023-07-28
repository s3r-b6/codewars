let past (h : int) (m : int) (s : int) : int =
  let x = (h * 3600) + (m * 60) + s in
  x * 1000
