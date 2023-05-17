package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int numOfRound;
  private String player;
  private Difficulty currentDifficulty;
  private String[] humanInput;
  private String[] jarvisInput;
  private int playerScore;
  private int jarvisScore;
  private int requiredPointsToWin;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    player = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    currentDifficulty = difficulty;
    playerScore = 0;
    jarvisScore = 0;
    numOfRound = 0;
    requiredPointsToWin = pointsToWin;
  }

  public String getPlayerName() {
    return player;
  }

  public void play() {
    if (jarvisScore == requiredPointsToWin || playerScore == requiredPointsToWin) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      numOfRound++;
      MessageCli.START_ROUND.printMessage(Integer.toString(numOfRound));
      MessageCli.ASK_INPUT.printMessage();

      Human human = new Human();
      JarvisFactory jarvisFactory = new JarvisFactory();
      DifficultyLevel difficultyType = jarvisFactory.createDifficulty(currentDifficulty);

      jarvisInput = difficultyType.getJarvisInput();
      humanInput = human.getHumanInput();

      MessageCli.PRINT_INFO_HAND.printMessage(player, humanInput[0], humanInput[1]);
      MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", jarvisInput[0], jarvisInput[1]);
      getResult(jarvisInput, humanInput);
    }
  }

  public void getResult(String[] jarvisInput, String[] humanInput) {
    int jarvisFinger = Integer.valueOf(jarvisInput[0]);
    int humanFinger = Integer.valueOf(humanInput[0]);
    int sum = jarvisFinger + humanFinger;
    if (sum == Integer.valueOf(jarvisInput[1])) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      jarvisScore++;
    } else if (sum == Integer.valueOf(humanInput[1])) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      playerScore++;
    } else if (sum == Integer.valueOf(humanInput[1]) && sum == Integer.valueOf(jarvisInput[1])) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
    if (jarvisScore == requiredPointsToWin) {
      MessageCli.END_GAME.printMessage("Jarvis", String.valueOf(numOfRound));
      numOfRound = 0;
    } else if (playerScore == requiredPointsToWin) {
      MessageCli.END_GAME.printMessage(player, String.valueOf(numOfRound));
      numOfRound = 0;
    }
  }

  public int getRound() {
    return numOfRound;
  }

  public void showStats() {
    if (numOfRound == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      int numOfRoundToPlayerWin = requiredPointsToWin - playerScore;
      int numOfRoundToJarvisWin = requiredPointsToWin - jarvisScore;
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          player, Integer.toString(playerScore), Integer.toString(numOfRoundToPlayerWin));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "Jarvis", Integer.toString(jarvisScore), Integer.toString(numOfRoundToJarvisWin));
    }
  }
}
