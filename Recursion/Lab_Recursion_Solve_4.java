package Recursion;
class Node {
    int elem;
    Node next;

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }
}
public class Lab_Recursion_Solve_4 {
    // ==========================================
    // Task 4A: Print Elements in Reverse Order
    // ==========================================
    public static void task4A_recursive(Node head) {
        // Base case: if we reach the end of the list, stop and begin backtracking
        if (head == null) {
            return;
        }
        
        // 1. Recursive call FIRST: traverse to the very end of the list
        task4A_recursive(head.next);
        
        // 2. Action AFTER the call returns (Backtracking step): print the element
        System.out.print(head.elem + " ");
    }

    // ==========================================
    // Task 4B: Reverse the Linked List In-Place
    // ==========================================
    public static Node task4B_recursive(Node head) {
        // Base case: If list is empty or has only one node, it's already reversed.
        // This also captures the very last node of the original list, 
        // which becomes the new head.
        if (head == null || head.next == null) {
            return head;
        }

        // 1. Recursive call: traverse to the end. 
        // newHead will catch the last node and bubble it all the way up to the return.
        Node newHead = task4B_recursive(head.next);

        // 2. Backtracking step: Reverse the pointers.
        // Example: If we are at Node(2) -> Node(3)
        // head is Node(2), head.next is Node(3).
        // We want Node(3) to point back to Node(2).
        head.next.next = head;

        // 3. Break the forward link to prevent infinite cycles. 
        // Node(2) should now point to null (it will be updated by the previous node in the stack).
        head.next = null;

        // Pass the new head back up the call stack
        return newHead;
    }

    // Helper method to print the list normally to verify Task 4B
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.elem + " ");
            current = current.next;
        }
        System.out.println();
    }

    // ==========================================
    // Main Method (Tester)
    // ==========================================
    public static void main(String[] args) {
        // Creating a linked list: 10 -> 20 -> 30 -> 40
        Node head = new Node(10, new Node(20, new Node(30, new Node(40, null))));

        System.out.println("--- Original List ---");
        printList(head);

        System.out.println("\n--- Task 4A: Print Reverse ---");
        System.out.print("Reversed Output: ");
        task4A_recursive(head); // Expected: 40 30 20 10
        System.out.println();   // formatting newline

        System.out.println("\n--- Task 4B: Reverse List In-Place ---");
        // We re-assign 'head' to the new head returned by the function
        head = task4B_recursive(head);
        
        System.out.print("New List Structure: ");
        printList(head); // Expected: 40 30 20 10
    }
}
