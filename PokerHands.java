import java.util.Scanner;

public class PokerHands {

  static int[] hand = new int[5];
  static int[] duplicates = new int [10]; // Treating this like an object to allow single iteration / O(1) time complexity
  static Scanner input = new Scanner(System.in);

  public static int[] getHand() {
    for (int i = 0 ; i < hand.length; i++ ) {
      System.out.print("Card " + (i + 1) + ": ");
      hand[i] = input.nextInt();
      duplicates[hand[i]] = duplicates[hand[i]] + 1;
    }

    return hand;
  }

  // I really would have preferred to collect all needed information on the first iteration, but I felt like this assignment required or at least intended individual checks for each of the helper methods. That said, this 'contains' method and the duplicates array provide something of a compromise between efficiency and repetition. D.R.Y.!
  public static int contains (int num) {
    int counter = 0;

    for (int element : duplicates) {
      if (element == num) {
        counter++;
      };
    }

    return counter;
  }

  public static boolean containsPair(int hand[]) {
    return contains(2) > 0;
  }

  public static boolean containsTwoPair(int hand[]) {
    return contains(2) > 1;
  }

  public static boolean  containsThreeOfaKind(int hand[]) {
    return contains(3) > 0;
  }

  public static boolean containsStraight(int hand[]) {
    int counter = 0;
    for (int element : duplicates) {
      if (element == 1) {
        counter++;
      } else if (counter > 0 && counter < 5 && element != 1) {
        return false;
      }
    }
    return true;
  }


  public static boolean  containsFullHouse(int hand[]) {
    return (contains(3) > 0) && (contains(2) > 0);
  }

  public static boolean containsFourOfaKind(int hand[]) {
    return contains(4) > 0;
  }

  public static void main(String args[]) {
    System.out.println("Enter five numeric cards, no face cards. Use 2 - 9.");
    hand = getHand();

    if (containsFourOfaKind(hand)) {
      System.out.println("Four of a kind!");
    } else if (containsFullHouse(hand)) {
      System.out.println("Full house!");
    } else if (containsStraight(hand)) {
      System.out.println("Straight!");
    } else if (containsThreeOfaKind(hand)) {
      System.out.println("Three of a kind!");
    }  else if (containsTwoPair(hand)) {
      System.out.println("Two pair!");
    } else if (containsPair(hand)) {
      System.out.println("Pair!");
    } else {
      System.out.println("High card!");
    }
  }

}