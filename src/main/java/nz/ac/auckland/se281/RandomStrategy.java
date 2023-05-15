package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy{

    @Override
    public String[] decideJavisInput() {
        String[] javisInput = new String[2];
        javisInput[0] = Integer.toString(Utils.getRandomNumber(1, 5));
        
        return null;
    }
    
}
