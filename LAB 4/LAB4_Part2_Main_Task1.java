import java.util.Stack;
public class LAB4_Part2_Main_Task1 {
    public static void removeNthBlock(Stack<Integer> st, int n) {
        // Edge case: if the stack is empty or n is invalid
        if (st.isEmpty() || n <= 0) {
            return;
        }

        // We use an auxiliary stack to hold the blocks we need to preserve
        Stack<Integer> tempStack = new Stack<>();

        // Step 1: Pop (n-1) elements from the original stack and push to tempStack
        for (int i = 1; i < n; i++) {
            if (!st.isEmpty()) {
                tempStack.push(st.pop());
            } else {
                // If n is larger than the stack size, we stop early
                break; 
            }
        }

        // Step 2: The nth element is now at the top of the stack. Pop and discard it.
        if (!st.isEmpty()) {
            st.pop();
        }

        // Step 3: Pop all elements from tempStack and push them back to the original stack
        // This restores their relative positions
        while (!tempStack.isEmpty()) {
            st.push(tempStack.pop());
        }
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        System.out.println("=== Testing Tower of Blocks (Stack) Task ===\n");

        // --- Sample 1 ---
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(4);
        stack1.push(19);
        stack1.push(23);
        stack1.push(17);
        stack1.push(5);
        int n1 = 2;

        System.out.println("Sample 1:");
        System.out.println("Original Stack (Rightmost is top): " + formatStack(stack1));
        System.out.println("n: " + n1);
        
        removeNthBlock(stack1, n1);
        
        System.out.println("Expected Output: Stack: 4 19 23 5");
        System.out.println("Your Output:     Stack: " + formatStack(stack1));
        System.out.println();

        // --- Sample 2 ---
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(73);
        stack2.push(85);
        stack2.push(15);
        stack2.push(41);
        int n2 = 3;

        System.out.println("Sample 2:");
        System.out.println("Original Stack (Rightmost is top): " + formatStack(stack2));
        System.out.println("n: " + n2);
        
        removeNthBlock(stack2, n2);
        
        System.out.println("Expected Output: Stack: 73 15 41");
        System.out.println("Your Output:     Stack: " + formatStack(stack2));
    }

    // Helper method to print the stack from bottom to top safely 
    // without permanently altering it, just for visualization in the tester.
    public static String formatStack(Stack<Integer> st) {
        StringBuilder sb = new StringBuilder();
        for (Integer item : st) {
            sb.append(item).append(" ");
        }
        return sb.toString().trim();
    }
}

