public class CountingDuplicates {
  public static int duplicateCount(String text) {
    char[] charArr = text.toCharArray();
    String repeatedChars = "";
    int repCount = 0;
    for (int i = 0; i <= charArr.length - 1; i++) {
      Character selectedChar = charArr[i];
      for (int j = 0; j <= charArr.length - 1; j++) {

        if (i != j
            && !repeatedChars.contains(String.valueOf(Character.toLowerCase(selectedChar)))
            && (selectedChar.equals(Character.toLowerCase(charArr[j]))
                || selectedChar.equals(Character.toUpperCase(charArr[j])))) {
          repeatedChars += Character.toLowerCase(selectedChar);
          repCount++;
        }
      }
    }
    System.out.println(repeatedChars);
    return repCount;
  }
}
