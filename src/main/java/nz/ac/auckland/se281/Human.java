package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Human {

  private String[] playerHand;
  private List<String> historyPlayerFingers = new ArrayList<>();
  private Boolean validInput;

  public String[] getPlayerHand() {
    validInput = false;

    while (!validInput) {
      // scan player's input
      String input = Utils.scanner.nextLine();
      // split input to 2 and name first substring as playerFingers and second as playerSum
      playerHand = input.split(" ", 2);
      validInput = checkInput(playerHand);
      if (!validInput) {
        MessageCli.INVALID_INPUT.printMessage();
        MessageCli.ASK_INPUT.printMessage();
      } else {
        historyPlayerFingers.add(playerHand[0]);
      }
    }
    return playerHand;
  }

  public List<String> getHistoryPlayerFingers() {
    return historyPlayerFingers;
  }

  public Boolean checkInput(String[] playerHand) {
    // if size of playerFinger is not equal to 2, return false
    if (playerHand.length != 2) {
      validInput = false;
      // if input is not integer, return false
    } else if (!Utils.isInteger(playerHand[0]) || !Utils.isInteger(playerHand[1])) {
      validInput = false;
      // if fingers is not between 1 and 5 or sum is not between 1 and 10, return false
    } else if ((Integer.valueOf(playerHand[0]) < 1)
        || (Integer.valueOf(playerHand[0]) > 5)
        || (Integer.valueOf(playerHand[1]) < 1)
        || (Integer.valueOf(playerHand[1]) > 10)) {
      validInput = false;
    } else {
      validInput = true;
    }
    return validInput;
  }
}
