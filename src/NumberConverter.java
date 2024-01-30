public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int total = 0;
        int num = 0;
        if (base == 2) {
            num = 2;
        }
        if (base == 8) {
            num = 8;
        }
        int exponent = 0;
        for (int i = digits.length - 1; i >= 0; i --) {
            total = total + digits[i] * (int) (Math.pow(num, exponent));
            exponent ++;
        }
        String stringTotal = Integer.toString(total);
        int [] decimalDigits = new int[stringTotal.length()];
        for (int i = 0; i < stringTotal.length(); i ++) {
            decimalDigits[i] = Integer.parseInt(stringTotal.substring(i, i + 1));
        }
        return decimalDigits;
    }

    public int[] convertToBinary() {
        if (base == 10) {
            String binaryNum = "";
            String stringNum = "";
            for (int i = 0; i < digits.length; i++) {
                stringNum = stringNum + digits[i];
            }
            int num = Integer.parseInt(stringNum);
            while (num > 0) {
                double remainder = (double) num % 2;
                num = num/2;
                if (remainder > 0) {
                    binaryNum = 1 + binaryNum;
                }
                else {
                    binaryNum = 0 + binaryNum;
                }
            }
            int[] binaryDigits = new int[binaryNum.length()];
            for (int i = 0; i < binaryNum.length(); i ++) {
                binaryDigits[i] = Integer.parseInt(binaryNum.substring(i, i + 1));
            }
            return binaryDigits;
        }
        else {
            String binaryNum = "";
            for (int num: digits) {
                String binarySeg = "";
                if (num >= 4) {
                    num = num - 4;
                    binarySeg += 1;
                }
                else {
                    binarySeg += 0;
                }
                if (num >= 2) {
                    num = num - 2;
                    binarySeg += 1;
                }
                else {
                    binarySeg += 0;
                }
                if (num >= 1) {
                    num = num - 1;
                    binarySeg += 1;
                }
                else {
                    binarySeg += 0;
                }
                binaryNum += binarySeg;
            }
            int[] binaryDigits = new int[binaryNum.length()];
            for (int i = 0; i < binaryNum.length(); i ++) {
                binaryDigits[i] = Integer.parseInt(binaryNum.substring(i, i + 1));
            }
            return binaryDigits;
        }
    }

    public int[] convertToOctal() {
        if (base == 2) {
            String octalNum = "";
            int leftover = digits.length % 3;
            for (int i = digits.length - 1; i > leftover; i = i - 3) {
                String binarySeg = "" + digits[i - 2] + digits[i - 1] + digits[i];
                int total = 0;
                if (binarySeg.substring(0, 1).equals("1")) {
                    total += 4;
                }
                if (binarySeg.substring(1, 2).equals("1")) {
                    total += 2;
                }
                if (binarySeg.substring(2, 3).equals("1")) {
                    total += 1;
                }
                octalNum = total + octalNum;
            }
            if (leftover == 1) {
                octalNum = 1 + octalNum;
            }
            if (leftover == 2) {
                int total = 0;
                if (digits[1] == 1) {
                    total ++;
                }
                if (digits[0] == 1) {
                    total += 2;
                }
                octalNum = total + octalNum;
            }
            int[] octalDigits = new int[octalNum.length()];
            for (int i = 0; i < octalNum.length(); i ++) {
                octalDigits[i] = Integer.parseInt(octalNum.substring(i, i + 1));
            }
            return octalDigits;
        }
        else {
            String octalNum = "";
            String stringNum = "";
            for (int i = 0; i < digits.length; i++) {
                stringNum = stringNum + digits[i];
            }
            int num = Integer.parseInt(stringNum);
            while (num > 0) {
                int remainder = num % 8;
                num = num/8;
                octalNum = remainder + octalNum;
            }
            int[] octalDigits = new int[octalNum.length()];
            for (int i = 0; i < octalNum.length(); i ++) {
                octalDigits[i] = Integer.parseInt(octalNum.substring(i, i + 1));
            }
            return octalDigits;
        }
    }
}

