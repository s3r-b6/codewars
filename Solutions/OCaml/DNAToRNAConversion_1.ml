let dna_to_rna str =
  let t_to_u ch = match ch with 'T' -> 'U' | _ -> ch in
  String.map t_to_u str
