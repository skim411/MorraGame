package nz.ac.auckland.se281;

public class EasyType implements DifficultyType {

    @Override
    public void getStrategy() {
        RandomStrategy random = new RandomStrategy();
        String[] randomInput = random.decideJavisInput();
        MessageCli.PRINT_INFO_HAND.printMessage("Javis", randomInput[0], randomInput[1]);
    }
}
