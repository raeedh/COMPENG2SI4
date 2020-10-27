package lab5;

public class MaxHeap {
    private Integer[] heapData;
    private int size;
    private int capacity;

    public MaxHeap(int n) throws IllegalArgumentException {
        if (n < 1) throw new IllegalArgumentException("The value of n must be > 0"); // throws exception if n is 0 ()
        heapData = new Integer[n];
        size = 0;
        capacity = n;
    }

    public MaxHeap(Integer[] someArray) throws IllegalArgumentException {
        if (someArray.length < 1) throw new IllegalArgumentException("The size of the array cannot be 0");
        size = 0;
        capacity = someArray.length;
        heapData = new Integer[capacity];
        for (Integer element : someArray) {
            if (element == null) { // reduces capacity if element was null
                capacity--;
            } else insert(element);
        }
    }

    // O(1) average time complexity; O(logn) worst time complexity; O(1) space complexity
    public void insert(int n) {
        if (size == capacity) reallocateSize(); // checks if heap is full, reallocate memory if it is
        heapData[size] = n;
        size++;
        maintainMaxHeapInsert();
    }

    private void maintainMaxHeapInsert() { // maintains max heap properties
        int index = size - 1;

        while (index > 0 && (heapData[index] > heapData[getParentIndex(index)])) { // check if parent is smaller, swap if it is
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }

    private void swap(int a, int b) {
        int temp = heapData[a];
        heapData[a] = heapData[b];
        heapData[b] = temp;
    }

    private int getParentIndex(int i) {
        return (i-1)/2;
    }

    private int getLCIndex(int i) {
        return (2*i)+1;
    }

    private int getRCIndex(int i) {
        return (2*i)+2;
    }

    private void reallocateSize() {
        capacity = capacity*2;
        Integer[] temp = new Integer[capacity];
        int i = 0;
        for (Integer value : heapData) {
            temp[i] = value;
            i++;
        }
        heapData = temp;
    }

    // O(logn) average time complexity; O(1) space complexity
    public int deleteMax() { // deletes maximum element from list
        size--;
        int max = heapData[0];

        heapData[0] = heapData[size]; // moves last element in array to start root
        heapData[size] = null;
        maintainMaxHeapDelete();

        return max;
    }

    private void maintainMaxHeapDelete() { // maintains max heap properties
        int index = 0;
        while (getLCIndex(index) < size) { // moves down element to correct position
            int largestChild = getLCIndex(index);
            if ((getRCIndex(index) < size) && (heapData[getRCIndex(index)] > heapData[getLCIndex(index)])) largestChild = getRCIndex(index);

            if (heapData[index] < heapData[largestChild]) {
                swap(index, largestChild);
                index = largestChild;
            } else break;
        }
    }

    // O(n) time complexity;
    public String toString() {
        if (size == 0) return "The heap is empty";
        String output = "";
        for (Integer value : heapData) {
            if (value != null) output = output + value + ", ";
        }
        return output;
    }

    // O(nlog(n)) time complexity; O(1) space complexity
    public static void heapsort(Integer[] arrayToSort) {
        MaxHeap heapSortHeap = new MaxHeap(arrayToSort);
        int heapSize = heapSortHeap.getSize();
        for (int i = 0; i < heapSize; i++) {
            arrayToSort[i] = heapSortHeap.deleteMax();
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
