export function solution(roman: string): number {
  //saw a solution that implemented a Record and
  //did it myself
  const Val: Record<string, number> = {
    I: 1,
    V: 5,
    X: 10,
    L: 50,
    C: 100,
    D: 500,
    M: 1000,
  };
  let cache = 0;
  for (let i = 0; i < roman.length; i++) {
    let current = Val[roman[i]];
    let next = Val[roman[i + 1]];
    if (current < next) {
      cache = cache + next - current;
      i++;
    } else {
      cache = cache + current;
    }
  }
  return cache;
}
