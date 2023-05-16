package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Human {

  private String[] humanInput;
  private List<String> historyInput = new ArrayList<>();

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
        historyInput.add(input);
      }
    }
    return humanInput;
  }

  public List<String> getHistoryInput() {
    return historyInput;
  }

  public Boolean checkInput(String input) {
    // check player's input
    Boolean validInput = false;
    int playerFingers = Integer.parseInt(humanInput[0]);
    int playerSum = Integer.parseInt(humanInput[1]);
    // if input is not integer, return false
    if (Utils.isInteger(input)) {
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
    for (String input : historyInput) {
      String[] inputSplit = input.split(" ", 2);
      int playerFingers = Integer.parseInt(inputSplit[0]);
      sum += playerFingers;
    }
    averageFingers = sum / historyInput.size();
    return averageFingers;
  }

  // get most frequent fingers of player
  public int getMostFrequentFingers() {
    int maxCount = 0;
    int fingersMaxFreq = 0;
    for (int i = 0; i < historyInput.size(); i++) {
      String[] inputSplit = historyInput.get(i).split(" ", 2);
      int playerFingers = Integer.parseInt(inputSplit[0]);
      int count = 0;
      for (int j = 0; j < historyInput.size(); j++) {
        String[] inputSplit2 = historyInput.get(j).split(" ", 2);
        int playerFingers2 = Integer.parseInt(inputSplit2[0]);
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
