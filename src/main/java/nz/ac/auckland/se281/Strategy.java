package nz.ac.auckland.se281;

import java.util.List;

public interface Strategy {
  String[] decideJarvisHand(int numOfRound, Human player);

  List<String> getHistoryPlayerFingers(Human player);
}
