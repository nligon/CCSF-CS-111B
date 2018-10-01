import java.util.Scanner;
import java.lang.Math;

public class NumberGuesserRandom {

  static char hlc;
  static char playAgain;
  static int low = 1;
  static int high = 101; // Because the Java interpreter rounds down, a value of 100 will never be reached unless this value incremented to be one integer higher than the intended range.
  static int guess;
  static Scanner input = new Scanner(System.in);

  public static char getUserResponseToGuess(int guess) {
    System.out.print("Is it " + guess + "?  (h / l / c) : ");
    hlc = input.next().charAt(0);
    return hlc;
  }

  public static int getRandomMidpoint(int low, int high) {
    guess = (int) (Math.random() * ((high - low) + 1)) + low;
    return guess;
  }

  public static void playOneGame () {
    low = 1;
    high = 100;
    hlc = 'a';
    System.out.println("Guess a number between 1 and 100.");

    while (hlc != 'c') {
      guess = getRandomMidpoint(low, high);
      getUserResponseToGuess(guess);

      if (hlc == 'h') {
        high = guess;
      } else if (hlc == 'l') {
        low = guess;
      } else if (hlc == 'c') {
        break;
      } else {
        System.out.println("Please enter 'h' for high, 'l' for low, or 'c' for correct.");
      }
    }

    return;
  }

  public static boolean shouldPlayAgain () {
    System.out.print("Great! Do you want to play again ? (y / n) : ");
    playAgain = input.next().charAt(0);

    if (playAgain == 'y') {
      return true;
    } else {
      System.out.println("Thanks for playing. Have a great day!");
      return false;
    }
  }

  public static void main(String[] args) {
    do {
      playOneGame();
    } while (
      shouldPlayAgain()
    );
  }

}