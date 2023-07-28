public class AreSame {

  public static boolean comp(int[] a, int[] b) {
    if (a == null || b == null) {
      return false;
    } else if (a.length != b.length) {
      return false;
    }

    int length = a.length;
    boolean[] truthList = new boolean[length];
    // compare a[i] to each item in b
    for (int i = 0; i <= length - 1; i++) {
      for (int j = 0; j <= length - 1; j++) {
        // the truthList test is so a[i] cannot be checked
        // against a value that already has a match
        if ((a[i] * a[i]) == b[j] && truthList[j] != true) {
          truthList[j] = true;
          j = length;
        }
      }
    }
    // if there is a single false, return false, else, true
    for (int i = 0; i <= truthList.length - 1; i++) {
      if (truthList[i] == false) {
        return false;
      }
    }
    return true;
  }
}
