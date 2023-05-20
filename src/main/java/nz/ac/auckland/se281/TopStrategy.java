package nz.ac.auckland.se281;

import java.util.List;

public class TopStrategy implements Strategy {

  private List<String> historyPlayerFingers;
  private int numOfRound;

  public TopStrategy(int numOfRound, Human player) {
    this.numOfRound = numOfRound;
    this.historyPlayerFingers = player.getHistoryPlayerFingers();
  }

  @Override
  public String[] decideJarvisHand() {
    String[] topJavisHand = new String[2];
    topJavisHand[0] = Integer.toString(Utils.getRandomNumber(1, 5));
    int jarvisFingers = Integer.valueOf(topJavisHand[0]);
    // if number of round is less than 4, jarvis will randomly choose a number
    if (numOfRound < 4) {
      int min = jarvisFingers + 1;
      int max = jarvisFingers + 5;
      topJavisHand[1] = Integer.toString(Utils.getRandomNumber(min, max));
    } else {
      // if number of round is greater or equal to 4, jarvis will get the most common fingers
      // that player played
      int mostCommonFingers = getMostFrequentFingers();
      topJavisHand[1] = Integer.toString(jarvisFingers + mostCommonFingers);
    }
    return topJavisHand;
  }

  // get most frequent fingers of player
  public int getMostFrequentFingers() {
    int maxCount = 0;
    int maxFreqFingers = 0;
    // loop through historyPlayerFingers to get the most frequent fingers
    for (int i = 0; i < historyPlayerFingers.size(); i++) {
      int playerFingers = Integer.valueOf(historyPlayerFingers.get(i));
      int count = 0;
      for (int j = 0; j < historyPlayerFingers.size(); j++) {
        int comparedFingers = Integer.valueOf(historyPlayerFingers.get(j));
        if (playerFingers == comparedFingers) {
          count++;
        }
      }
      if (count > maxCount) {
        maxCount = count;
        maxFreqFingers = playerFingers;
      }
    }
    return maxFreqFingers;
  }
}
