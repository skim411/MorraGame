package nz.ac.auckland.se281;

public class HardLevel implements DifficultyLevel {

  private String[] topJarvisInput;
  private Strategy top = new TopStrategy();

  public HardLevel(Strategy strategy) {
    this.top = strategy;
  }

  @Override
  public String[] getJarvisInput() {
    topJarvisInput = top.decideJarvisInput();
    return topJarvisInput;
  }
}
