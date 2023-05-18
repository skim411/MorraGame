package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  private int numOfRound;

  public TopStrategy() {}

  public int getMostFreqPlayerFingers(Human player) {
    return player.getMostFrequentFingers();
  }

  public int getNumOfRound(Morra game) {
    numOfRound = game.getRound();
    return numOfRound;
  }

  @Override
  public String[] decideJarvisHand() {
    String[] topJavisHand = new String[2];
    topJavisHand[0] = Integer.toString(Utils.getRandomNumber(1, 5));
    int jarvisFingers = Integer.valueOf(topJavisHand[0]);
    // if number of round is less than 5, jarvis will randomly choose a number
    if (numOfRound <= 4) {
      int min = jarvisFingers + 1;
      int max = jarvisFingers + 5;
      topJavisHand[1] = Integer.toString(Utils.getRandomNumber(min, max));
    } else {
      // if number of round is greater or equal to 5, jarvis will get the most common fingers
      // that player has played
      int mostCommonFingers = getMostFreqPlayerFingers(new Human());
      topJavisHand[1] = Integer.toString(jarvisFingers + mostCommonFingers);
    }
    return topJavisHand;
  }
}
