export function rowSumOddNumbers(n: number): number {
  //indeed it grows by powers of 3, now that i have seen
  //that solution it is so obvious that from 1 to 5 you
  //add 2 thrice, so to get row 2 value you do 2*2*2 and so on
  return Math.pow(n, 3);
}
