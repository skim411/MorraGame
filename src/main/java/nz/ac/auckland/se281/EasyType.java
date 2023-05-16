package nz.ac.auckland.se281;

public class EasyType implements DifficultyType {

    private String[] randomJavisInput;

    public Strategy getStrategy() {
        RandomStrategy random = new RandomStrategy();
        return random;
    }

    @Override
    public String[] getJavisInput() {
        Strategy random = getStrategy();
        randomJavisInput = random.decideJavisInput();
        // MessageCli.PRINT_INFO_HAND.printMessage("Javis", randomJavisInput[0], randomJavisInput[1]);
        return randomJavisInput;
    }
}
