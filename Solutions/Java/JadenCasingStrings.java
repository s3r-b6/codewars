public class JadenCase {

  public String toJadenCase(String phrase) {
    // TODO put your code below this comment

    if (phrase == null) {
      return null;
    }

    if (phrase.length() != 0 || !phrase.equals("")) {
      String[] wordsArr = phrase.split(" ");
      String phraseCache = "";
      for (int i = 0; i <= wordsArr.length - 1; i++) {
        String selectedWord = wordsArr[i];
        phraseCache =
            phraseCache
                + selectedWord.substring(0, 1).toUpperCase()
                + selectedWord.substring(1, selectedWord.length())
                + ' ';
      }
      phraseCache = phraseCache.trim();
      return phraseCache;
    }
    return null;
  }
}
