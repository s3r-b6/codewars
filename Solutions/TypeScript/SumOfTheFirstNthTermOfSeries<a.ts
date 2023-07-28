export function SeriesSum(n: number): string {
  if (n == 1) return "1.00";
  let cache: number = 0;
  for (let i = 0; i <= n - 1; i++) {
    let div = 1 + i * 3;
    cache = cache + 1 / div;
    console.log(cache, div);
  }
  cache = Math.round(cache * 100) / 100;
  return cache.toFixed(2);
}
