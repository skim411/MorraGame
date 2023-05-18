package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public String[] decideJarvisHand() {
    // select fingers of Javis and sum of Javis's and Human's hand randomly
    String[] randomJavisHand = new String[2];
    randomJavisHand[0] = Integer.toString(Utils.getRandomNumber(1, 5));
    int min = Integer.valueOf(randomJavisHand[0]) + 1;
    int max = Integer.valueOf(randomJavisHand[0]) + 5;
    randomJavisHand[1] = Integer.toString(Utils.getRandomNumber(min, max));
    return randomJavisHand;
  }
}
