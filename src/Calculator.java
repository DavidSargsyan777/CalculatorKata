import java.util.Scanner;

public class Calculator {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String str = SCANNER.nextLine();

        System.out.println(calc(str));
    }

    public static String calc(String input) throws Exception {
        String[] inp = input.split(" ");
        if (inp.length > 3) {
            throw new Exception("There should be two summands");
        }
        String op = inp[1];
        int firstNumber;
        int secondNumber;
        if ((inp[0].contains("I") || inp[0].contains("V") || inp[0].contains("X")) && (inp[2].contains("I")
            || inp[2].contains("V") || inp[2].contains("X"))) {
            firstNumber = romanToArab(inp[0]);
            secondNumber = romanToArab(inp[2]);
            String result = operation(firstNumber, secondNumber, op);

            if (Integer.parseInt(result) < 1) {
                throw new NumberFormatException();
            }
            return showRomanResult(result);
        } else {
            firstNumber = Integer.parseInt(inp[0]);
            secondNumber = Integer.parseInt(inp[2]);
        }

        if (firstNumber > 10 || firstNumber < 1 || secondNumber > 10 || secondNumber < 1) {
            throw new NumberFormatException();
        }
        return operation(firstNumber, secondNumber, op);
    }

    public static String operation(int firstNumber, int secondNumber, String op) throws Exception {

        switch (op) {
            case "+":
                return String.valueOf(firstNumber + secondNumber);
            case "-":
                return String.valueOf(firstNumber - secondNumber);
            case "/":
                return String.valueOf(firstNumber / secondNumber);
            case "*":
                return String.valueOf(firstNumber * secondNumber);
            default:
                throw new Exception("Illegal operation");
        }
    }

    public static int romanToArab(String roman) {

        switch (roman) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new IllegalArgumentException("Illegal argument");
        }
    }

    public static String showRomanResult(String arabNumber) {
        StringBuilder res = new StringBuilder("");
        int arab = Integer.parseInt(arabNumber);
        while (arab != 0) {
            if (arab >= 100) {
                res.append("C");
                arab -= 100;
            } else if (arab >= 90) {
                res.append("XC");
                arab -= 90;
            } else if (arab >= 50) {
                res.append("L");
                arab -= 50;
            } else if (arab >= 40) {
                res.append("XL");
                arab -= 40;
            } else if (arab >= 10) {
                res.append("X");
                arab -= 10;
            } else if (arab >= 9) {
                res.append("IX");
                arab -= 9;
            } else if (arab >= 5) {
                res.append("V");
                arab -= 5;
            } else if (arab >= 4) {
                res.append("IV");
                arab -= 4;
            } else if (arab >= 1) {
                res.append("I");
                arab -= 1;
            }
        }
        return res.toString();
    }
}

