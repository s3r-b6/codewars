public class User {
  public int rank, progress;

  User() {
    this.rank = -8;
    this.progress = 0;
  }

  public void incProgress(int difficulty) {
    if (Math.abs(difficulty) > 8 || difficulty == 0) throw new IllegalArgumentException("Bad args");
    if (rank == 8) return;

    int difference = Math.abs(difficulty - rank);
    if (Math.signum(difficulty) + Math.signum(rank) == 0.) difference -= 1;

    int rankProgress = 0;

    if (difficulty <= rank) { // taskRank<userRank so sum less
      if (difference == 0) rankProgress = 3;
      else if (difference == 1) rankProgress = 1;
      else if (difference <= 2) rankProgress = 0;
    } else rankProgress = 10 * difference * difference; // taskRank>userRank so 10*d*d

    System.out.println("Rank: " + rank + " difficulty " + difficulty);
    System.out.println("Difference: " + difference + " progress: " + rankProgress);

    this.progress += rankProgress;

    if (progress / 100 >= 1) {
      double newLevel = Math.floor(progress / 100);
      for (int i = 0; i < newLevel; i++) {
        this.rank += 1;
        if (this.rank == 0) this.rank += 1;
        if (this.rank == 8) this.progress = 0;
      }
      this.progress = this.progress % 100;
    }
    System.out.println("New rank: " + rank + " New progress: " + progress + "\n");
  }
}
