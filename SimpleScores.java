import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SimpleScores {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();

        do {
            fillArrays(names, scores);

            System.out.println("Before:");
            display(names, scores);

            largestFirst(names, scores);

            System.out.println("After:");
            display(names, scores);

            scores.clear();
            names.clear();
        } while (shouldGoAgain());
    }

    public static void fillArrays(ArrayList<String> names, ArrayList<Integer> scores) {
        names.add("Ann");
        names.add("Tom");
        names.add("Kim");
        names.add("Wen");

        randomScores(scores, 4);
    }

    private static boolean shouldGoAgain() {
        Scanner input = new Scanner(System.in);
        String response = "x";


        while (!response.equals("y") && !response.equals("n")) {
            System.out.print("Go again? (y/n): ");
            response = input.nextLine();
        }

        return response.equals("y");
    }

    public static void randomScores(ArrayList<Integer> scores, int count) {

        Random random = new Random();

        for (int i = 0; i < count; i++) {
            scores.add(random.nextInt(100));
        }
    }

    public static void display(ArrayList<String> names, ArrayList<Integer> scores) {

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + ":\t" + scores.get(i));
        }
    }

    private static void largestFirst(ArrayList<String> names, ArrayList<Integer> scores) {
        int i = indexOfLargest(scores);

        swap(names, scores, 0, i);
    }

    public static int indexOfLargest(ArrayList<Integer> scores) {
        int indexOfLargest = 0;

        for (int i = 1; i < scores.size(); i++) {
            if (scores.get(i) > scores.get(indexOfLargest)) {
                indexOfLargest = i;
            }
        }

        return indexOfLargest;
    }

    public static void swap(ArrayList<String> names, ArrayList<Integer> scores, int i1, int i2) {
        String tempName = names.get(i1);
        int tempScore = scores.get(i1);

        scores.set(i1, scores.get(i2));
        names.set(i1, names.get(i2));

        names.set(i2, tempName);
        scores.set(i2, tempScore);
    }
}