package lab4;

public class HashTableQuad {
    private Integer[] table;
    private int tableSize;
    private int numKeys;
    private double maxLoadFactor;

    public HashTableQuad(int maxNum, double load) {
        table = new Integer[smallestPrime(maxNum, load)];
        tableSize = table.length;
        numKeys = 0;
        maxLoadFactor = load;
    }

    private int smallestPrime(int maxNum, double load) {
        double smallestNum = maxNum/load;
        int smallestPrimeNum;
        if (smallestNum % 1 == 0) smallestPrimeNum = (int) smallestNum;
        else {
            smallestPrimeNum = (int) smallestNum + 1;
        }

        // iterates until finds prime
        while (true) {
            boolean isPrime = checkPrime(smallestPrimeNum);
            if (isPrime) return smallestPrimeNum;
            smallestPrimeNum++;
        }
    }

    private int smallestPrime(int minNum) { // use for rehashing
        int smallestPrimeNum = minNum;

        while (true) {
            boolean isPrime = checkPrime(smallestPrimeNum);
            if (isPrime) return smallestPrimeNum;
            smallestPrimeNum++;
        }
    }

    public boolean checkPrime(int numToCheck) {
        if (numToCheck == 1) return false;
        if (numToCheck == 2) return true;
        for (int i = 2; i <= (numToCheck/2); i++) {
            if (numToCheck % i == 0) return false;
        } // checks modulo for every possible factor from 2 < x < n/2
        return true;
    }


    private int hashIndex(int n) {
        return (n % tableSize);
    }

    public void insert(int n) { // runtime: O(1)
        if (isIn(n)) return;
        if (((numKeys+1.0)/tableSize) > maxLoadFactor) rehash(); // rehash if load factor goes over max load factor
        int hash = hashIndex(n);
        int hashQuad = hash;
        int i = 1;
        while (table[hashQuad] != null) {
            if (table[hash] == n) return;
            hashQuad = hashIndex(hash+(i*i));
            i++;
        }
        table[hashQuad] = n;
        numKeys++;
    }

    public int insertTest(int n) { // for use in test class
        if (isIn(n)) return 0;
        int probes = 1;
        if (((numKeys+1.0)/tableSize) > maxLoadFactor) rehash(); // rehash if load factor goes over max load factor
        int hash = hashIndex(n);
        int hashQuad = hash;
        int i = 1;
        while (table[hashQuad] != null) {
            hashQuad = hashIndex(hash+(i*i));
            i++;
            probes++;
        }
        table[hashQuad] = n;
        numKeys++;
        return  probes;
    }

    private void rehash() { // runtime: O(n)
        Integer[] tempTable = table;
        table = new Integer[smallestPrime(tableSize*2)];
        numKeys = 0;
        tableSize = table.length;
        for (Integer key : tempTable) {
            if (key != null) {
                insert(key);
            }
        }
    }

    public boolean isIn(int n) { // runtime: O(1)
        int hash = hashIndex(n);
        int hashQuad = hash;
        int i = 1;
        while (table[hashQuad] != null) {
            if (table[hashQuad] == n) return true;
            hashQuad = hashIndex(hash+(i*i));
            i++;
        }
        return false;
    }

    public void printKeys() { // runtime: O(n)
        if (numKeys == 0) {
            System.out.println("The hash table is empty");
            return;
        }
        for (Integer key : table) {
            if (key != null) {
                System.out.print(key + " ");
            }
        }
    }

    public void printKeysAndIndexes() { // runtime: O(n)
        if (numKeys == 0) {
            System.out.println("The hash table is empty");
            return;
        }
        for (int i = 0; i < tableSize; i++) {
            if (table[i] != null) {
                System.out.println(i + ": " + table[i]);
            }
        }
    }

    public int getTableSize() {
        return tableSize;
    }

    public int getNumKeys() {
        return numKeys;
    }

    public double getMaxLoadFactor() {
        return maxLoadFactor;
    }

    public double getLoadFactor() {
        return ((double) getNumKeys() / getTableSize());
    }
}
