package nz.ac.auckland.se281;

public class MediumLevel implements DifficultyLevel {

  private Strategy average;

  public MediumLevel(Strategy strategy) {
    this.average = strategy;
  }

  @Override
  public String[] getJarvisHand() {
    return average.decideJarvisHand();
  }
}
