import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static String getRandomRockPaperOrScissors() {
        final String[] RockPaperScissors = {"rock", "paper", "scissors"};

        Random rng = new Random();

        int rngChoice =  rng.nextInt() % 3;

        if (rngChoice < 0)
            rngChoice *= -1;

        return RockPaperScissors[rngChoice];
    }

    public static boolean isRockPaperOrScissors(String str) {
        final String[] RockPaperScissors = {"rock", "paper", "scissors"};

        for (int i = 0; i < RockPaperScissors.length; i++)
            if (str.toLowerCase().equals(RockPaperScissors[i])) return true;
        return false;
    }

    public static boolean isExit(String str) {
        final String[] EXITLIST = {"exit", "quit"};

        for (int i = 0; i < EXITLIST.length; i++)
            if (str.toLowerCase().equals(EXITLIST[i])) return true;
        return false;
    }

    public static void main(String[] args) {
        final String[] RockPaperScissors = {"rock", "paper", "scissors"};
        String userInput = "";

        while (!isExit(userInput)) {
            userInput = "";

            while(!isRockPaperOrScissors(userInput) && !isExit(userInput)) {
                Scanner in = new Scanner(System.in);
                System.out.printf("Please enter rock, paper, or scissors: ");
                userInput = in.nextLine().toLowerCase();
            }

            if (isExit(userInput)) return;

            String computerAns = getRandomRockPaperOrScissors();

            if (computerAns.equals(userInput.toLowerCase())) {
                System.out.println("Draw!");
            } else if ((userInput.equals(RockPaperScissors[1])
                    && computerAns.equals(RockPaperScissors[0]))
                || (userInput.equals(RockPaperScissors[0])
                    && computerAns.equals(RockPaperScissors[2]))
                || (userInput.equals(RockPaperScissors[2])
                    && computerAns.equals(RockPaperScissors[1]))) {
                System.out.println(ANSI_GREEN_BACKGROUND+ "You win!" + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED_BACKGROUND + "You lose!" + ANSI_RESET);
            }

            System.out.println("Computer answer: "+ computerAns);
            System.out.println("user input: "+ userInput);
        }

    }
}