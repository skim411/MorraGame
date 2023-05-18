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
  public String[] decideJarvisHand() {
    String[] averageJavisHand = new String[2];
    averageJavisHand[0] = Integer.toString(Utils.getRandomNumber(1, 5));
    int jarvisFingers = Integer.valueOf(averageJavisHand[0]);

    // if number of round is less than 5, jarvis will randomly choose sum
    if (numOfRound <= 4) {
      int min = jarvisFingers + 1;
      int max = jarvisFingers + 5;
      averageJavisHand[1] = Integer.toString(Utils.getRandomNumber(min, max));
    } else {
      // if number of round is greater or equal to 5, jarvis will get the average fingers that
      // player has played
      int avg = getAveragePlayerFingers(new Human());
      averageJavisHand[1] = Integer.toString(jarvisFingers + avg);
    }
    return averageJavisHand;
  }
}
