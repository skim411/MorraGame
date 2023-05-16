package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

    public DifficultyType createDifficulty(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return new EasyType();
        
            case MEDIUM:
                return new MediumType();

            case HARD:
                return new HardType();
            
            default:
                return null;
        }
    }
}
