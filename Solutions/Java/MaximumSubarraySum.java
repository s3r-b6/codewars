import java.util.Arrays;

public class Max {
  public static int sequence(int[] arr) {
    int maxNum = 0;

    // i marks the int that is selected
    for (int i = 0; i < arr.length; i++) {
      // j marks the length of the subset
      for (int j = arr.length; j >= i; j--) {
        int[] arrCopy = Arrays.copyOfRange(arr, i, j);
        int sum = Arrays.stream(arrCopy).sum();
        if (sum > maxNum) maxNum = sum;
      }
    }
    return maxNum;
  }
}
