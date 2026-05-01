package Recursion;
class Node {
    int elem;
    Node next;

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }
}
public class Lab_Recursion_Solve_5 {
    // ==========================================
    // Task 5A: Find Maximum Recursively
    // ==========================================
    public static int findMax_recursive(Node head) {
        // Base case: If list is empty (edge case)
        if (head == null) {
            return Integer.MIN_VALUE; 
        }
        // Base case: Only one element left
        if (head.next == null) {
            return head.elem;
        }

        // Recursive step: find the max of the rest of the list
        int maxOfRest = findMax_recursive(head.next);

        // Return the greater of the current element and the max of the rest
        return Math.max(head.elem, maxOfRest);
    }

    // ==========================================
    // Task 5B: Selection Sort Recursively
    // ==========================================
    public static Node sortLL_recursive(Node head) {
        // Base case: an empty list or a single node is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Inner loop simulation: find the node with the minimum value in the current sublist
        Node minNode = findMinNode(head);

        // Swap the values between the current head and the minimum node found
        int temp = head.elem;
        head.elem = minNode.elem;
        minNode.elem = temp;

        // Outer loop simulation: recursively sort the remainder of the list
        sortLL_recursive(head.next);

        return head; // Return the updated head
    }

    // Helper for Task 5B (Simulates inner loop of Selection Sort)
    private static Node findMinNode(Node head) {
        if (head.next == null) {
            return head;
        }
        Node minOfRest = findMinNode(head.next);
        return (head.elem < minOfRest.elem) ? head : minOfRest;
    }

    // ==========================================
    // Task 5C: Find Duplicates Recursively
    // ==========================================
    public static void findDup(Node head) {
        // Start the outer loop simulation starting at index 0
        findDupOuter(head, head, 0);
    }

    // Helper for Task 5C (Simulates the outer loop)
    private static void findDupOuter(Node originalHead, Node current, int currentIndex) {
        // Base case: reached the end of the list
        if (current == null) {
            return;
        }

        // Run the inner loop simulation to find all duplicate indices
        String duplicates = buildDupString(originalHead, current.elem, currentIndex, 0);

        // Formatting output based on whether duplicates were found
        if (duplicates.isEmpty()) {
            System.out.println(current.elem + ": No Duplicate");
        } else {
            System.out.println(current.elem + ": " + duplicates);
        }

        // Recursive step: move to the next node
        findDupOuter(originalHead, current.next, currentIndex + 1);
    }

    // Helper for Task 5C (Simulates the inner loop)
    private static String buildDupString(Node searchNode, int targetValue, int targetIndex, int searchIndex) {
        // Base case: end of the search list
        if (searchNode == null) {
            return "";
        }

        // Recursively get duplicates from the rest of the list
        String restOfDups = buildDupString(searchNode.next, targetValue, targetIndex, searchIndex + 1);

        // Check if the current search node matches the target value AND is not the original node's index
        if (searchNode.elem == targetValue && searchIndex != targetIndex) {
            if (restOfDups.isEmpty()) {
                return String.valueOf(searchIndex); // First duplicate found (reading backwards)
            } else {
                return searchIndex + ", " + restOfDups; // Append current index to the list
            }
        }

        return restOfDups; // No match at this node, pass the rest up
    }

    // ==========================================
    // Main Method (Tester)
    // ==========================================
    public static void main(String[] args) {
        System.out.println("--- Task 5A: Find Max ---");
        Node listA = new Node(10, new Node(5, new Node(20, new Node(15, null))));
        System.out.println("Max of [10, 5, 20, 15] is: " + findMax_recursive(listA));

        System.out.println("\n--- Task 5C: Find Duplicates (Executing before sorting) ---");
        // Recreating the exact sample from the image: 10 -> 22 -> 13 -> 20 -> 22 -> 23 -> 10 -> 22
        Node listC = new Node(10, new Node(22, new Node(13, new Node(20, 
                     new Node(22, new Node(23, new Node(10, new Node(22, null))))))));
        findDup(listC);

        System.out.println("\n--- Task 5B: Selection Sort ---");
        Node listB = new Node(40, new Node(10, new Node(30, new Node(20, null))));
        
        System.out.print("Original List: ");
        printList(listB);
        
        sortLL_recursive(listB);
        
        System.out.print("Sorted List:   ");
        printList(listB);
    }

    // Utility helper just to print out nodes for testing
    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.elem + " ");
            current = current.next;
        }
        System.out.println();
    }
}
