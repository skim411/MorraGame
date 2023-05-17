package nz.ac.auckland.se281;

public class MediumLevel implements DifficultyLevel {

  private String[] averageJarvisInput;
  private Strategy average = new AverageStrategy();

  public MediumLevel(Strategy strategy) {
    this.average = strategy;
  }

  public String[] getJarvisInput() {
    averageJarvisInput = average.decideJarvisInput();
    return averageJarvisInput;
  }
}
