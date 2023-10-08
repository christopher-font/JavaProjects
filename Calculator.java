import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    public static boolean isExit(String str) {
        final String[] EXITLIST = {"exit", "quit"};

        for (int i = 0; i < EXITLIST.length; i++)
            if (str.toLowerCase(Locale.ROOT).equals(EXITLIST[i])) return true;
        return false;
    }

    public static final char[] OPERATORS = {'+', '-', '*', '/', '%'};

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
        }
        return result;
    }

    public static boolean isInOPERATORS(char op) {
        for (int i = 0; i < OPERATORS.length; i++)
            if (op == OPERATORS[i]) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char op = 'a';

        int num1 = 0;
        int num2 = 0;

        while (true) {
            op = 'a';

            System.out.print("Please enter an Integer: ");
            String exit = in.nextLine();
            if (isExit(exit)) break;
            try {
                num1 = Integer.parseInt(exit);
            } catch (NumberFormatException e){}

            while (!isInOPERATORS(op)) {
                try {
                    System.out.println("Please enter an Operator: ");
                    op = in.nextLine().charAt(0);
                } catch (StringIndexOutOfBoundsException e) {}
            }

            System.out.print("Please enter another Integer: ");
            exit = in.nextLine();
            if (isExit(exit)) break;
            num2 = Integer.parseInt(exit);

            System.out.printf("%d %c %d = %d\n", num1, op, num2, evaluateOPERATOR(num1, num2, op));

        }

    }
}
