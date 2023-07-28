class Solution {
  public static String camelCase(String str) {
    String newString = "";

    byte[] strBytes = str.getBytes();
    for (byte b : strBytes) {
      // 65-90 caps
      if (b >= 65 && b <= 90) {
        newString += " " + (char) b;
      } else {
        newString += (char) b;
      }
    }

    return newString;
  }
}
