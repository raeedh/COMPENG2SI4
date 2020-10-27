package lab1and2;

import javax.sound.midi.SysexMessage;

public class TestHugeInteger {
    public static void main(String[] args) {
        HugeInteger huge1, huge2, huge3;

        System.out.println("Constructor tests:");

        huge1 = new HugeInteger("0"); // input is 0
        System.out.println(huge1);

        huge1 = new HugeInteger("00000"); // input is multiple 0s
        System.out.println(huge1);

        huge1 = new HugeInteger("-0"); // input is negative 0
        System.out.println(huge1);

        huge1 = new HugeInteger("-00000"); // input is - followed by multiple 0s
        System.out.println(huge1);

        huge1 = new HugeInteger("1510239"); // valid string input
        System.out.println(huge1);

        huge1 = new HugeInteger("000000001510239"); // valid single digit input with leading 0s
        System.out.println(huge1);

        huge1 = new HugeInteger("-690290384"); // valid negative string input
        System.out.println(huge1);

        huge1 = new HugeInteger("-00000000690290384"); // valid negative string input with leading 0s
        System.out.println(huge1);

        try{
            huge1 = new HugeInteger("11234-1231"); // invalid positive input with string in middle
            System.out.println(huge1);
        }
        catch(Exception e) {
            System.out.println("Invalid input");
        }

        try{
            huge1 = new HugeInteger("-1863495-105328403924"); // invalid negative input with string in middle
            System.out.println(huge1);
        }
        catch(Exception e) {
            System.out.println("Invalid input");
        }

        try{
            huge1 = new HugeInteger(0); // invalid input with n = 0
            System.out.println(huge1);
        }
        catch(Exception e) {
            System.out.println("Invalid input");
        }

        huge1 = new HugeInteger(5); // valid input
        System.out.println(huge1);

        try{
            huge1 = new HugeInteger(-5); // input input with n < 0
            System.out.println(huge1);
        }
        catch(Exception e) {
            System.out.println("Invalid input");
        }

        System.out.println("\nAddition tests:");

        System.out.println();
        huge1 = new HugeInteger("0"); // 0 + 0
        huge2 = new HugeInteger("0");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("0"); // 0 + positive
        huge2 = new HugeInteger("123");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("0"); // 0 + negative
        huge2 = new HugeInteger("-123");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("125123"); // 2 positives with different number of digits
        huge2 = new HugeInteger("173452341");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("212361"); // 2 positives with same number of digits and same # digits in result
        huge2 = new HugeInteger("501293");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("512315"); // 2 positives with same number of digits and diff # digits in result
        huge2 = new HugeInteger("941238");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("-123"); // 2 positives with different number of digits
        huge2 = new HugeInteger("-6789");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("-4424"); // 2 positives with same number of digits and same # digits in result
        huge2 = new HugeInteger("-1138");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("-999"); // 2 positives with same number of digits and diff # digits in result
        huge2 = new HugeInteger("-998");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("514"); // positive + negative w/ pos result
        huge2 = new HugeInteger("-12");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("999"); // positive + negative with leading zeros in pos result
        huge2 = new HugeInteger("-996");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("913"); // positive + negative / neg result
        huge2 = new HugeInteger("-1042");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("555"); // positive + negative with leading zeros in neg result
        huge2 = new HugeInteger("-564");
        huge3 = huge1.add(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println("\nSubtraction tests:");

        System.out.println();
        huge1 = new HugeInteger("0"); // 0 - 0
        huge2 = new HugeInteger("0");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("0"); // 0 - positive
        huge2 = new HugeInteger("123");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("0"); // 0 - negative
        huge2 = new HugeInteger("-123");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);


        System.out.println();
        huge2 = new HugeInteger("0"); // positive - 0
        huge1 = new HugeInteger("123");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge2 = new HugeInteger("0"); // negative - 0
        huge1 = new HugeInteger("-123");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("1235"); // 2 positives w/ pos res
        huge2 = new HugeInteger("123");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("125123"); // 2 positives w/ neg res
        huge2 = new HugeInteger("173452341");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("123"); // 2 equal positives
        huge2 = new HugeInteger("123");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("-123"); // 2 negs w/ + res
        huge2 = new HugeInteger("-1234");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("-1234"); // 2 negs w/ - res
        huge2 = new HugeInteger("-123");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("-555"); // 2 negs w/ leading zero result
        huge2 = new HugeInteger("-564");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("-123"); // 2 equal negs
        huge2 = new HugeInteger("-123");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("514"); // pos - neg
        huge2 = new HugeInteger("-123");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("-514"); // neg - pos
        huge2 = new HugeInteger("123");
        huge3 = huge1.subtract(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        System.out.println("Multiplication cases");

        System.out.println();
        huge1 = new HugeInteger("0"); // 0 * 0
        huge2 = new HugeInteger("0");
        huge3 = huge1.multiply(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("0"); // 0 * pos
        huge2 = new HugeInteger("123");
        huge3 = huge1.multiply(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("12"); // pos * pos
        huge2 = new HugeInteger("99");
        huge3 = huge1.multiply(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("12"); // pos * neg
        huge2 = new HugeInteger("-99");
        huge3 = huge1.multiply(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        huge1 = new HugeInteger("-12"); // neg * neg
        huge2 = new HugeInteger("-99");
        huge3 = huge1.multiply(huge2);
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge3);

        System.out.println();
        System.out.println("Comparison cases:");
        int compareVal = 0;

        System.out.println();
        huge1 = new HugeInteger("0"); // 0 to 0
        huge2 = new HugeInteger("0");
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge1.compareTo(huge2));

        System.out.println();
        huge1 = new HugeInteger("0"); // 0 to +
        huge2 = new HugeInteger("123");
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge1.compareTo(huge2));

        System.out.println();
        huge1 = new HugeInteger("0"); // 0 to -
        huge2 = new HugeInteger("-123");
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge1.compareTo(huge2));

        System.out.println();
        huge1 = new HugeInteger("123"); // + to -
        huge2 = new HugeInteger("-123");
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge1.compareTo(huge2));

        System.out.println();
        huge1 = new HugeInteger("123"); // + to 0
        huge2 = new HugeInteger("0");
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge1.compareTo(huge2));

        System.out.println();
        huge1 = new HugeInteger("-123"); // - to +
        huge2 = new HugeInteger("123");
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge1.compareTo(huge2));

        System.out.println();
        huge1 = new HugeInteger("-123"); // - to 0
        huge2 = new HugeInteger("0");
        System.out.println(huge1);

        System.out.println();
        huge1 = new HugeInteger("123"); // + to larger +
        huge2 = new HugeInteger("124");
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge1.compareTo(huge2));

        System.out.println();
        huge1 = new HugeInteger("123"); // + to smaller +
        huge2 = new HugeInteger("12");
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge1.compareTo(huge2));

        System.out.println();
        huge1 = new HugeInteger("123"); // + = +
        huge2 = new HugeInteger("123");
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge1.compareTo(huge2));

        System.out.println();
        huge1 = new HugeInteger("-123"); // - to larger -
        huge2 = new HugeInteger("-12");
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge1.compareTo(huge2));

        System.out.println();
        huge1 = new HugeInteger("-123"); // - to smaller -
        huge2 = new HugeInteger("-124");
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge1.compareTo(huge2));

        System.out.println();
        huge1 = new HugeInteger("-123"); // - = -
        huge2 = new HugeInteger("-123");
        System.out.println(huge1);
        System.out.println(huge2);
        System.out.println(huge1.compareTo(huge2));
    }
}
