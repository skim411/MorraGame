package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int numOfRound = 0;
  private String player;
  private int playerFingers;
  private int playerSum;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    player = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    numOfRound++;
    MessageCli.START_ROUND.printMessage(Integer.toString(numOfRound));
    MessageCli.ASK_INPUT.printMessage();
    Boolean validInput = false;
    
    while (!validInput) {
      // scan player's input
      String input = Utils.scanner.nextLine();
      // split input to 2 and name first substring as playerFingers and second as playerSum
      String[] finAndSum = input.split(" ", 2);
      playerFingers = Integer.parseInt(finAndSum[0]);
      playerSum = Integer.parseInt(finAndSum[1]);
      validInput = checkInput(input);
      if (!validInput) {
        MessageCli.INVALID_INPUT.printMessage();
        MessageCli.ASK_INPUT.printMessage();
      } else if (validInput) {
        MessageCli.PRINT_INFO_HAND.printMessage(player, Integer.toString(playerFingers),
        Integer.toString(playerSum));
      }
    }
  }

  public Boolean checkInput(String input) {
    // check player's input
    Boolean validInput = false;
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

  public void showStats() {}
}
