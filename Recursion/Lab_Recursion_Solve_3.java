package Recursion;
class Node {
    int elem;
    Node next;

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }
}
public class Lab_Recursion_Solve_3 {
    // ==========================================
    // Task 3A: Print Linked List Iteratively
    // ==========================================
    public static void task3A(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.elem + " ");
            current = current.next;
        }
        System.out.println();
    }

    // ==========================================
    // Task 3B: Print Linked List Recursively
    // ==========================================
    public static void task3B_recursive(Node head) {
        // Base case: if we reach the end of the list
        if (head == null) {
            System.out.println(); // Print newline at the very end
            return;
        }
        System.out.print(head.elem + " ");
        
        // Recursive step: pass the next node
        task3B_recursive(head.next);
    }

    // ==========================================
    // Task 3C: Summation of elements iteratively
    // ==========================================
    public static int task3C(Node head) {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.elem;
            current = current.next;
        }
        return sum;
    }

    // ==========================================
    // Task 3D: Summation of elements recursively
    // (Note: Image labels it task3C_recursive, but following D pattern)
    // ==========================================
    public static int task3D_recursive(Node head) {
        if (head == null) {
            return 0; // Base case: end of list contributes 0 to sum
        }
        return head.elem + task3D_recursive(head.next);
    }

    // ==========================================
    // Task 3E: Sum of odds - Multiplication of evens
    // ==========================================
    public static int task3E(Node head) {
        int sumOdd = 0;
        int multEven = 1; // Start at 1 for multiplication
        
        Node current = head;
        while (current != null) {
            if (current.elem % 2 != 0) {
                sumOdd += current.elem;    // Summing odd elements
            } else {
                multEven *= current.elem;  // Multiplying even elements
            }
            current = current.next;
        }
        
        return sumOdd - multEven;
    }

    // ==========================================
    // Task 3F: Task 3E but using recursion
    // ==========================================
    public static int task3F_recursive(Node head) {
        // Utilizing separate helper functions to calculate independently
        int sumOdd = helperSumOdd(head);
        int multEven = helperMultEven(head);
        return sumOdd - multEven;
    }

    // Helper for adding odd elements
    private static int helperSumOdd(Node head) {
        if (head == null) {
            return 0; // Base case for addition
        }
        
        if (head.elem % 2 != 0) {
            return head.elem + helperSumOdd(head.next); // Add and move to next
        } else {
            return helperSumOdd(head.next); // Skip and move to next
        }
    }

    // Helper for multiplying even elements
    private static int helperMultEven(Node head) {
        if (head == null) {
            return 1; // Base case for multiplication is 1
        }
        
        if (head.elem % 2 == 0) {
            return head.elem * helperMultEven(head.next); // Multiply and move to next
        } else {
            return helperMultEven(head.next); // Skip and move to next
        }
    }

    // ==========================================
    // Main Method (Tester)
    // ==========================================
    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3 -> 4
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        
        // Logic breakdown for 3E/3F:
        // Odds: 1, 3 -> sum = 4
        // Evens: 2, 4 -> mult = 8
        // Expected result: 4 - 8 = -4

        System.out.println("--- Task 3A & 3B ---");
        System.out.print("Iterative Print: ");
        task3A(head);
        System.out.print("Recursive Print: ");
        task3B_recursive(head);

        System.out.println("\n--- Task 3C & 3D ---");
        System.out.println("Iterative Sum: " + task3C(head));
        System.out.println("Recursive Sum: " + task3D_recursive(head));

        System.out.println("\n--- Task 3E & 3F ---");
        System.out.println("Iterative Calculation: " + task3E(head));
        System.out.println("Recursive Calculation: " + task3F_recursive(head));
    }
}
