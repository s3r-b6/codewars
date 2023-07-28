export function isValidWalk(walk: string[]) {
  let walkedDir = [0, 0];
  if (walk.length != 10) return false;
  for (let i = 0; i < walk.length; i++) {
    if (walk[i] == "n") {
      walkedDir[0] += 1;
    } else if (walk[i] == "s") {
      walkedDir[0] -= 1;
    } else if (walk[i] == "e") {
      walkedDir[1] += 1;
    } else if (walk[i] == "w") {
      walkedDir[1] -= 1;
    }
  }
  if (walkedDir[0] == 0 && walkedDir[1] == 0) {
    return true;
  } else {
    return false;
  }
}
