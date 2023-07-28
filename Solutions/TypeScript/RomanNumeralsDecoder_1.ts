export function solution(roman: string): number {
  let cache = 0;
  for (let i = 0; i < roman.length; i++) {
    let currLetter: string = roman[i];
    let nextLetter: string = roman[i + 1];
    if (currLetter === "I") {
      if (nextLetter === "V") {
        cache = cache + 4;
        i++;
      } else {
        cache = cache + 1;
      }
    } else if (currLetter === "V") {
      cache = cache + 5;
    } else if (currLetter === "X") {
      if (nextLetter == "L") {
        cache = cache + 40;
        i++;
      } else if (nextLetter === "C") {
        cache = cache + 90;
        i++;
      } else {
        cache = cache + 10;
      }
    } else if (currLetter === "L") {
      cache = cache + 50;
    } else if (currLetter === "C") {
      if (nextLetter === "M") {
        cache = cache + 900;
        i++;
      } else if (nextLetter === "D") {
        cache = cache + 400;
        i++;
      } else {
        cache = cache + 100;
      }
    } else if (currLetter === "D") {
      cache = cache + 500;
    } else if (currLetter === "M") {
      cache = cache + 1000;
    }
    //console.log(cache, " i")
  }
  return cache;
}
