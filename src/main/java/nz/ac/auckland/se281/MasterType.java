package nz.ac.auckland.se281;

public class MasterType implements DifficultyType {

  private Strategy master;

  public MasterType() {}

  public void setStrategy(Strategy strategy) {
    this.master = strategy;
  }

  public void changeStrategy(Morra game) {
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
  public String[] getJavisInput() {
    return master.decideJavisInput();
  }
}
