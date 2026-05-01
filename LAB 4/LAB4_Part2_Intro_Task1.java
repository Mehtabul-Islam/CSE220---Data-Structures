class ArrayStack {
    // Two private instance variables as requested
    private Object[] stack;
    private int top;

    // Constructor to initialize the stack with a specific size
    public ArrayStack(int size) {
        this.stack = new Object[size];
        this.top = -1; // Initializes at -1 indicating an empty stack
    }

    // Inserts an element at the top of the stack
    public void push(Object element) {
        // Check if the stack is full (overflow condition)
        if (top == stack.length - 1) {
            System.out.println("stack overflow");
        } else {
            top++; // Increment top
            stack[top] = element; // Insert element
        }
    }

    // Removes and returns the top element of the stack
    public Object pop() {
        // Check if the stack is empty (underflow condition)
        if (top == -1) {
            System.out.println("stack underflow");
            return null;
        } else {
            Object poppedElement = stack[top];
            // Optional but good practice: clear the reference 
            // stack[top] = null; 
            top--; // Decrement top
            return poppedElement;
        }
    }

    // Returns the top element without removing it
    public Object peek() {
        if (top == -1) {
            return null;
        } else {
            return stack[top];
        }
    }

    // Returns true if the stack contains no elements, otherwise false
    public boolean isEmpty() {
        return top == -1;
    }
}
public class LAB4_Part2_Intro_Task1 {
    public static void main(String[] args) {
        System.out.println("=== Testing ArrayStack ===");
        
        // Initialize a stack of size 3
        ArrayStack myStack = new ArrayStack(3);
        
        System.out.println("1. Is stack empty? " + myStack.isEmpty()); // Expected: true
        
        System.out.println("\n2. Pushing 10, 20, 30 onto the stack...");
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        
        System.out.println("3. Is stack empty? " + myStack.isEmpty()); // Expected: false
        System.out.println("4. Peek top element: " + myStack.peek());   // Expected: 30
        
        System.out.println("\n5. Pushing 40 to trigger overflow...");
        myStack.push(40); // Expected: stack overflow output
        
        System.out.println("\n6. Popping elements...");
        System.out.println("Popped: " + myStack.pop()); // Expected: 30
        System.out.println("Popped: " + myStack.pop()); // Expected: 20
        
        System.out.println("\n7. Peek current top: " + myStack.peek()); // Expected: 10
        
        System.out.println("\n8. Popping remaining elements...");
        System.out.println("Popped: " + myStack.pop()); // Expected: 10
        
        System.out.println("\n9. Popping from empty stack to trigger underflow...");
        Object result = myStack.pop(); // Expected: stack underflow output
        System.out.println("Result returned: " + result); // Expected: null
    }
}
