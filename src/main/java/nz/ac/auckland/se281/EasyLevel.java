package nz.ac.auckland.se281;

public class EasyLevel implements DifficultyLevel {

  private Strategy random;

  public EasyLevel(Strategy strategy) {
    this.random = strategy;
  }

  @Override
  public String[] getJarvisHand(int numOfRound, Human player) {
    return random.decideJarvisHand(numOfRound, player);
  }
}
