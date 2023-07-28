public class Maskify {
  public static String maskify(String str) {
    String newStr = "";
    if (str.length() - 4 <= 0) {
      return str;
    }
    for (int i = 0; i <= str.length() - 4 - 1; i++) {
      newStr = newStr + "#";
    }
    for (int j = str.length() - 4; j <= str.length() - 1; j++) {
      newStr = newStr + str.charAt(j);
    }
    return newStr;
  }
}
