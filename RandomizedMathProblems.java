import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class RandomizedMathProblems {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static boolean isExit(String str) {
        final String[] EXITLIST = {"exit", "quit"};

        for (int i = 0; i < EXITLIST.length; i++)
            if (str.toLowerCase(Locale.ROOT).equals(EXITLIST[i])) return true;
        return false;
    }

    public static final char[] OPERATORS = {'+', '-', '*', '/', '%', '^'};

    public static int evaluateOPERATOR(int num1, int num2, char op) {
        int result = Integer.MAX_VALUE;

        if (op == OPERATORS[0]) {
            result = num1 + num2;
        } else if (op == OPERATORS[1]) {
            result = num1 - num2;
        } else if (op == OPERATORS[2]) {
            result = num1 * num2;
        } else if (op == OPERATORS[3]) {
            result = num1 / num2;
        } else if (op == OPERATORS[4]) {
            result = num1 % num2;
        } else if (op == OPERATORS[5]){
            result = (int) Math.round(Math.pow(num1, num2));
        } else {
            throw new RuntimeException("Error computing result!");
        }

        if (result == Integer.MAX_VALUE) throw new RuntimeException("INVALID OPERATOR!");

        return result;
    }


    public static void main(String[] args) {
        Random rng = new Random();

        System.out.printf("Answer the following questions: \n");
        while (true) {
            int num1 = rng.nextInt() % 10;
            int num2 = rng.nextInt() % 10;
            while (num2 == 0)
                num2 = rng.nextInt() % 10;

            int opChooser = rng.nextInt() % OPERATORS.length;
            if (opChooser < 0) opChooser = opChooser * -1;

            Scanner in = new Scanner(System.in);

            System.out.printf("%d %c %d = ?\n", num1, OPERATORS[opChooser], num2);

            String exit = "";

            int ans = Integer.MAX_VALUE;
            while (ans == Integer.MAX_VALUE) {
                System.out.print("Please enter an answer: ");
                exit = in.nextLine();
                if (isExit(exit)) return;
                try {
                    ans = Integer.parseInt(exit);
                } catch (NumberFormatException e){
                    ans = Integer.MAX_VALUE;
                }
            }

            int correctAnswer = evaluateOPERATOR(num1, num2, OPERATORS[opChooser]);

            if (ans == correctAnswer){
                System.out.printf("Correct!\n");
            } else {
                System.out.printf("%sIncorrect!\nThe answer is %d.%s\n",ANSI_RED_BACKGROUND, correctAnswer, ANSI_RESET);
            }

        }
    }
}
