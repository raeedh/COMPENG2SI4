package lab5;

import java.util.Arrays;

public class TestMaxHeap {
    public static void main(String[] args) {
        MaxHeap m;
        Integer[] arr;

        System.out.println("Test constructor 1, get methods and toString()");
        System.out.println();

        System.out.println("n < 1");
        try {
            m = new MaxHeap(-10);
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        } System.out.println();

        System.out.println("n > 0");
        m = new MaxHeap(10);
        System.out.println("The size is " + m.getSize());
        System.out.println("The capacity is " + m.getCapacity());
        System.out.println(m.toString());

        System.out.println();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println();

        System.out.println("Test constructor 2, get methods and toString()");
        System.out.println();

        System.out.println("Empty array");
        try {
            arr = new Integer[0];
            m = new MaxHeap(arr);
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        } System.out.println();

        System.out.println("Array with no duplicates: {-5, 1, 10, 18, 612, -71}");
        arr = new Integer[]{-5,1,10,18,612,-71};
        m = new MaxHeap(arr);
        System.out.println("The size is " + m.getSize());
        System.out.println("The capacity is " + m.getCapacity());
        System.out.println(m.toString());
        System.out.println();

        System.out.println("Array with duplicates: {-5, 1, 18, 1, 612, -71, -5}");
        arr = new Integer[]{-5,1,18,1,612,-71,-5};
        m = new MaxHeap(arr);
        System.out.println("The size is " + m.getSize());
        System.out.println("The capacity is " + m.getCapacity());
        System.out.println(m.toString());

        System.out.println();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println();

        System.out.println("Test insert() method");
        System.out.println();

        System.out.println("Insert to empty heap");
        m = new MaxHeap(5);
        System.out.println("The size is " + m.getSize());
        System.out.println("The capacity is " + m.getCapacity());
        System.out.println();

        System.out.println("Insert 50");
        m.insert(50);
        System.out.println("The size is " + m.getSize());
        System.out.println("The capacity is " + m.getCapacity());
        System.out.println(m.toString());
        System.out.println();

        System.out.println("Insert 1, -100, 79 812");
        m.insert(1);
        m.insert(-100);
        m.insert(79);
        m.insert(812);
        System.out.println("The size is " + m.getSize());
        System.out.println("The capacity is " + m.getCapacity());
        System.out.println(m.toString());
        System.out.println();

        System.out.println("Insert to full heap: insert -500");
        m.insert(-500);
        System.out.println("The size is " + m.getSize());
        System.out.println("The capacity is " + m.getCapacity());
        System.out.println(m.toString());
        System.out.println();

        System.out.println("Insert duplicate: insert 1");
        m.insert(1);
        System.out.println("The size is " + m.getSize());
        System.out.println("The capacity is " + m.getCapacity());
        System.out.println(m.toString());

        System.out.println();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println();

        System.out.println("Test heapsort method and deleteMax() methods");
        System.out.println();

        arr = new Integer[]{-9,1,712,8123,-790123,6123,8123,69,2,2,7123,812356,-6548};
        System.out.println("Sort array: " + Arrays.toString(arr));
        MaxHeap.heapsort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        arr = new Integer[]{0,6123,-651,676892,10293,-138501,138905618,1290,-12903,-6902834,12903,968123,-6901823,9051283,68901823,-59016123,0};
        System.out.println("Sort array: " + Arrays.toString(arr));
        MaxHeap.heapsort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }
}
