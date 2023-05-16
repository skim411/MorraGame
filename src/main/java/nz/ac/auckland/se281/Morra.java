package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int numOfRound = 0;
  private String player;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    player = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public String getPlayerName() {
    return player;
  } 

  public void play() {
    numOfRound++;
    MessageCli.START_ROUND.printMessage(Integer.toString(numOfRound));
    MessageCli.ASK_INPUT.printMessage();

    Human human = new Human();
    // Javis javis = new Javis(new EasyLevel());
    String[] humanInput = human.getHumanInput(player);
    // String[] javisInput = javis.getJavisInput();


    
  }

  public void showStats() {}
}
