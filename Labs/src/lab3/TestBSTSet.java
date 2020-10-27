package lab3;

public class TestBSTSet {
    public static void main(String[] args) {
        int[] s0 = {};
        int[] s1 = {0,5,6,1,2,8,32,15,29,86}; // unsorted set with no repetition
        int[] s2 = {1,5,9,15,19,31,37,54}; // sorted set with no repetition
        int[] s4 = {0,0,6,7,13,16,16,60}; // sorted set with repetition

        System.out.println("Constructor tests");
        System.out.println();

        System.out.println("Constructor 1");
        BSTSet t1 = new BSTSet();
        t1.printBSTSet();
        System.out.println();

        System.out.println("Constructor 2");
        System.out.println("Empty set");
        t1 = new BSTSet(s0);
        t1.printBSTSet();
        System.out.println("No repetition");
        t1 = new BSTSet(s1);
        t1.printBSTSet();
        System.out.println("Repetition");
        t1 = new BSTSet(s4);
        t1.printBSTSet();
        System.out.println();

        System.out.println("isIn");
        System.out.println("Value is in set");
        t1 = new BSTSet(s2);
        System.out.println(t1.isIn(31));
        System.out.println("Value is not in set");
        System.out.println(t1.isIn(0));
        t1 = new BSTSet();
        System.out.println("isIn for an empty set");
        System.out.println(t1.isIn(1));
        System.out.println();

        System.out.println("Add");
        System.out.println("Value is in set");
        t1 = new BSTSet(s1);
        t1.add(2);
        t1.printBSTSet();
        System.out.println("Value is not in set");
        t1.add(3);
        t1.printBSTSet();
        System.out.println("Value added to empty set");
        t1 = new BSTSet();
        t1.add(100);
        t1.printBSTSet();
        System.out.println();

        System.out.println("Remove");
        System.out.println("Value is not in set");
        t1 = new BSTSet(s4);
        System.out.println(t1.remove(100));
        t1.printBSTSet();
        System.out.println("Value is in set");
        System.out.println(t1.remove(16));
        t1.printBSTSet();
        t1 = new BSTSet();
        System.out.println("Value removed from empty set");
        System.out.println(t1.remove(10));
        t1.printBSTSet();
        System.out.println();

        int[] s5 = {1,4,7,8,10,12,17,51,13,15,18};
        int[] s6 = {2,5,9,11,17};
        int[] s7 = {0,3,10,9,16,61};

        System.out.println("Union");
        System.out.println("No common elements in sets");
        BSTSet a1 = new BSTSet(s5);
        BSTSet a2 = new BSTSet(s6);
        BSTSet a3 = a1.union(a2);
        a3.printBSTSet();
        System.out.println("Common values in sets");
        a1 = new BSTSet(s5);
        a2 = new BSTSet(s7);
        a3 = a1.union(a2);
        a3.printBSTSet();
        System.out.println("Union with empty set");
        a2 = new BSTSet();
        a3 = a1.union(a2);
        a3.printBSTSet();
        System.out.println();


        System.out.println("Intersection");
        System.out.println("No common elements in sets");
        a1 = new BSTSet(s5);
        a2 = new BSTSet(s6);
        a3 = a1.intersection(a2);
        a3.printBSTSet();
        System.out.println("Common values in sets");
        a1 = new BSTSet(s5);
        a2 = new BSTSet(s7);
        a3 = a1.intersection(a2);
        a3.printBSTSet();
        System.out.println("Intersection with empty set");
        a2 = new BSTSet();
        a3 = a1.intersection(a2);
        a3.printBSTSet();
        System.out.println();

        System.out.println("Difference");
        System.out.println("No common elements in sets");
        a1 = new BSTSet(s5);
        a2 = new BSTSet(s6);
        a3 = a1.difference(a2);
        a3.printBSTSet();
        System.out.println("Common values in sets");
        a1 = new BSTSet(s5);
        a2 = new BSTSet(s7);
        a3 = a1.difference(a2);
        a3.printBSTSet();
        System.out.println("Difference with empty set");
        a2 = new BSTSet();
        a3 = a1.difference(a2);
        a3.printBSTSet();
        System.out.println();

        System.out.println("Size and height");
        System.out.println("Empty set");
        a1 = new BSTSet();
        System.out.println("Size is " + a1.size() + " and height is " + a1.height());
        System.out.println("Not empty set");
        a1 = new BSTSet(s1);
        System.out.println("Size is " + a1.size() + " and height is " + a1.height());
        System.out.println();

        System.out.println("printNonRec");
        System.out.println("Empty set");
        a1 = new BSTSet();
        a1.printNonRec();
        System.out.println("Not empty set");
        a1 = new BSTSet(s1);
        a1.printNonRec();
    }
}
