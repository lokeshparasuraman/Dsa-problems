package StacksAndQueues;

public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int val) {
        if (isFull()) {
            return false;
        }
        ptr++;
        data[ptr] = val;
        return true;
    }

    private boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return data[ptr--];
    }

    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomStack();
        stack.push(14);
        stack.push(5);
        stack.push(99);
        stack.push(81);
        stack.push(86);
        System.out.println(stack.pop());
    }
}
