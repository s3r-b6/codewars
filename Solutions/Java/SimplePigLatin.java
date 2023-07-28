public class PigLatin {
  public static String pigIt(String str) {
    String[] wordArr = str.split(" ");
    String newStr = "";
    // this for is for words in wordArr
    for (int i = 0; i <= wordArr.length - 1; i++) {
      String selectedWord = wordArr[i];
      if (!selectedWord.equals("!") && !selectedWord.equals("?")) {
        selectedWord =
            selectedWord.substring(1, selectedWord.length()) + selectedWord.charAt(0) + "ay";
      }
      newStr = newStr + selectedWord + " ";
    }
    return newStr.trim();
  }
}
