import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Greed {
  public static int greedy(int[] rolls) {
    int[] rollsCopy = Arrays.stream(rolls).sorted().toArray();

    HashMap results = new HashMap();

    for (int i : rollsCopy) {
      if (!results.containsKey(i)) {
        results.put(i, 1);
      } else {
        results.put(i, (int) results.get(i) + 1);
      }
    }
    int score = 0;

    Set keys = results.keySet();

    for (Object key : keys) {
      int roll = (int) key, times = (int) results.get(roll);
      if (times >= 3 && !(roll == 1 || roll == 5)) {
        score += roll * 100;
      } else if (times >= 3 && roll == 1) {
        score += times - 3 > 0 ? 1000 + (times - 3) * 100 : 1000;
      } else if (times >= 3 && roll == 5) {
        score += times - 3 > 0 ? 500 + (times - 3) * 50 : 500;
      }

      if (times < 3 && roll == 5) {
        score += times * 50;
      } else if (times < 3 && roll == 1) {
        score += times * 100;
      }
    }

    return score;
  }
}
