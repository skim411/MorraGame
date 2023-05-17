package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class JavisFactory {
    public DifficultyType createDifficulty(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return new EasyType(new RandomStrategy());
        
            case MEDIUM:
                return new MediumType(new AverageStrategy());

            case HARD:
                return new HardType(new TopStrategy());

            case MASTER:
                return new MasterType();
            
            default:
                return null;
        }
    }
}

