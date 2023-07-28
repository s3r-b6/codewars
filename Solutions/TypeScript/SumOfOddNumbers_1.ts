export function rowSumOddNumbers(n: number): number {
  if (n == 1) return 1;
  let totalNums = 0;
  //for row 13, there are 13+12+11... numbers
  for (let i = n; i > 0; i--) {
    totalNums = totalNums + i;
  }
  //first num in row is totalNums - nums in the row
  let firstNum = totalNums - n;
  let cache = 0;
  //walk from first number to last number in the row
  //calculate and add to cache
  for (let i = firstNum; i < totalNums; i++) {
    let num = 1 + i * 2;
    cache = cache + num;
  }
  return cache;
}
