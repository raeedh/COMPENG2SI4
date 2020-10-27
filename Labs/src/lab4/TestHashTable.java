package lab4;

import java.util.Random;

public class TestHashTable {
    private static int numsGenerated = 1000000;

    public static double avgSuccessfulLinear(double load) {
        double probes = 0;
        HashTableLin testTable = new HashTableLin(numsGenerated, load);
        Random rand = new Random();
        for (int i = 0; i < numsGenerated; i++) {
            int j = rand.nextInt();
            if (j < 0) j = j*-1;
            probes = probes + testTable.insertTest(j);
        }
        return (probes/testTable.getNumKeys());
    }

    public static double avgSuccessfulQuad(double load) {
        double probes = 0;
        HashTableQuad testTable = new HashTableQuad(numsGenerated, load);
        Random rand = new Random();
        for (int i = 0; i < numsGenerated; i++) {
            int j = rand.nextInt();
            if (j < 0) j = j*-1;
            probes = probes + testTable.insertTest(j);
        }
        return (probes/testTable.getNumKeys());
    }

    public static double theoreticalLinearProbes(double load) {
        return ((1.0/2.0)*(1.0 + (1.0 / (1.0 - load))));
    }

    public static void main(String[] args) {
        System.out.println("Table size is prime number");
        HashTableLin p1 = new HashTableLin(5,0.3);
        HashTableLin p2 = new HashTableLin(10061, 0.95);
        HashTableLin p3 = new HashTableLin(6123, 0.01);
        System.out.println("Size of table with maxNum = 5, load = 0.3 is " + p1.getTableSize());
        System.out.println("Size of table with maxNum = 10061, load = 0.95 is " + p2.getTableSize());
        System.out.println("Size of table with maxNum = 6123, load = 0.01 is " + p3.getTableSize());
        System.out.println();

        System.out.println("Linear Probing");
        System.out.println();

        System.out.println("Create empty hash table with maxNum = 4 and load = 0.5");
        HashTableLin x1 = new HashTableLin(4,0.5);
        x1.printKeys();
        x1.printKeysAndIndexes();
        System.out.println("The table size is " + x1.getTableSize() + ", the number of keys is " + x1.getNumKeys() + ", the load factor is " + x1.getLoadFactor());
        System.out.println();

        System.out.println("Insert integer: 0");
        x1.insert(0);
        x1.printKeys();
        System.out.println();
        x1.printKeysAndIndexes();
        System.out.println("The table size is " + x1.getTableSize() + ", the number of keys is " + x1.getNumKeys() + ", the load factor is " + x1.getLoadFactor());
        System.out.println();

        System.out.println("Insert integer: 1");
        x1.insert(1);
        x1.printKeys();
        System.out.println();
        x1.printKeysAndIndexes();
        System.out.println("The table size is " + x1.getTableSize() + ", the number of keys is " + x1.getNumKeys() + ", the load factor is " + x1.getLoadFactor());
        System.out.println();

        System.out.println("Insert integer: 5");
        x1.insert(5);
        x1.printKeys();
        System.out.println();
        x1.printKeysAndIndexes();
        System.out.println("The table size is " + x1.getTableSize() + ", the number of keys is " + x1.getNumKeys() + ", the load factor is " + x1.getLoadFactor());
        System.out.println();

        System.out.println("Insert duplicate integer: 5");
        x1.insert(5);
        x1.printKeys();
        System.out.println();
        x1.printKeysAndIndexes();
        System.out.println("The table size is " + x1.getTableSize() + ", the number of keys is " + x1.getNumKeys() + ", the load factor is " + x1.getLoadFactor());
        System.out.println();

        System.out.println("Test linear probing: insert 11");
        x1.insert(11);
        x1.printKeys();
        System.out.println();
        x1.printKeysAndIndexes();
        System.out.println("The table size is " + x1.getTableSize() + ", the number of keys is " + x1.getNumKeys() + ", the load factor is " + x1.getLoadFactor());
        System.out.println();

        System.out.println("Insert integer: 57");
        x1.insert(57);
        x1.printKeys();
        System.out.println();
        x1.printKeysAndIndexes();
        System.out.println("The table size is " + x1.getTableSize() + ", the number of keys is " + x1.getNumKeys() + ", the load factor is " + x1.getLoadFactor());
        System.out.println();

        System.out.println("Test rehashing after insertion: insert 1001");
        x1.insert(1001);
        x1.printKeys();
        System.out.println();
        x1.printKeysAndIndexes();
        System.out.println("The table size is " + x1.getTableSize() + ", the number of keys is " + x1.getNumKeys() + ", the load factor is " + x1.getLoadFactor());
        System.out.println();

        System.out.println("isIn");
        System.out.println("isIn(57): " + x1.isIn(57));
        System.out.println("isIn(2): " + x1.isIn(2));
        System.out.println();

        double[] loads = {0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9};
        for (double load : loads) {
            System.out.println("Average number of successful probes for load factor = " + load + " is " + avgSuccessfulLinear(load) + " (experimental) and " + theoreticalLinearProbes(load) + " (theoretical)");
        }
        System.out.println();

        System.out.println("Quadratic Probing");
        System.out.println();

        System.out.println("Create empty hash table with maxNum = 4 and load = 0.5");
        HashTableQuad x2 = new HashTableQuad(4,0.5);
        x2.printKeys();
        x2.printKeysAndIndexes();
        System.out.println("The table size is " + x2.getTableSize() + ", the number of keys is " + x2.getNumKeys() + ", the load factor is " + x2.getLoadFactor());
        System.out.println();

        System.out.println("Insert integer: 0");
        x2.insert(0);
        x2.printKeys();
        System.out.println();
        x2.printKeysAndIndexes();
        System.out.println("The table size is " + x2.getTableSize() + ", the number of keys is " + x2.getNumKeys() + ", the load factor is " + x2.getLoadFactor());
        System.out.println();

        System.out.println("Insert integer: 1");
        x2.insert(1);
        x2.printKeys();
        System.out.println();
        x2.printKeysAndIndexes();
        System.out.println("The table size is " + x2.getTableSize() + ", the number of keys is " + x2.getNumKeys() + ", the load factor is " + x2.getLoadFactor());
        System.out.println();

        System.out.println("Insert integer: 5");
        x2.insert(5);
        x2.printKeys();
        System.out.println();
        x2.printKeysAndIndexes();
        System.out.println("The table size is " + x2.getTableSize() + ", the number of keys is " + x2.getNumKeys() + ", the load factor is " + x2.getLoadFactor());
        System.out.println();

        System.out.println("Insert duplicate integer: 5");
        x2.insert(5);
        x2.printKeys();
        System.out.println();
        x2.printKeysAndIndexes();
        System.out.println("The table size is " + x2.getTableSize() + ", the number of keys is " + x2.getNumKeys() + ", the load factor is " + x2.getLoadFactor());
        System.out.println();

        System.out.println("Test quadratic probing: insert 11");
        x2.insert(11);
        x2.printKeys();
        System.out.println();
        x2.printKeysAndIndexes();
        System.out.println("The table size is " + x2.getTableSize() + ", the number of keys is " + x2.getNumKeys() + ", the load factor is " + x2.getLoadFactor());
        System.out.println();

        System.out.println("Insert integer: 57");
        x2.insert(57);
        x2.printKeys();
        System.out.println();
        x2.printKeysAndIndexes();
        System.out.println("The table size is " + x2.getTableSize() + ", the number of keys is " + x2.getNumKeys() + ", the load factor is " + x2.getLoadFactor());
        System.out.println();

        System.out.println("Test rehashing after insertion: insert 1001");
        x2.insert(1001);
        x2.printKeys();
        System.out.println();
        x2.printKeysAndIndexes();
        System.out.println("The table size is " + x2.getTableSize() + ", the number of keys is " + x2.getNumKeys() + ", the load factor is " + x2.getLoadFactor());
        System.out.println();

        System.out.println("isIn");
        System.out.println("isIn(11): " + x2.isIn(11));
        System.out.println("isIn(101): " + x2.isIn(101));
        System.out.println();

        for (double load : loads) {
            System.out.println("The average number of successful probes for load factor = " + load + " is " + avgSuccessfulQuad(load));
        }
    }
}
