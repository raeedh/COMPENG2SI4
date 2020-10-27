package lab1and2;

import java.math.BigInteger;
import java.util.Random;

public class BigIntTiming {
    public static void main(String[] args) {
        int[] nValues = new int[]{10,100,500,1000,5000,10000};
        BigInteger big1, big2, big3;
        double startTime, endTime, runTime = 0.0;
        int MAXNUMINTS = 110, MAXRUN = 100000;
        Random rand = new Random();

        System.out.println("Addition");
        for (int n : nValues) {
            for (int numInts = 0; numInts < MAXNUMINTS; numInts++) {
                big1 = new BigInteger(n,rand);
                big2 = new BigInteger(n,rand);
                startTime = System.nanoTime();

                for (int numRun = 0; numRun < MAXRUN; numRun++) {
                    big3 = big1.add(big2);
                }

                endTime = System.nanoTime();
                runTime += (endTime - startTime) / MAXRUN / 1e9;
            }
            runTime /= MAXNUMINTS;
            System.out.println("running time at n = " + n + " is " + runTime);
        }
        System.out.println();

        System.out.println("Subtraction");
        for (int n : nValues) {
            for (int numInts = 0; numInts < MAXNUMINTS; numInts++) {
                big1 = new BigInteger(n,rand);
                big2 = new BigInteger(n,rand);
                startTime = System.nanoTime();

                for (int numRun = 0; numRun < MAXRUN; numRun++) {
                    big3 = big1.subtract(big2);
                }

                endTime = System.nanoTime();
                runTime += (endTime - startTime) / MAXRUN / 1e9;
            }
            runTime /= MAXNUMINTS;
            System.out.println("running time at n = " + n + " is " + runTime);
        }
        System.out.println();

        System.out.println("Comparison");
        int compareVal = 0;
        for (int n : nValues) {
            for (int numInts = 0; numInts < MAXNUMINTS; numInts++) {
                big1 = new BigInteger(n,rand);
                big2 = new BigInteger(n,rand);
                startTime = System.nanoTime();

                for (int numRun = 0; numRun < MAXRUN; numRun++) {
                    compareVal = big1.compareTo(big2);
                }

                endTime = System.nanoTime();
                runTime += (endTime - startTime) / MAXRUN / 1e9;
            }
            runTime /= MAXNUMINTS;
            System.out.println("running time at n = " + n + " is " + runTime);
        }
        System.out.println();

        MAXNUMINTS = 110; MAXRUN = 10000;

        System.out.println("Multiplication");
        // nValues = new int[]{10,100,500,1000};
        for (int n : nValues) {
            for (int numInts = 0; numInts < MAXNUMINTS; numInts++) {
                big1 = new BigInteger(n,rand);
                big2 = new BigInteger(n,rand);
                startTime = System.nanoTime();
                for (int numRun = 0; numRun < MAXRUN; numRun++) {
                    big3 = big1.multiply(big2);
                }
                endTime = System.nanoTime();
                runTime += (endTime - startTime) / MAXRUN / 1e9;
            }
            runTime /= MAXNUMINTS;
            System.out.println("running time at n = " + n + " is " + runTime);
        }
    }
}
