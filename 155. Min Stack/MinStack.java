import java.util.Stack;

class MinStack {
    private final Stack<Integer> minValues = new Stack<>();

    private final Stack<Integer> stack = new Stack<>();

    public MinStack() {
        System.out.println("MinStack Created!");
    }

    public void push(int val) {
        stack.push(val);
        if (minValues.empty() || val <= minValues.peek()) minValues.push(val);
    }

    public void pop() {
        if (this.stack.empty()) return;
        int removedValue = stack.pop();
        if (!minValues.empty() && minValues.peek() == removedValue) minValues.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (minValues.empty()) return 0;
        return minValues.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
