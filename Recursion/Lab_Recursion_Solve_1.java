package Recursion;
public class Lab_Recursion_Solve_1 {
    // ==========================================
    // Task 1A: Iterative 1 to 10
    // ==========================================
    public static void task1A() {
        int i = 1; // Using a local variable
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }
    // ==========================================
    // Task 1B: Recursive 1 to 10
    // ==========================================
    public static void task1B_recursive() {
        // Start the recursion at 1 using a helper method
        helper1B(1); 
    }

    // Helper method for 1B to pass the local state via parameters
    private static void helper1B(int current) {
        // Base case: stop when current exceeds 10
        if (current > 10) {
            return;
        }
        System.out.println(current);
        // Recursive step: call with the next number
        helper1B(current + 1); 
    }

    // ==========================================
    // Task 1C: Iterative 1 to N
    // ==========================================
    public static void task1C(int N) {
        int i = 1; // Using a local variable
        while (i <= N) {
            System.out.println(i);
            i++;
        }
    }

    // ==========================================
    // Task 1D: Recursive 1 to N
    // ==========================================
    public static void task1D_recursive(int N) {
        // Start the recursion at 1, passing the target N as well
        helper1D(1, N);
    }

    // Helper method for 1D to track the current number and the target N
    private static void helper1D(int current, int target) {
        // Base case: stop when current exceeds the target N
        if (current > target) {
            return;
        }
        System.out.println(current);
        // Recursive step: increment current, keep target the same
        helper1D(current + 1, target);
    }

    // ==========================================
    // Main Method (Tester)
    // ==========================================
    public static void main(String[] args) {
        System.out.println("--- Task 1A ---");
        task1A();

        System.out.println("\n--- Task 1B ---");
        task1B_recursive();

        System.out.println("\n--- Task 1C (N=5) ---");
        task1C(5);

        System.out.println("\n--- Task 1D (N=5) ---");
        task1D_recursive(5);
    }
}
