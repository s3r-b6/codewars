public class Troll {
  public static String disemvowel(String str) {
    String cookedString = str.replaceAll("[AEIOUaeiou]", "");
    return cookedString;
  }
}
