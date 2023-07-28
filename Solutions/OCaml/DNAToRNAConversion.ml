let dna_to_rna str = String.map (function 'T' -> 'U' | ch -> ch) str
