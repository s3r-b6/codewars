public class Finder {

  public static boolean pathFinder(String maze) {
    String mazeLines[] = maze.split("\n");
    int lines = mazeLines.length;
    int tiles = mazeLines[0].length();

    char[][] mazeArray = new char[lines][tiles];
    boolean[][] alreadyVisited = new boolean[lines][tiles];

    if (lines == 1 && tiles == 1) return true;
    for (int i = 0; i < lines; i++) mazeArray[i] = mazeLines[i].toCharArray();

    return pathFinder(mazeArray, alreadyVisited, 0, 0);
  }

  private static boolean pathFinder(char[][] mazeArray, boolean[][] alreadyVisited, int y, int x) {
    int lines = mazeArray.length;
    int tiles = mazeArray[0].length;

    alreadyVisited[y][x] = true;
    if (alreadyVisited[lines - 1][tiles - 1]) return true;

    if (y - 1 >= 0 && !alreadyVisited[y - 1][x] && mazeArray[y - 1][x] == '.') // try up
    if (pathFinder(mazeArray, alreadyVisited, y - 1, x)) return true;
    if (x - 1 >= 0 && !alreadyVisited[y][x - 1] && mazeArray[y][x - 1] == '.') // try left
    if (pathFinder(mazeArray, alreadyVisited, y, x - 1)) return true;
    if (y + 1 < lines && !alreadyVisited[y + 1][x] && mazeArray[y + 1][x] == '.') // try down
    if (pathFinder(mazeArray, alreadyVisited, y + 1, x)) return true;
    if (x + 1 < tiles && !alreadyVisited[y][x + 1] && mazeArray[y][x + 1] == '.') // try right
    if (pathFinder(mazeArray, alreadyVisited, y, x + 1)) return true;

    return false;
  }
}
