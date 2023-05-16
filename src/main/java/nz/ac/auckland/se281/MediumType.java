package nz.ac.auckland.se281;

public class MediumType implements DifficultyType {

    @Override
    public void getStrategy() {
        AverageStrategy average = new AverageStrategy();
        String[] averageInput = average.decideJavisInput();
        MessageCli.PRINT_INFO_HAND.printMessage("Javis", averageInput[0], averageInput[1]);
    }
    
}
