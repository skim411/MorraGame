package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class JarvisFactory {
  public static DifficultyLevel createDifficulty(int numOfRound, Difficulty difficulty) {
    // create different difficulty level based on the input
    switch (difficulty) {
      case EASY:
        return new EasyLevel(new RandomStrategy());

      case MEDIUM:
        return new MediumLevel(new AverageStrategy());

      case HARD:
        return new HardLevel(new TopStrategy());

      case MASTER:
        if (numOfRound <= 3) {
          return new MasterLevel(new RandomStrategy());
        } else if (numOfRound > 3 && numOfRound % 2 == 0) {
          return new MasterLevel(new AverageStrategy());
        } else {
          return new MasterLevel(new TopStrategy());
        }

      default:
        return null;
    }
  }
}
