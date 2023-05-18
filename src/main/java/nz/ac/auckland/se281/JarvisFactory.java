package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class JarvisFactory {
    public DifficultyLevel createDifficulty(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return new EasyLevel(new RandomStrategy());
        
            case MEDIUM:
                return new MediumLevel(new AverageStrategy());

            case HARD:
                return new HardLevel(new TopStrategy());

            case MASTER:
                return new MasterType(new RandomStrategy());
            
            default:
                return null;
        }
    }
}

