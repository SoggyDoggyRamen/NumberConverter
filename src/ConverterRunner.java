import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();

        boolean baseCheck = true;
        if (base == 8) {
            for (int i = 0; i < digits.length; i ++) {
                if (!(digits[i] >= 0 && digits[i] <= 7)) {
                    baseCheck = false;
                }
            }
        }
        else if (base == 2) {
            for (int i = 0; i < digits.length; i ++) {
                if (!(digits[i] == 0 || digits[i] == 1)) {
                    baseCheck = false;
                }
            }
        }

        System.out.println();
        if (!baseCheck) {
            System.out.println("Invalid number in base " + base);
        }
        else {
            if (base == 2) {
                System.out.print("Octal: ");
                for (int num: nc.convertToOctal()) {
                    System.out.print(num);
                }
                System.out.println();
                System.out.print("Decimal: ");
                for (int num: nc.convertToDecimal()) {
                    System.out.print(num);
                }
            }
            if (base == 8) {
                System.out.print("Binary: ");
                for (int num: nc.convertToBinary()) {
                    System.out.print(num);
                }
                System.out.println();
                System.out.print("Decimal: ");
                for (int num: nc.convertToDecimal()) {
                    System.out.print(num);
                }
            }
            if (base == 10) {
                System.out.print("Octal: ");
                for (int num: nc.convertToOctal()) {
                    System.out.print(num);
                }
                System.out.println();
                System.out.print("Binary: ");
                for (int num: nc.convertToBinary()) {
                    System.out.print(num);
                }
            }
        }
    }
}

