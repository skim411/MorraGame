package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  private int numOfRound;

  public TopStrategy() {
  }

  public int getMostCommonFingers(Human player) {
    return player.getMostFrequentFingers();
  }
  
  public int getNumOfRound(Morra game) {
    numOfRound = game.getRound();
    return numOfRound;
  }

  @Override
  public String[] decideJavisInput() {
    String[] topInput = new String[2];
    topInput[0] = Integer.toString(Utils.getRandomNumber(1, 5));
    int javisFingers = Integer.valueOf(topInput[0]);
    if (numOfRound <= 4) {
      int min = javisFingers + 1;
      int max = javisFingers + 5;
      topInput[1] = Integer.toString(Utils.getRandomNumber(min, max));
    } else {
      int mostCommonFingers = getMostCommonFingers(new Human());
      topInput[1] = Integer.toString(javisFingers + mostCommonFingers);
    }
    return topInput;
  }
}
