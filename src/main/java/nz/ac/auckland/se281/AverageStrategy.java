package nz.ac.auckland.se281;

public class AverageStrategy implements Strategy{

    @Override
    public String[] decideJavisInput() {
        String[] averageInput = new String[2];
        averageInput[0] = Integer.toString(Utils.getRandomNumber(1, 5));
        int javisFingers = Integer.valueOf(averageInput[0]);
        Human player = new Human();
        int avg = player.getAverageFingers();        
        averageInput[1] = Integer.toString(javisFingers + avg);
        return averageInput;
    }
    
}
