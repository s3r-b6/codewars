export const digitalRoot = (n: number): number => {
  let s: string = n.toString();
  let cache: number = 0;
  while (s.length > 1) {
    for (let i = 0; i <= s.length - 1; i++) {
      cache = cache + parseInt(s[i]);
    }
    s = cache.toString();
    cache = 0;
  }
  return parseInt(s);
};
