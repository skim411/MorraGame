package nz.ac.auckland.se281;

public class MasterLevel implements DifficultyLevel {

  private Strategy master;
  private int numOfRound;
  private Human player;

  public MasterLevel(int numOfRound, Human player) {
    this.player = player;
    this.numOfRound = numOfRound;
  }

  public void setStrategy(Strategy strategy) {
    this.master = strategy;
  }

  public void changeStrategy() {
    // change strategy based on the number of round
    if (numOfRound <= 3) {
        setStrategy(new RandomStrategy());
    } else if (numOfRound > 3 && numOfRound % 2 == 0) {
        setStrategy(new AverageStrategy(numOfRound, player));
    } else {
        setStrategy(new TopStrategy(numOfRound, player));
    }
  }

  @Override
  public String[] getJarvisHand() {
    changeStrategy();
    return master.decideJarvisHand();
  }
}
