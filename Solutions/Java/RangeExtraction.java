class Solution {
  public static String rangeExtraction(int[] arr) {
    StringBuilder sb = new StringBuilder();
    int seq = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i + 1 < arr.length && arr[i] + 1 == arr[i + 1]) {
        if (seq == 0) sb.append(arr[i]);
        seq += 1;
        continue;
      }

      if (seq >= 2) {
        sb.append("-").append(arr[i]).append(",");
        seq = 0;
      } else if (seq > 0) {
        for (int j = 0; j < seq; j++) {
          sb.append(",").append(arr[i + j]).append(",");
        }
        seq = 0;
      } else {
        sb.append(arr[i]).append(",");
      }
    }

    return sb.deleteCharAt(sb.length() - 1).toString();
  }
}
