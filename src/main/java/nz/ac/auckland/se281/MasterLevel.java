package nz.ac.auckland.se281;

public class MasterLevel implements DifficultyLevel {

  private Strategy master;

  public MasterLevel(Strategy strategy) {
    this.master = strategy;
  }

  @Override
  public String[] getJarvisHand(int numOfRound, Human player) {
    return master.decideJarvisHand(numOfRound, player);
  }
}
