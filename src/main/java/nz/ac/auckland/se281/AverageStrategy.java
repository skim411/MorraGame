package nz.ac.auckland.se281;

public class AverageStrategy implements Strategy {

  private int numOfRound;

  public AverageStrategy() {}

  public int getAveragePlayerFingers(Human player) {
    return player.getAverageFingers();
  }

  public int getNumOfRound(Morra game) {
    numOfRound = game.getRound();
    return numOfRound;
  }

  @Override
  public String[] decideJarvisInput() {
    String[] averageInput = new String[2];
    averageInput[0] = Integer.toString(Utils.getRandomNumber(1, 5));
    int jarvisFingers = Integer.valueOf(averageInput[0]);

    if (numOfRound <= 4) {
      int min = jarvisFingers + 1;
      int max = jarvisFingers + 5;
      averageInput[1] = Integer.toString(Utils.getRandomNumber(min, max));
    } else {
      int avg = getAveragePlayerFingers(new Human());
      averageInput[1] = Integer.toString(jarvisFingers + avg);
    }
    return averageInput;
  }
}
