public class AreSame {

  public static boolean comp(int[] a, int[] b) {
    if (a == null || b == null) {
      return false;
    } else if (a.length != b.length) {
      return false;
    }

    int length = a.length;
    boolean[] truthList = new boolean[length];
    boolean flag = false;
    for (int i = 0; i <= length - 1; i++) {
      System.out.println("Comparing to sqr of " + a[i]);
      for (int j = 0; j <= length - 1; j++) {
        System.out.println("Comparing to item " + b[j]);
        if ((a[i] * a[i]) == b[j] && truthList[j] != true) {
          truthList[j] = true;
          System.out.println("item " + b[j] + "is equals");
          j = length;
        }
      }
    }

    for (int i = 0; i <= truthList.length - 1; i++) {
      if (truthList[i] == false) {
        return false;
      }
    }
    return true;
  }
}
