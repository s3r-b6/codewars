import java.util.HashMap;

public class Scramblies {

  public static boolean scramble(String str1, String str2) {
    HashMap<Character, Integer> charOccurs = new HashMap<>();

    char[] str1Array = str1.toCharArray();
    for (char c : str1Array) {
      if (!charOccurs.containsKey(c)) charOccurs.put(c, 1);
      else charOccurs.put(c, charOccurs.get(c) + 1);
    }

    char[] str2Array = str2.toCharArray();
    for (char c : str2Array) {
      if (!charOccurs.containsKey(c) || charOccurs.get(c) == 0) return false;
      else charOccurs.put(c, charOccurs.get(c) - 1);
    }

    return true;
  }
}
