package nz.ac.auckland.se281;

public class HardLevel implements DifficultyLevel {

    private String[] topJavisInput;
    private Strategy top = new TopStrategy();

    public HardLevel(Strategy strategy) {
        this.top = strategy;
    }

    @Override
    public String[] getJavisInput() {
        topJavisInput = top.decideJavisInput();
        return topJavisInput;
    }
}
