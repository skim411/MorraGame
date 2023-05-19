package nz.ac.auckland.se281;

public class MediumLevel implements DifficultyLevel {

  private Strategy average;

  public MediumLevel(int numOfRound, Human player) {
    this.average = new AverageStrategy(numOfRound, player);
  }

  @Override
  public String[] getJarvisHand() {
    return average.decideJarvisHand();
  }
}
