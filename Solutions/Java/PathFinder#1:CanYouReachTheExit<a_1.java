public class Finder {

  public static boolean pathFinder(String maze) {
    String[] mazeLines = maze.split("\n");
    int numOfLines = mazeLines.length;
    int numOfTiles = mazeLines[0].length();
    if (numOfTiles == 1 && numOfTiles == 1) return true;

    char[][] mazeArray = new char[numOfLines][numOfTiles];
    for (int i = 0; i < numOfLines; i++) mazeArray[i] = mazeLines[i].toCharArray();

    boolean[][] alreadyVisited = new boolean[numOfLines][numOfTiles];

    return findPath(0, 0, alreadyVisited, mazeArray);
  }

  public static boolean findPath(int i, int j, boolean[][] alreadyVisited, char[][] mazeArray) {
    int numOfLines = mazeArray.length;
    int numOfTiles = mazeArray[0].length;

    if (i == numOfLines - 1 && j == numOfTiles - 1) return true;

    alreadyVisited[i][j] = true;

    // up
    if (i - 1 >= 0 && mazeArray[i - 1][j] == '.' && !alreadyVisited[i - 1][j]) {
      if (findPath(i - 1, j, alreadyVisited, mazeArray)) return true;
    }
    // left
    if (j - 1 >= 0 && mazeArray[i][j - 1] == '.' && !alreadyVisited[i][j - 1]) {
      if (findPath(i, j - 1, alreadyVisited, mazeArray)) return true;
    }
    // down
    if (i + 1 < numOfLines && mazeArray[i + 1][j] == '.' && !alreadyVisited[i + 1][j]) {
      if (findPath(i + 1, j, alreadyVisited, mazeArray)) return true;
    }
    // right
    if (j + 1 < numOfTiles && mazeArray[i][j + 1] == '.' && !alreadyVisited[i][j + 1]) {
      if (findPath(i, j + 1, alreadyVisited, mazeArray)) return true;
    }

    // no branch ended up in the exit
    return false;
  }
}
