package lab3;

public class MyStack {
    public class StackLLNode {
        TNode node;
        StackLLNode prev;

        public StackLLNode(TNode t, StackLLNode p) {
            node = t;
            prev = p;
        }
    }
    private StackLLNode top;

    public MyStack() {
        top = null;
    } // empty stack

    public boolean isEmpty() { // check if stack is empty
        return top == null;
    }

    public void push(TNode t) {
        if (top == null) { // if stack is empty, make top w/ no prev
            top = new StackLLNode(t,null);
        }
        else {
            top = new StackLLNode(t, top);
        }
    }

    public TNode pop() {
        TNode t = top.node; // store node to be popped
        if (top.prev == null) { // make top null if top is only node in stack
            top = null;
        }
        else {
            top = top.prev;
        }
        return t;
    }
}
