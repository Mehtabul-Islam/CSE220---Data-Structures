import java.util.Stack;
public class LAB4_Part2_Assignment_Task_1 {
    public static Stack<Integer> conditional_reverse(Stack<Integer> inputStack) {
        // Handle null or empty input
        if (inputStack == null || inputStack.isEmpty()) {
            return new Stack<>();
        }

        // New stack to hold the processed values
        Stack<Integer> resultStack = new Stack<>();

        // Step 1 & 2: Pop elements from input (top to bottom)
        // This naturally reverses the order while we filter duplicates
        while (!inputStack.isEmpty()) {
            int current = inputStack.pop();

            // Only push if the result stack is empty 
            // OR if the current value is NOT the same as the previous pushed value
            if (resultStack.isEmpty() || current != resultStack.peek()) {
                resultStack.push(current);
            }
        }

        // According to the sample: 
        // Input (bottom to top): 10, 10, 20, 20, 30, 10, 50 (Top is 50)
        // ResultStack should contain (bottom to top): 50, 10, 30, 20, 10 (Top is 10)
        return resultStack;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        System.out.println("=== Testing Stack: Conditional Reverse ===\n");

        // --- Sample Case ---
        Stack<Integer> s1 = new Stack<>();
        // Building input bottom to top: 10, 10, 20, 20, 30, 10, 50
        int[] inputVals = {10, 10, 20, 20, 30, 10, 50};
        for (int val : inputVals) {
            s1.push(val);
        }

        System.out.println("Input Stack (Rightmost is top): " + formatStack(s1));
        System.out.println("Input Top: " + s1.peek());

        Stack<Integer> result = conditional_reverse(s1);

        System.out.println("\nExpected Output: 50, 10, 30, 20, 10 (Top is 10)");
        System.out.println("Your Output:     " + formatStack(result));
        
        if (!result.isEmpty()) {
            System.out.println("Your Top:        " + result.peek());
        }
    }

    // Helper method to display stack elements from bottom to top
    public static String formatStack(Stack<Integer> st) {
        if (st.isEmpty()) return "Empty";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.size(); i++) {
            sb.append(st.get(i));
            if (i < st.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }
}
