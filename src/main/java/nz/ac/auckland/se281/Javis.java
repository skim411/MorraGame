package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Javis {
    private DifficultyFactory difficulty;
    private Strategy strategy;

    public Javis(DifficultyType difficultyType) {
        this.difficulty = difficultyType;
    }

    public String[] getJavisInput() {
        return strategy.decideJavisInput();
    }
}
