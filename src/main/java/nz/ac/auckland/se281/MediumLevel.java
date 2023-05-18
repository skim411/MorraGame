package nz.ac.auckland.se281;

public class MediumLevel implements DifficultyLevel {

  private Strategy average;

  public MediumLevel(Strategy strategy) {
    this.average = strategy;
  }

  @Override
  public String[] getJarvisHand(int numOfRound, Human player) {
    return average.decideJarvisHand(numOfRound, player);
  }
}
