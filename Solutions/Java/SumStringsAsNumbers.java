public class Kata {
  public static String sumStrings(String a, String b) {
    // to convert from ASCII to the value, we just have to modulo by 48
    // 48 -> 0 || 57 -> 9
    int[] aInts = a.chars().map(e -> e % 48).toArray();
    int[] bInts = b.chars().map(e -> e % 48).toArray();

    int biggestIndex = Math.max(aInts.length, bInts.length);

    int[] summedInts = new int[biggestIndex];
    String result = "";

    for (int i = 1; i <= biggestIndex; i++) {
      if (aInts.length - i >= 0) summedInts[summedInts.length - i] += aInts[aInts.length - i];
      if (bInts.length - i >= 0) summedInts[summedInts.length - i] += bInts[bInts.length - i];
    }

    /*
     *  after summing all ints, we just have to check if some number exceeds 9 and sum it to the preceding one,
     *  if there is an "overflow", we just have to prepend the 1 in the string and drop it in the
     *  char representation
     */
    for (int i = summedInts.length - 1; i >= 0; i--) {
      if (summedInts[i] <= 9) continue;

      if (i - 1 < 0) result += "1";
      else summedInts[i - 1] += 1;

      summedInts[i] %= 10;
    }

    for (int i = 0; i < summedInts.length; i++) result += String.valueOf(summedInts[i]);

    while (result.startsWith("0")) result = result.substring(1);

    return result;
  }
}
