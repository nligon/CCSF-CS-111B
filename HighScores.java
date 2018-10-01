import java.util.ArrayList;
import java.util.Scanner;

public class HighScores {

  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Integer> scores = new ArrayList<>();
    initialize(names, scores);
    sort(names, scores);
    display(names, scores);
  }

  public static void initialize(ArrayList<String> names, ArrayList<Integer> scores) {
    Scanner input = new Scanner(System.in);
    for (int i = 0; i < 5; i++) {
      System.out.print("Enter the name for score #" + (i + 1) + ": ");
      names.add(input.nextLine());
      System.out.print("Enter the score for score #" + (i + 1) + ": ");
      scores.add(input.nextInt());
      input.nextLine();
    }
  }

  public static void sort(ArrayList<String> names, ArrayList<Integer> scores) {
    String tempName;
    int tempScore;
    boolean sorted = false;
    while (sorted == false) {
      sorted = true;
      for (int i = 0; i < 4; i++) {
        if (scores.get(i) < scores.get(i + 1)) {
          sorted = false;
          tempScore = scores.get(i);
          tempName = names.get(i);
          scores.set(i, scores.get(i + 1));
          names.set(i, names.get(i + 1));
          scores.set(i + 1, tempScore);
          names.set(i + 1, tempName);
        }
      }
    }
  }

  public static void display(ArrayList<String> names, ArrayList<Integer> scores) {
    System.out.println("\nTop Scorers:");
    for (int i = 0; i < names.size(); i++) {
      System.out.println(names.get(i) + ": " + scores.get(i));
    }
  }
  
}