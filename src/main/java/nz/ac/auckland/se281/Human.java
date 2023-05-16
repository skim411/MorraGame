package nz.ac.auckland.se281;

public class Human {

  private String[] humanInput;

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
      }
    }
    return humanInput;
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
}
