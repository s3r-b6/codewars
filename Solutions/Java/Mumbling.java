public class Accumul {

  public static String accum(String s) {
    String newString = "";
    // 2d for loop to add each letter x times
    // x being its position inside the string
    for (int i = 0; i <= s.length() - 1; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0) {
          newString += String.valueOf(s.charAt(i)).toUpperCase();
        } else {
          newString += String.valueOf(s.charAt(i)).toLowerCase();
        }
      }
      // don't add - at the end
      if (i != s.length() - 1) {
        newString += "-";
      }
    }
    return newString;
  }
}
