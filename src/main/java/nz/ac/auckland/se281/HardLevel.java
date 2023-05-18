package nz.ac.auckland.se281;

public class HardLevel implements DifficultyLevel {

  private Strategy top;

  public HardLevel(Strategy strategy) {
    this.top = strategy;
  }

  @Override
  public String[] getJarvisHand(int numOfRound, Human player) {
    return top.decideJarvisHand(numOfRound, player);
  }
}
