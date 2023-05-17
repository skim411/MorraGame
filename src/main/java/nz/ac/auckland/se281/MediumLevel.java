package nz.ac.auckland.se281;

public class MediumLevel implements DifficultyLevel {
    
    private String[] averageJavisInput;
    private Strategy average = new AverageStrategy();

    public MediumLevel(Strategy strategy) {
        this.average = strategy;
    }

    public String[] getJavisInput() {
        averageJavisInput = average.decideJavisInput();
        return averageJavisInput;
    }
}
