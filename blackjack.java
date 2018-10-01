import java.util.Scanner;
import java.util.Random;

public class Blackjack {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int PCard1 = rand.nextInt(9) + 1, PCard2 = rand.nextInt(9) + 1, DCard = rand.nextInt(9) + 1;
        int PHand = 0, DHand = 0;
        char HitMe = 'y';
        char Cont = 'c';
        char PlayAgain = 'y';

        while (PlayAgain != 'n') {
            PHand = 0;
            DHand = 0;
            PHand = PHand + PCard1 + PCard2;
            DHand = DHand + DCard;
            System.out.println("The dealer starts with a " + DCard + ". ");
            System.out.println("Your first cards: " + PCard1 + ", " + PCard2 + ". ");
            System.out.print("Total: " + PHand);
            System.out.print("\nHit? [y/n]: ");
            HitMe = input.next().charAt(0);
            while (HitMe != 'n') {
                PCard1 = rand.nextInt(9) + 1;
                PHand = PHand + PCard1;
                System.out.print("Card: " + PCard1);
                System.out.print("\nTotal: " + PHand);
                if (PHand == 21) {
                    System.out.print("\nPlayer wins! ");
                    Cont = 'n';
                    HitMe = 'n';
                } else if (PHand > 21) {
                        System.out.println("\nDealer wins!");
                        HitMe = 'n';
                        Cont = 'n';
                    } else {
                        System.out.print("\nHit? [y/n]: ");
                        HitMe = input.next().charAt(0);
                    }
            }

            while (Cont != 'n') {
                System.out.print("Dealer has a " + DHand + "... ");
                System.out.print("\n(c to continue) ");
                Cont = input.next().charAt(0);
                while (Cont != 'n') {
                    DCard = rand.nextInt(9) + 1;
                    DHand = DHand + DCard;
                    System.out.print("Dealer gets a " + DCard);
                    System.out.print("\nTotal: " + DHand);
                    if (DHand == 21) {
                        System.out.print("\nDealer wins! ");
                        Cont = 'n';
                    } else if (DHand > 21) {
                        System.out.print("\nPlayer wins!");
                        Cont = 'n';
                    } else {
                        System.out.print("\n(c to continue) ");
                        Cont = input.next().charAt(0);
                    }
                }
            }

            System.out.print("\nPlay again? [y/n]: ");
            PlayAgain = input.next().charAt(0);
            Cont = 'c';
            HitMe = 'y';
        }
    }
}