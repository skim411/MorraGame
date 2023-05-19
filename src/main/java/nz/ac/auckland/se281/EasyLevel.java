package nz.ac.auckland.se281;

public class EasyLevel implements DifficultyLevel {

  private Strategy random;

  public EasyLevel() {
    this.random = new RandomStrategy();
  }

  @Override
  public String[] getJarvisHand() {
    return random.decideJarvisHand();
  }
}
