import java.util.InputMismatchException;
import java.util.Scanner;

public class TestTask {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String inputstring;
        System.out.println("Введите строку выражения");
        inputstring = in.nextLine();
        String[] inputArray = inputstring.split(" ");
        if (inputArray.length == 3) {


            int digit1;
            int digit2;
            boolean IsRomanDigit1 = false;
            boolean IsRomanDigit2 = false;
            String operator = inputArray[1];
            try {
                digit1 = Integer.parseInt(inputArray[0]);
            } catch (NumberFormatException e) {
                digit1 = romanToArabicConvert(inputArray[0]);
                IsRomanDigit1 = true;
            }
            try {
                digit2 = Integer.parseInt(inputArray[2]);
            } catch (NumberFormatException e) {
                digit2 = romanToArabicConvert(inputArray[2]);
                IsRomanDigit2 = true;
            }


            if ((digit1 < 1) || (digit1 > 10) || (digit2 < 1) || (digit2 > 10)) {
                System.out.println("Недопустимые числа. Введите числа от 1 до 10 или римскими цифрами (I-X)");
                return;
            }
            int output = getOutput(operator, digit1, digit2);

            System.out.println("input: " + inputstring);
            if (IsRomanDigit1 == false && IsRomanDigit2 == false) {
                System.out.println("Output: " + output);
            } else if (IsRomanDigit1 == true && IsRomanDigit2 == true) {
                System.out.println("Output: " + arabicToRomanConvert(output));
            } else System.out.println("Нельзя складывать арабские с римскими цифрами");


        } else
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        System.exit(0);
    }

    private static int getOutput(String operator, int digit1, int digit2) {
        int output = 0;
        switch (operator) {
            case "+" -> output = digit1 + digit2;
            case "-" -> output = digit1 - digit2;
            case "*" -> output = digit1 * digit2;
            case "/" -> output = digit1 / digit2;
            default -> System.out.println("неверный ввод действия, можно ввести только следующие символы +, -, *, /, ");
        }
        return output;
    }

    private static String arabicToRomanConvert(int digitArabian) throws ArrayIndexOutOfBoundsException {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        try {
            return roman[digitArabian];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("У римских цифр не должно быть отрицательных значений");
        }

    }

    private static int romanToArabicConvert(String digitRoman) {
        try {
            if (digitRoman.equals("I")) {
                return 1;
            } else if (digitRoman.equals("II")) {
                return 2;
            } else if (digitRoman.equals("III")) {
                return 3;
            } else if (digitRoman.equals("IV")) {
                return 4;
            } else if (digitRoman.equals("V")) {
                return 5;
            } else if (digitRoman.equals("VI")) {
                return 6;
            } else if (digitRoman.equals("VII")) {
                return 7;
            } else if (digitRoman.equals("VIII")) {
                return 8;
            } else if (digitRoman.equals("IX")) {
                return 9;
            } else if (digitRoman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("число должно быть от 1 до 10 включительно или римскими цифрами (I-X)");
        }
        return -1;
    }
}