package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

    @Override
    public String[] decideJavisInput() {
        String[] topInput = new String[2];
        topInput[0] = Integer.toString(Utils.getRandomNumber(1, 5));
        int javisFingers = Integer.valueOf(topInput[0]);
        Human player = new Human();
        int mostCommonFingers = player.getMostFrequentFingers();        
        topInput[1] = Integer.toString(javisFingers + mostCommonFingers);
        return topInput;
    }
}
