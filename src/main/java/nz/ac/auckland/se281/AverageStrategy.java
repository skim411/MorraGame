package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy implements Strategy {

  List<String> historyPlayerFingers;

  @Override
  public String[] decideJarvisHand(int numOfRound, Human player) {
    String[] averageJavisHand = new String[2];
    averageJavisHand[0] = Integer.toString(Utils.getRandomNumber(1, 5));
    int jarvisFingers = Integer.valueOf(averageJavisHand[0]);

    // if number of round is less than 5, jarvis will randomly choose sum
    if (numOfRound < 4) {
      int min = jarvisFingers + 1;
      int max = jarvisFingers + 5;
      averageJavisHand[1] = Integer.toString(Utils.getRandomNumber(min, max));
    } else {
      // if number of round is greater or equal to 5, jarvis will get the average fingers that
      // player has played
      System.out.println(jarvisFingers);
      getHistoryPlayerFingers(player);
      int avg = getAverageFingers();
      averageJavisHand[1] = Integer.toString(jarvisFingers + avg);
    }
    return averageJavisHand;
  }

  @Override
  public List<String> getHistoryPlayerFingers(Human player) {
    historyPlayerFingers = player.getHistoryPlayerFingers();
    return historyPlayerFingers;
  }

  // get average of player's fingers
  public int getAverageFingers() {
    int sum = 0;
    for (String fingers : historyPlayerFingers) {
      sum += Integer.valueOf(fingers);
    }
    double averageFingers = Math.round((double) sum / historyPlayerFingers.size());
    return (int) averageFingers;
  }
}
