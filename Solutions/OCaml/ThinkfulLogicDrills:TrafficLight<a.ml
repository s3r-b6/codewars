open Preloaded

let update_light (current : light) : light =
  match current with Green -> Yellow | Yellow -> Red | Red -> Green
