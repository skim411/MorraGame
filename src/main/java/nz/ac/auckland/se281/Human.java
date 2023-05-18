package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Human {

  private String[] playerHand;
  private List<String> historyPlayerFingers = new ArrayList<>();

  public String[] getPlayerHand() {
    Boolean validInput = false;

    while (!validInput) {
      // scan player's input
      String input = Utils.scanner.nextLine();
      // split input to 2 and name first substring as playerFingers and second as playerSum
      playerHand = input.split(" ", 2);
      validInput = checkInput(input);
      if (!validInput) {
        MessageCli.INVALID_INPUT.printMessage();
        MessageCli.ASK_INPUT.printMessage();
      } else {
        historyPlayerFingers.add(playerHand[0]);
      }
    }
    return playerHand;
  }

  // public List<String> getHistoryInput() {
  //   return historyHumanInput;
  // }

  public Boolean checkInput(String input) {
    // check player's input
    Boolean validInput = false;
    int playerFingers = Integer.valueOf(playerHand[0]);
    int playerSum = Integer.valueOf(playerHand[1]);
    // if input is not integer, return false
    if (!Utils.isInteger(playerHand[0]) || !Utils.isInteger(playerHand[1])) {
      validInput = false;
      // if fingers is not between 1 and 5 or sum is not between 1 and 10, return false
    } else if ((playerFingers < 1) || (playerFingers > 5) || (playerSum < 1) || (playerSum > 10)) {
      validInput = false;
    } else {
      validInput = true;
    }
    return validInput;
  }

  // get average of player's fingers
  public int getAverageFingers() {
    int averageFingers = 0;
    int sum = 0;
    for (String fingers : historyPlayerFingers) {
      sum += Integer.valueOf(fingers);
    }
    averageFingers = sum / historyPlayerFingers.size();
    return Math.round(averageFingers);
  }

  // get most frequent fingers of player
  public int getMostFrequentFingers() {
    int maxCount = 0;
    int maxFreqFingers = 0;
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
