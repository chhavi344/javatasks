import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static boolean playRound(Scanner sc, Random rand) {
        int numberToGuess = rand.nextInt(100) + 1;
        int maxAttempts = 7;

        System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts!");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Attempt " + attempt + ": Enter your guess: ");
            int guess;

            try {
                guess = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine(); // clear invalid input
                attempt--; // don't count invalid attempt
                continue;
            }

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("🎉 Correct! You guessed the number in " + attempt + " attempts.");
                return true;
            }
        }

        System.out.println("❌ Out of attempts! The correct number was: " + numberToGuess);
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("===== Welcome to the Number Guessing Game =====");

        while (true) {
            roundsPlayed++;
            System.out.println("\n--- Round " + roundsPlayed + " ---");

            boolean won = playRound(sc, rand);
            if (won) {
                roundsWon++;
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            sc.nextLine(); // consume leftover newline
            String response = sc.nextLine().trim().toLowerCase();

            if (!response.equals("yes")) {
                break;
            }
        }

        System.out.println("\n🏁 Game Over!");
        System.out.println("Total Rounds Played: " + roundsPlayed);
        System.out.println("Total Rounds Won: " + roundsWon);

        sc.close();
    }
}
