package nz.ac.auckland.se281;

public class HardType implements DifficultyType {

    @Override
    public void getStrategy() {
        TopStrategy top = new TopStrategy();
        String[] topInput = top.decideJavisInput();
        MessageCli.PRINT_INFO_HAND.printMessage("Javis", topInput[0], topInput[1]);
    }
}
