package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int numOfRound;
  private String playerName;
  private Difficulty currentDifficulty;
  private String[] playerHand;
  private String[] jarvisHand;
  private int playerScore;
  private int jarvisScore;
  private int requiredPointsToWin;
  private Human player;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    // reset all the variables to start a new game
    playerScore = 0;
    jarvisScore = 0;
    numOfRound = 0;
    requiredPointsToWin = pointsToWin;
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    currentDifficulty = difficulty;
    player = new Human();
  }

  public void play() {
    // check if the game is over or not
    if (jarvisScore == requiredPointsToWin || playerScore == requiredPointsToWin) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      this.numOfRound++;
      MessageCli.START_ROUND.printMessage(Integer.toString(numOfRound));
      MessageCli.ASK_INPUT.printMessage();

      DifficultyLevel difficultyLevel =
          JarvisFactory.createDifficulty(numOfRound, currentDifficulty, player);

      // get the fingers and sum from player and jarvis
      jarvisHand = difficultyLevel.getJarvisHand();
      playerHand = player.getPlayerHand();

      MessageCli.PRINT_INFO_HAND.printMessage(playerName, playerHand[0], playerHand[1]);
      MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", jarvisHand[0], jarvisHand[1]);
      getResult(jarvisHand, playerHand);
    }
  }

  public void getResult(String[] jarvisHand, String[] playerHand) {
    // get the sum of fingers from jarvis and human
    int sum = Integer.valueOf(jarvisHand[0]) + Integer.valueOf(playerHand[0]);
    Boolean jarvisWin = (sum == Integer.valueOf(jarvisHand[1]));
    Boolean playerWin = (sum == Integer.valueOf(playerHand[1]));
    // print the result of the round and update the score
    if ((playerWin && jarvisWin) || (!playerWin && !jarvisWin)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    } else if (jarvisWin) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      jarvisScore++;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      playerScore++;
    }

    // if the game is over, print the winner and set number of round as 0
    if (jarvisScore == requiredPointsToWin) {
      MessageCli.END_GAME.printMessage("Jarvis", String.valueOf(numOfRound));
      numOfRound = 0;
    } else if (playerScore == requiredPointsToWin) {
      MessageCli.END_GAME.printMessage(playerName, String.valueOf(numOfRound));
      numOfRound = 0;
    }
  }

  public void showStats() {
    // if game is not started, show stats will not work
    if (numOfRound == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      int numOfRoundToPlayerWin = requiredPointsToWin - playerScore;
      int numOfRoundToJarvisWin = requiredPointsToWin - jarvisScore;
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          playerName, Integer.toString(playerScore), Integer.toString(numOfRoundToPlayerWin));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "Jarvis", Integer.toString(jarvisScore), Integer.toString(numOfRoundToJarvisWin));
    }
  }
}
