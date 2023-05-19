package nz.ac.auckland.se281;

public class HardLevel implements DifficultyLevel {

  private Strategy top;

  public HardLevel(int numOfRound, Human player) {
    this.top = new TopStrategy(numOfRound, player);
  }

  @Override
  public String[] getJarvisHand() {
    return top.decideJarvisHand();
  }
}
