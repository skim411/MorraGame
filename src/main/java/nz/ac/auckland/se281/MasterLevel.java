package nz.ac.auckland.se281;

public class MasterLevel implements DifficultyLevel {

  private Strategy master;

  public MasterLevel(Strategy strategy) {
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
      } else if (game.getRound() % 2 == 1) {
        master = new TopStrategy();
      }
    }
  }

  @Override
  public String[] getJarvisHand(int numOfRound, Human player) {
    return master.decideJarvisHand(numOfRound, player);
  }
}
