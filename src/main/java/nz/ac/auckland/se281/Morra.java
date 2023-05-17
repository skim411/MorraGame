package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int numOfRound;
  private String player;
  private Difficulty currentDifficulty;
  private String[] humanInput;
  private String[] javisInput;
  private int playerScore;
  private int javisScore;
  private int requiredPointsToWin;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    player = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    currentDifficulty = difficulty;
    playerScore = 0;
    javisScore = 0;
    numOfRound = 0;
    requiredPointsToWin = pointsToWin;
  }

  public String getPlayerName() {
    return player;
  }

  public void play() {
    numOfRound++;
    MessageCli.START_ROUND.printMessage(Integer.toString(numOfRound));
    MessageCli.ASK_INPUT.printMessage();

    Human human = new Human();
    JavisFactory javisFactory = new JavisFactory();
    DifficultyType difficultyType = javisFactory.createDifficulty(currentDifficulty);

    humanInput = human.getHumanInput();
    javisInput = difficultyType.getJavisInput();
    MessageCli.PRINT_INFO_HAND.printMessage(player, humanInput[0], humanInput[1]);
    MessageCli.PRINT_INFO_HAND.printMessage("Javis", javisInput[0], javisInput[1]);
    getResult(javisInput, humanInput);
  }

  public void getResult(String[] javisInput, String[] humanInput) {
    int javisFinger = Integer.valueOf(javisInput[0]);
    int humanFinger = Integer.valueOf(humanInput[0]);
    int sum = javisFinger + humanFinger;
    if (sum == Integer.valueOf(javisInput[1])) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WIN");
      javisScore++;
    } else if (sum == Integer.valueOf(humanInput[1])) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WIN");
      playerScore++;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
    if (javisScore == requiredPointsToWin) {
      MessageCli.END_GAME.printMessage("Javis", String.valueOf(numOfRound));
    } else if (playerScore == requiredPointsToWin) {
      MessageCli.END_GAME.printMessage(player, String.valueOf(numOfRound));
    }
  }

  public int getRound() {
    return numOfRound;
  }

  public void showStats() {}
}
