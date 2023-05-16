package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Human {

  private String[] humanInput;
  private List<String> historyHumanInput = new ArrayList<>();

  public String[] getHumanInput(String playerName) {
    Boolean validInput = false;

    while (!validInput) {
      // scan player's input
      String input = Utils.scanner.nextLine();
      // split input to 2 and name first substring as playerFingers and second as playerSum
      humanInput = input.split(" ", 2);
      int playerFingers = Integer.parseInt(humanInput[0]);
      int playerSum = Integer.parseInt(humanInput[1]);
      validInput = checkInput(input);
      if (!validInput) {
        MessageCli.INVALID_INPUT.printMessage();
        MessageCli.ASK_INPUT.printMessage();
      } else if (validInput) {
        MessageCli.PRINT_INFO_HAND.printMessage(
            playerName, Integer.toString(playerFingers), Integer.toString(playerSum));
            historyHumanInput.add(humanInput[0]);
      }
    }
    return humanInput;
  }

  public List<String> getHistoryInput() {
    return historyHumanInput;
  }

  public Boolean checkInput(String input) {
    // check player's input
    Boolean validInput = false;
    int playerFingers = Integer.parseInt(humanInput[0]);
    int playerSum = Integer.parseInt(humanInput[1]);
    // if input is not integer, return false
    if (!Utils.isInteger(humanInput[0]) | !Utils.isInteger(humanInput[1])) {
      validInput = false;
      // if fingers is not between 1 and 5 or sum is not between 1 and 10, return false
    } else if ((playerFingers < 1) | (playerFingers > 5) | (playerSum < 1) | (playerSum > 10)) {
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
    for (String fingers : historyHumanInput) {
      sum += Integer.parseInt(fingers);
    }
    averageFingers = sum / historyHumanInput.size();
    return averageFingers;
  }

  // get most frequent fingers of player
  public int getMostFrequentFingers() {
    int maxCount = 0;
    int fingersMaxFreq = 0;
    for (int i = 0; i < historyHumanInput.size(); i++) {
      int playerFingers = Integer.parseInt(historyHumanInput.get(i));
      int count = 0;
      for (int j = 0; j < historyHumanInput.size(); j++) {
        int playerFingers2 = Integer.parseInt(historyHumanInput.get(j));
        if (playerFingers == playerFingers2) {
          count++;
        }
      }
      if (count > maxCount) {
        maxCount = count;
        fingersMaxFreq = playerFingers;
      }
    }
    return fingersMaxFreq;
  }
}
