package nz.ac.auckland.se281;

public class EasyLevel implements DifficultyLevel {

    private Strategy random;

    public EasyLevel(Strategy strategy) {
        this.random = strategy;
    }

    @Override
    public String[] getJavisInput() {
        return random.decideJavisInput();
    }
}