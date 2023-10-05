import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random generator = new Random();

        int num;
        int guess;

        while (true) {
            guess = -1;
            num = generator.nextInt() % 100 + 1;
            if (num < 0) num *= -1;

            while (guess != num) {
                System.out.printf("\nPlease enter a guess between 1-100: ");

                try {
                    guess = in.nextInt();

                } catch(Exception e) {
                    break;
                }

                if (guess > num)
                    System.out.printf("Your guess is too high!\n");
                else if (guess < num)
                    System.out.printf("Your guess is too low!\n");
            }

            if (guess == -1) {
                break;
            }

            System.out.printf("You guessed correctly!");
        }

    }

}
