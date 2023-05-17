package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public String[] decideJarvisInput() {
    String[] randomInput = new String[2];
    randomInput[0] = Integer.toString(Utils.getRandomNumber(1, 5));
    int min = Integer.valueOf(randomInput[0]) + 1;
    int max = Integer.valueOf(randomInput[0]) + 5;
    randomInput[1] = Integer.toString(Utils.getRandomNumber(min, max));
    return randomInput;
  }
}
