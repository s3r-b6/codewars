public class CountingDuplicates {

  public static int duplicateCount(String text) {
    text = text.toLowerCase();
    String repeatedChars = "";
    int repCount = 0;
    // 2d for bc each char is tested against each char in the whole string
    for (int i = 0; i <= text.length() - 1; i++) {
      Character selectedChar = text.charAt(i);
      for (int j = 0; j <= text.length() - 1; j++) {
        // if it is not testing against itself, it is not between the repeatedChars
        // and if letter i is equal to letter j
        if (i == j || repeatedChars.contains(String.valueOf(selectedChar))) {
          break;
        } else if (selectedChar.equals(text.charAt(j))) {
          repeatedChars += selectedChar;
          repCount++;
        }
      }
    }
    // debug
    // System.out.println(repeatedChars);
    return repCount;
  }
}
