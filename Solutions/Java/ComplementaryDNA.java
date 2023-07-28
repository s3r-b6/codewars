public class DnaStrand {
  public static String makeComplement(String dna) {
    String cookedString = dna.replaceAll("[A]", "t");
    cookedString = cookedString.replaceAll("[T]", "a");
    cookedString = cookedString.replaceAll("[C]", "g");
    cookedString = cookedString.replaceAll("[G]", "c");
    return cookedString.toUpperCase();
  }
}
