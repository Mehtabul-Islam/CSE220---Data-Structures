package Recursion;

public class Lab_Recursion_Solve_2 {
    // ==========================================
    // Task 2A: Print array iteratively (while loop)
    // ==========================================
    public static void task2A(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }
        System.out.println(); // For cleaner output formatting
    }

    // ==========================================
    // Task 2B: Print array recursively
    // ==========================================
    public static void task2B_recursive(int[] arr) {
        helper2B(arr, 0);
        System.out.println(); // For cleaner output formatting
    }

    // Helper method to pass the current index
    private static void helper2B(int[] arr, int index) {
        if (index >= arr.length) {
            return; // Base case: end of array
        }
        System.out.print(arr[index] + " ");
        helper2B(arr, index + 1); // Recursive step
    }

    // ==========================================
    // Task 2C: Summation of elements iteratively
    // ==========================================
    public static int task2C(int[] arr) {
        int sum = 0;
        int i = 0;
        while (i < arr.length) {
            sum += arr[i];
            i++;
        }
        return sum;
    }

    // ==========================================
    // Task 2D: Summation of elements recursively
    // ==========================================
    public static int task2D_recursive(int[] arr) {
        return helper2D(arr, 0);
    }

    private static int helper2D(int[] arr, int index) {
        if (index >= arr.length) {
            return 0; // Base case: nothing left to add
        }
        return arr[index] + helper2D(arr, index + 1);
    }

    // ==========================================
    // Task 2E: Multiply odds, sum evens, subtract
    // ==========================================
    public static int task2E(int[] arr) {
        int sumEven = 0;
        int multOdd = 1; // Initialized to 1 (standard for multiplication)
        int i = 0;

        while (i < arr.length) {
            // Using != 0 handles negative odd numbers properly in Java
            if (arr[i] % 2 != 0) { 
                multOdd *= arr[i];
            } else {
                sumEven += arr[i];
            }
            i++;
        }
        
        return multOdd - sumEven;
    }

    // ==========================================
    // Task 2F: Task 2E but using recursion
    // ==========================================
    public static int task2F_recursive(int[] arr) {
        // Utilizing separate helper functions as suggested in the prompt
        int multOdd = helperMultOdd(arr, 0);
        int sumEven = helperSumEven(arr, 0);
        return multOdd - sumEven;
    }

    private static int helperSumEven(int[] arr, int index) {
        if (index >= arr.length) {
            return 0; // Base case for addition
        }
        
        if (arr[index] % 2 == 0) {
            // Add current even number and move to next
            return arr[index] + helperSumEven(arr, index + 1);
        } else {
            // Skip current odd number and move to next
            return helperSumEven(arr, index + 1);
        }
    }

    private static int helperMultOdd(int[] arr, int index) {
        if (index >= arr.length) {
            return 1; // Base case for multiplication
        }
        
        if (arr[index] % 2 != 0) {
            // Multiply current odd number and move to next
            return arr[index] * helperMultOdd(arr, index + 1);
        } else {
            // Skip current even number and move to next
            return helperMultOdd(arr, index + 1);
        }
    }

    // ==========================================
    // Main Method (Tester)
    // ==========================================
    public static void main(String[] args) {
        int[] testArray = {2, 3, 4, 5}; 
        // Logic check: 
        // Evens: 2, 4 -> sum = 6
        // Odds: 3, 5 -> mult = 15
        // Expected Subtraction: 15 - 6 = 9

        System.out.println("--- Task 2A & 2B ---");
        System.out.print("Iterative: ");
        task2A(testArray);
        System.out.print("Recursive: ");
        task2B_recursive(testArray);

        System.out.println("\n--- Task 2C & 2D ---");
        System.out.println("Iterative Sum: " + task2C(testArray));
        System.out.println("Recursive Sum: " + task2D_recursive(testArray));

        System.out.println("\n--- Task 2E & 2F ---");
        System.out.println("Iterative Calculation: " + task2E(testArray));
        System.out.println("Recursive Calculation: " + task2F_recursive(testArray));
    }
}
