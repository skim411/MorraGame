package nz.ac.auckland.se281;

public class MasterType implements DifficultyLevel {

  private Strategy master;

  public MasterType(Strategy strategy) {
    this.master = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.master = strategy;
  }

  public void changeStrategy(Morra game) {
    // change strategy after 3 rounds
    if (game.getRound() <= 3) {
      master = new RandomStrategy();
    } else {
      if (game.getRound() % 2 == 0) {
        master = new AverageStrategy();
      } else {
        master = new TopStrategy();
      }
    }
  }

  @Override
  public String[] getJarvisHand() {
    return master.decideJarvisHand();
  }
}
