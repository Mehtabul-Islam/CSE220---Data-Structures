class Node {
    Object elem;
    Node next;

    public Node(Object elem) {
        this.elem = elem;
        this.next = null;
    }
}
public class LAB2_Main_Task_1 {
    public static boolean assembleCongaLine(Node head) {
        // An empty line or a line with 1 person is technically perfectly sorted
        if (head == null || head.next == null) {
            return true;
        }

        Node current = head;

        // Traverse the linked list until the second-to-last node
        while (current.next != null) {
            // Cast Object to Integer to compare ages
            int currentAge = (Integer) current.elem;
            int nextAge = (Integer) current.next.elem;

            // If the current person is strictly older than the person behind them, it's not ascending
            if (currentAge > nextAge) {
                return false;
            }

            // Move to the next person in line
            current = current.next;
        }

        // If we make it through the whole line without returning false, it is sorted
        return true;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        System.out.println("=== Testing Conga Line Task ===");

        // Sample Input 1: 10 -> 15 -> 34 -> 41 -> 56 -> 72
        Object[] arr1 = {10, 15, 34, 41, 56, 72};
        Node head1 = createList(arr1);
        System.out.print("Sample Input 1: ");
        printList(head1);
        System.out.println("Expected Output: true");
        System.out.println("Your Output:     " + assembleCongaLine(head1));
        
        System.out.println("\n-----------------------------------\n");

        // Sample Input 2: 10 -> 15 -> 44 -> 41 -> 56 -> 72
        Object[] arr2 = {10, 15, 44, 41, 56, 72};
        Node head2 = createList(arr2);
        System.out.print("Sample Input 2: ");
        printList(head2);
        System.out.println("Expected Output: false");
        System.out.println("Your Output:     " + assembleCongaLine(head2));
    }

    // Helper method to easily create a linked list from an array
    public static Node createList(Object[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        return head;
    }

    // Helper method to print the linked list in the format requested
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.elem);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
