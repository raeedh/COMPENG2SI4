package lab3;

public class BSTSet {
    private TNode root;

    public BSTSet() { // empty set
        root = null;
    }

    public BSTSet(int[] input) {
        if (input.length == 0) { // empty set
            new BSTSet();
        }
        else {
            sortArray(input); // sort array
            input = removeDuplicates(input); // remove duplicates from sorted array

            int l = -1, r = input.length;
            int mid = (r + l) / 2; // make root middle element
            root = new TNode(input[mid], new BSTSet(input, l, mid).root, new BSTSet(input, mid, r).root);
        } // left is the middle from start to middle and right is middle from middle to end
    }

    private BSTSet(int[] input, int l, int r) {
        if (l + 1 == r) {
            root = null;
        }
        else {
            int mid = (r+l) / 2; // repeat
            root = new TNode(input[mid], new BSTSet(input, l, mid).root, new BSTSet(input, mid, r).root);
        }
    }

    // O(log(n)) time complexity and O(1) space complexity
    public boolean isIn(int v) {
        TNode t = root;
        while (t != null) {
            if (t.element == v) return true;
            if (v < t.element) t = t.left;
            else t = t.right;
        }
        return false;
    }

    // O(log(n)) time complexity and O(1) space complexity
    public void add(int v) {
        if (isIn(v)) return; // do not add if it v is in set
        TNode t = root;
        while (t != null) {
            if (v < t.element) { // if v is less than current node
                if (t.left == null) { // add node to left when left is null
                    t.left = new TNode(v, null, null);
                    return;
                }
                t = t.left;
            }
            else {
                if (t.right == null) { // add node to right when right is null
                    t.right = new TNode(v, null, null);
                    return;
                }
                t = t.right;
            }
        }
    }

    // O(log(n)) time complexity and O(1) space complexity
    public boolean remove(int v) {
        if (!isIn(v)) return false;
        TNode t = root;

        if (v == root.element) {
            if (t.left.right == null) {
                root = new TNode(t.left.element, t.left.left, t.right);
            }
            else {
                TNode r = t.left.right;
                while (r.right != null) {
                    r = r.right;
                }
                root = new TNode(r.element, t.left, t.right);
                r = null;
            }
            return true;
        }

        while (t != null) {
            if (v < t.element) {
                if (t.left.element == v) {
                    if (t.left.left == null && t.left.right == null) {
                        t.left = null; // remove if leaf
                    }
                    else if (t.left.left != null && t.left.right == null) {
                        t.left = t.left.left; // make left its left subtree if no right subtree
                    }
                    else { // replace node with largest node in left subtree
                        TNode r = t.left.right;
                        while (r.right != null) {
                            r = r.right;
                        }
                        t.left = new TNode(r.element, t.left.left, t.left.right);
                        if (t.left.right.element == t.left.element) t.left.right = null;
                    }
                    return true;
                }
                t = t.left;
            }
            else {
                if (t.right.element == v) {
                    if (t.right.left == null && t.right.right == null) {
                        t.right = null; // remove if leaf
                    }
                    else if (t.right.right != null && t.right.left == null) {
                        t.right = t.right.right; // make right its right subtree if no left subtree
                    }
                    else { // replace node with largest node in left subtree
                        TNode r = t.right.left;
                        while (r.right != null) {
                            r = r.right;
                        }
                        t.right = new TNode(r.element, t.right.left, t.right.right);
                        if (t.right.left.element == t.right.element) t.right.left = null;
                    }
                    return true;
                }
                t = t.right;
            }
        }

        return true;
    }

    // O(n^2) time complexity and O(n) space complexity
    public BSTSet union(BSTSet s) {
        int[] thisArray = BSTToArray();
        int[] sArray = s.BSTToArray();
        int[] unionArray = new int[thisArray.length + sArray.length];
        int unionArrayIndex = 0;

        // add both arrays together
        for (int i = 0; i < thisArray.length; i++) {
            unionArray[unionArrayIndex++] = thisArray[i];
        }

        for (int i = 0; i < sArray.length; i++) {
            unionArray[unionArrayIndex++] = sArray[i];
        }

        return new BSTSet(unionArray);
    }

    // O(n^2) time complexity and O(n) space complexity
    public BSTSet intersection(BSTSet s) {
        int[] thisArray = BSTToArray();
        int[] sArray = s.BSTToArray();
        int[] interArray = justDuplicates(thisArray, sArray);

        sortArray(interArray);

        return new BSTSet(interArray);
    }

    // O(n^2) time complexity and O(n) space complexity
    public BSTSet difference(BSTSet s) {
        int[] thisArray = BSTToArray();
        int[] sArray = s.BSTToArray();

        BSTSet diffSet = new BSTSet(thisArray);

        for (int value : sArray) {
            diffSet.remove(value);
        }

        return diffSet;
    }

    // O(n) time complexity and O(log(n)) space complexity
    public int size() {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        else {
            int treeSize = 0;
            treeSize = size(root, treeSize);
            return treeSize;
        }
    }

    private int size(TNode t, int treeSize) {
        if (t != null) {
            treeSize++;
            treeSize = size(t.left, treeSize);
            treeSize = size(t.right, treeSize);
        }
        return treeSize;
    }

    // O(n) time complexity and O(log(n)) space complexity
    public int height() {
        if (root == null) {
            return -1;
        }
        else return height(root);
    }

    private int height(TNode t) {
        if (t == null) {
            return -1;
        }
        int leftHeight = height(t.left);
        int rightHeight = height(t.right);

        if (leftHeight > rightHeight) return leftHeight + 1;
        else return rightHeight + 1;
    }

    // O(n) time complexity and O(log(n)) space complexity
    public void printBSTSet() {
        if(root==null)
            System.out.println("The set is empty");
        else{
            System.out.print("The set elements are: ");
            printBSTSet(root);
            System.out.print("\n");
        }
    }

    private void printBSTSet(TNode t){
        if (t != null){
            printBSTSet(t.left);
            System.out.print(" " + t.element + ", ");
            printBSTSet(t.right);
        }
    }

    // O(n) time complexity and O(log(n)) space complexity
    public void printNonRec() {
        if (root == null) System.out.println("The set is empty");
        else {
            System.out.print("The set elements are: ");
            MyStack s = new MyStack();
            TNode t = root;

            while (t != null || !s.isEmpty()) {
                while (t != null) {
                    s.push(t);
                    t = t.left;
                }
                t = s.pop();
                System.out.print(" " + t.element + ", ");
                t = t.right;
            }
            System.out.print("\n");
        }
    }

    private void sortArray(int[] input) {
        for (int i = 0; i < input.length; i++) { // Bubble sort
            for (int j = i + 1; j < input.length; j++) {
                int tmp = 0;
                if (input[i] > input[j]) {
                    tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                }
            }
        }
    }

    private int[] removeDuplicates(int[] input) {
        int[] result = new int[input.length];
        result[0] = input[0];
        int valCheck = input[0];
        int resultIndex = 1;

        for (int i = 0; i < input.length; i++) { // if not equal to value checked then add to result (this assumes input is sorted)
            if (valCheck != input[i]) {
                result[resultIndex++] = input[i];
                valCheck = input[i];
            }
        }

        if (resultIndex < input.length) { // removes empty spaces at end
            int[] temp = new int[resultIndex];
            for (int i = 0; i < resultIndex; i++) {
                temp[i] = result[i];
            }
            result = temp;
        }

        return result;
    }

    private int[] justDuplicates(int[] thisInput, int[] sInput) {
        int[] result = new int[thisInput.length + sInput.length];
        int resultIndex = 0;

        for (int i = 0; i < thisInput.length; i++) { // if equal then add to result
            for (int j = 0; j < sInput.length; j++) {
                if (thisInput[i] == sInput[j]) {
                    result[resultIndex++] = thisInput[i];
                }
            }
        }

        if (resultIndex < result.length) { // remove empty spaces
            int[] temp = new int[resultIndex];
            for (int i = 0; i < resultIndex; i++) {
                temp[i] = result[i];
            }
            result = temp;
        }

        return result;
    }

    private int[] BSTToArray() {
        if (size() == 0) return new int[0];
        int[] arr = new int[size()];
        int arrIndex = 0;

        BSTToArray(root, arr, arrIndex);


        return arr;
    }

    private int BSTToArray(TNode t, int[] arr, int arrIndex) {
        if (t == null) return arrIndex;
        arrIndex = BSTToArray(t.left, arr, arrIndex);
        arr[arrIndex++] = t.element;
        arrIndex = BSTToArray(t.right, arr, arrIndex);
        return arrIndex;
    }
}

