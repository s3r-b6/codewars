public class NumberFun {
  public static long findNextSquare(long sq) {
    double flooredSq = Math.floor(Math.sqrt(sq));
    if (flooredSq * flooredSq != sq) {
      return -1;
    } else {
      flooredSq = flooredSq + 1;
      long nextSquare = (long) flooredSq * (long) flooredSq;
      return nextSquare;
    }
  }
}
