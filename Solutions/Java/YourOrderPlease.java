public class Order {
  public static String order(String words) {
    if (words.equals("")) return "";

    String[] slicedWords = words.split(" ");
    String[] order = words.replaceAll("\\D+", "").split("");
    String[] orderedString = new String[slicedWords.length];

    for (int i = 0; i < order.length; i++) {
      int index = Integer.valueOf(order[i]);
      orderedString[index - 1] = slicedWords[i];
    }

    return String.join(" ", orderedString);
  }
}
