package lab1and2;

import java.util.Random;

public class HugeInteger {
    private int sign; // the sign of integer (-1 for neg, 0 for zero, 1 for pos)
    private int[] magnitude; // the magnitude of the integer, with each element in the array storing a digit

    public static final HugeInteger zero = new HugeInteger("0");

    public HugeInteger() {} // empty constructor

    public  HugeInteger(String val) throws IllegalArgumentException {
        if (val.length() == 0) throw new IllegalArgumentException("Invalid input."); // throw exception if empty string
        if (val.charAt(0) == '-') { // check if first character is negative
            val = val.replaceFirst("-",""); // removes negative sign from string
            sign = -1;
        }
        int testSize = val.length();
        for (int i = 0; i < testSize; i++) {
            if (val.charAt(0) == '0') { // removes leading zeros from string
                val = val.substring(1);
            }
        }
        if (val.length() == 0) { // if string is empty at this point, all digits must have zero therefore the input was zero
            sign = 0;
        }
        magnitude = new int[val.length()];
        for (int i = 0; i < val.length(); i++) {
            char c = val.charAt(i);
            if (c >= '0' && c <= '9') {
                if (sign == 0) sign = 1; // sets sign for positive integer
                magnitude[i] = (c - '0');
            }
            else throw new IllegalArgumentException("Invalid input"); // throws exception if character is not 0-9
        }
    }

    public HugeInteger(int n) throws IllegalArgumentException {
        if (n < 1) throw new IllegalArgumentException("The input must be an integer larger or equal to 1."); // throw exception if input < 1
        Random rand = new Random(); // creates Random object
        int random = rand.nextInt(2); // generates  random integer
        if (random == 0) sign = -1; // if integer = 0; integer is negative
        else sign = 1; // else positive
        magnitude = new int[n];
        int zeroLead = 0;
        for (int i = 0; i < n; i++) {
            random = rand.nextInt(10); // generate integer from 0-9
            if (random == 0 && zeroLead == 0) { // if int is 0, check if there is a leading non-zero digit yet
                i--;
            }
            else {
                magnitude[i] = random;
                zeroLead = 1;
            }
        }
    }

    public HugeInteger add(HugeInteger h) {
        if (this.sign == 0 || h.sign == 0) { // checks if either integer is a zero
            if (this.sign == 0 && h.sign == 0) {
                return zero;
            }
            if (this.sign == 0) return h;
            else return this;
        }

        if ((this.sign == 1 && h.sign == 1) || (this.sign == -1 && h.sign == -1)) { // if signs match
            int[] thisTempMag = this.magnitude; // create temp variables for magnitudes to swap later
            int[] hTempMag = h.magnitude;
            int digits;
            HugeInteger sum = new HugeInteger();
            if (this.sign == 1) sum.sign = 1;
            if (this.sign == -1) sum.sign = -1;
            if (hTempMag.length > thisTempMag.length) { // swap if h.magnitude is smaller than this.magnitude
                int[] temp;
                temp = thisTempMag;
                thisTempMag = hTempMag;
                hTempMag = temp;
            }
            digits = thisTempMag.length;
            sum.magnitude = new int[digits];
            for (int i = thisTempMag.length - 1; i >= 0; i--) { // sets values for sum magnitude from this.magnitude
                sum.magnitude[i] += thisTempMag[i];
            }
            for (int i = hTempMag.length - 1; i >= 0; i--) { // adds values from h.magnitude
                sum.magnitude[i + (thisTempMag.length - hTempMag.length)] += hTempMag[i];
            }
            for (int i = sum.magnitude.length - 1; i > 0; i--) { // goes through array in reverse order to check for values > 9
                if (sum.magnitude[i] > 9) {
                    sum.magnitude[i] -= 10; // reduces current array element by 10
                    sum.magnitude[i - 1] += 1; // increases previous array element by 1
                }
            }
            if (sum.magnitude[0] > 9) { // if first element is > 9 then create new array with 1 more element
                HugeInteger sum1 = new HugeInteger();
                sum1.sign = sum.sign;
                sum1.magnitude = new int[sum.magnitude.length + 1];
                sum1.magnitude[0] = 1; // first element must be 1 (max value for digit 9 + 9 + 1 (carry) = 19)
                sum1.magnitude[1] = sum.magnitude[0] - 10; // second element is number - 10 to give 2nd digit
                for (int i = 2; i < sum1.magnitude.length; i++) { // copies over rest of sum matrix
                    sum1.magnitude[i] = sum.magnitude[i - 1];
                }
                return sum1;
            }
            return sum;
        }

        // if this = -h then this + h = 0
        if (this.magnitude.length == h.magnitude.length) {
            int flag = 0;
            for (int i = 0; i < this.magnitude.length; i++) {
                if (this.magnitude[i] != h.magnitude[i]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return zero;
            }
        }

        // if signs do not match
        int[] thisTempMag = this.magnitude; // create temp variables for magnitudes to swap later
        int[] hTempMag = h.magnitude;
        int digits, flag = 0, thisSign = this.sign, hSign = h.sign;
        // flag to flip signs at end if negative value is greater

        // tests which is greater
        HugeInteger test = new HugeInteger();
        test.sign = 1;
        test.magnitude = thisTempMag;
        HugeInteger test2 = new HugeInteger();
        test2.sign = 1;
        test2.magnitude = hTempMag;
        if (test.compareTo(test2) == -1) {
            int[] temp;
            temp = thisTempMag;
            thisTempMag = hTempMag;
            hTempMag = temp;
            flag = 1;
            if (thisSign == -1) {
                thisSign = h.sign;
                hSign = this.sign;
                flag = 0;
            }
        }
        else {
            if (thisSign == -1) {
                thisSign = h.sign;
                hSign = this.sign;
                flag = 1;
            }
        }

        HugeInteger sum = new HugeInteger();
        digits = thisTempMag.length;
        sum.magnitude = new int[digits];
        for (int i = thisTempMag.length - 1; i >= 0; i--) { // sets values for sum magnitude from this.magnitude
            sum.magnitude[i] += thisSign*thisTempMag[i];
        }
        for (int i = hTempMag.length - 1; i >= 0; i--) { // adds values from h.magnitude
            sum.magnitude[i + (thisTempMag.length - hTempMag.length)] += hSign*hTempMag[i];
        }

        for (int i = sum.magnitude.length - 1; i > 0; i--) { // goes through array in reverse order to check for values < 0
            if (sum.magnitude[i] < 0) {
                sum.magnitude[i] += 10; // increases current array element by 10
                sum.magnitude[i - 1] -= 1; // decreases previous array element by 1
            }
        }
        for (int i = 0; i < sum.magnitude.length; i++) { // reduces number of digits to remove leading zeros
            if (sum.magnitude[i] != 0) {
                break;
            }
            digits--;
        }
        if (digits < sum.magnitude.length) { // creates new array without leading zeros
            int[] temp = new int[digits];
            for (int i = sum.magnitude.length-digits; i < sum.magnitude.length; i++) {
                temp[i-(sum.magnitude.length-digits)] = sum.magnitude[i];
            }
            sum.magnitude = temp;
        }
        if (sum.magnitude[0] > 0) sum.sign = 1;
        if (sum.magnitude[0] < 0) sum.sign = -1;
        if (sum.magnitude[0] < -9) {
            int[] temp = new int[digits+1];
            temp[0] = -1;
            temp[1] = sum.magnitude[0] + 10;
            for (int i = 1; i < sum.magnitude.length; i++) {
                temp[i+1] = sum.magnitude[i];
            }
            sum.magnitude = temp;
        }
        if (sum.sign == -1) sum.magnitude[0] = -1*sum.magnitude[0]; // make first element positive if sign is negative
        if (flag == 1) sum.sign = -sum.sign;
        return sum;
    }

    public HugeInteger subtract(HugeInteger h) {
        HugeInteger temp = new HugeInteger();
        temp.sign = -h.sign;
        temp.magnitude = h.magnitude;
        return this.add(temp); // performs add with -h
    }

    public int compareTo(HugeInteger h) {
        if (this.sign > h.sign) return 1;
        if (this.sign < h.sign) return -1;
        if (this.sign == 1) {
            if (this.magnitude.length > h.magnitude.length) return 1;
            if (this.magnitude.length < h.magnitude.length) return -1;
            for (int i = 0; i < this.magnitude.length; i++) {
                if (this.magnitude[i] > h.magnitude[i]) return 1;
                if (this.magnitude[i] < h.magnitude[i]) return -1;
            }
        }
        if (this.sign == -1) {
            if (this.magnitude.length < h.magnitude.length) return 1;
            if (this.magnitude.length > h.magnitude.length) return -1;
            for (int i = 0; i < this.magnitude.length; i++) {
                if (this.magnitude[i] < h.magnitude[i]) return 1;
                if (this.magnitude[i] > h.magnitude[i]) return -1;
            }
        }
        return 0;
    }

    public HugeInteger multiply(HugeInteger h) {
        if (this.sign == 0 || h.sign == 0) { // if either argument is 0, product is 0
            return zero;
        }
        int digits = this.magnitude.length + h.magnitude.length;
        HugeInteger product = new HugeInteger();
        product.sign = this.sign*h.sign;
        product.magnitude = new int[digits];

        int[] thisTempMag = this.magnitude; // create temp variables for magnitudes to swap later
        int[] hTempMag = h.magnitude;
        if (this.magnitude.length < h.magnitude.length) {
            int[] temp;
            temp = thisTempMag;
            thisTempMag = hTempMag;
            hTempMag = temp;
        }
        for (int i = thisTempMag.length - 1; i >= 0; i--) {
            int productIndex = thisTempMag.length + hTempMag.length - 1 - (thisTempMag.length - 1 - i); // start at earlier index each loop
            for (int j = hTempMag.length - 1; j >= 0; j--) {
                product.magnitude[productIndex] += thisTempMag[i]*hTempMag[j]; // multiply
                productIndex--; // shift left
            }
        }

        for (int i = product.magnitude.length - 1; i > 0; i--) { // ensures elements are single digit
            if (product.magnitude[i] > 9) {
                product.magnitude[i - 1] += (product.magnitude[i] / 10);
                product.magnitude[i] = product.magnitude[i] % 10;
            }
        }

        for (int i = 0; i < product.magnitude.length; i++) { // remove leading zeros
            if (product.magnitude[i] != 0) {
                break;
            }
            digits--;
        }
        if (digits < product.magnitude.length) {
            int[] temp = new int[digits];
            for (int i = product.magnitude.length-digits; i < product.magnitude.length; i++) {
                temp[i-(product.magnitude.length-digits)] = product.magnitude[i];
            }
            product.magnitude = temp;
        }

        return product;
    }

    public String toString() {
        if (sign == 0) return "0";
        String output = "";
        if (sign == -1) output += "-";
        for (int value : magnitude) {
            output += value;
        }
        return output;
    }
}