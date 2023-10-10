import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    public static double evaluateOPERATOR(double num1, double num2, char op) {
        double result = Double.MAX_VALUE;

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
            result = Math.pow(num1, num2);
        } else {
            throw new RuntimeException("Error computing result!");
        }


        if (result == Double.MAX_VALUE) throw new RuntimeException("INVALID OPERATOR!");

        return result;
    }


    public static boolean isExit(String str) {
        final String[] EXITLIST = {"exit", "quit"};

        for (int i = 0; i < EXITLIST.length; i++)
            if (str.toLowerCase(Locale.ROOT).equals(EXITLIST[i])) return true;
        return false;
    }

    public static final char[] OPERATORS = {'+', '-', '*', '/', '%', '^'};

    public static boolean isInOPERATORS(char op) {
        for (int i = 0; i < OPERATORS.length; i++)
            if (op == OPERATORS[i]) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char op = 'a';

        double num1 = 0;
        double num2 = 0;

        while (true) {
            op = 'a';
            num1 = Integer.MAX_VALUE;
            num2 = Integer.MAX_VALUE;
            String exit = "";

            while (num1 == Integer.MAX_VALUE) {
                System.out.print("Please enter an Integer: ");
                exit = in.nextLine();
                if (isExit(exit)) return;
                try {
                    num1 = Integer.parseInt(exit);
                } catch (NumberFormatException e){
                    num1 = Integer.MAX_VALUE;
                }
            }

            while (!isInOPERATORS(op)) {
                try {
                    System.out.println("Please enter an Operator (e.g. +,-,*,/,%,^): ");
                    exit = in.nextLine();
                    if (isExit(exit)) return;
                    op = exit.charAt(0);
                } catch (StringIndexOutOfBoundsException e) {}
            }

            while (num2 == Integer.MAX_VALUE) {
                System.out.print("Please enter another Integer: ");
                exit = in.nextLine();
                if (isExit(exit)) return;
                try {
                    num2 = Integer.parseInt(exit);
                } catch (NumberFormatException e){
                    num2 = Integer.MAX_VALUE;
                }
            }

            System.out.printf("%f %c %f = %f\n", num1, op, num2, evaluateOPERATOR(num1, num2, op));

        }
    }
}
