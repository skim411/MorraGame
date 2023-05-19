package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class JarvisFactory {

  public static DifficultyLevel createDifficulty(int numOfRound, Difficulty difficulty, Human player) {
    // create different difficulty level based on the input
    switch (difficulty) {
      case EASY:
        return new EasyLevel();

      case MEDIUM:
        return new MediumLevel(numOfRound, player);

      case HARD:
        return new HardLevel(numOfRound, player);

      case MASTER:
        return new MasterLevel(numOfRound, player);

      default:
        return null;
    }
  }
}
