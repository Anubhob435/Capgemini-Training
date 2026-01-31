package dsa.basics;

public class StackArrayEg {

    int top;
    int[] stack;
    int size;

    public StackArrayEg(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    // PUSH
    public void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow - cannot push");
            return;
        }
        stack[++top] = value;
    }

    // POP
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow - empty stack");
            return -1;
        }
        return stack[top--];
    }

    // PEEK
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

class Main {

    public static void main(String[] args) {

        StackArrayEg s = new StackArrayEg(5);

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();          

        System.out.println("Peek: " + s.peek());
        System.out.println("Pop: " + s.pop());

        s.display();
    }
}