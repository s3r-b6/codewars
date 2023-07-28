import java.util.List;

public class BinaryArrayToNumber {

  public static int ConvertBinaryArrayToInt(List<Integer> binary) {
    int reverseCounter = binary.size() - 1;
    int cache = 0;
    for (int i = 0; reverseCounter - i >= 0; i++) {
      cache = cache + (binary.get(reverseCounter - i) * (int) Math.pow(2, i));
    }
    return cache;
  }
}
