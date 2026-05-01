class Node {
    Object elem;
    Node next;

    public Node(Object elem) {
        this.elem = elem;
        this.next = null;
    }
}
public class LAB2_Assignment_Task_3 {
    // Your main logic, preserved exactly as you wrote it.
    public static Node alternateMerge(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        
        while(temp1 != null && temp2 != null){
            // Save next pointers
            Node next1 = temp1.next;
            Node next2 = temp2.next;
            
            // Rewire to interleave temp2 immediately after temp1
            temp1.next = temp2;
            temp2.next = next1;
            
            // Advance pointers for the next iteration
            temp1 = next1;
            temp2 = next2;
        }
        
        Node head = head1;
        return head;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        System.out.println("=== Testing Alternate Merge Task ===\n");

        // Example 1
        Object[] arr1_1 = {1, 2, 6, 8, 11};
        Object[] arr1_2 = {5, 7, 3, 9, 4};
        Node head1_1 = createList(arr1_1);
        Node head1_2 = createList(arr1_2);
        System.out.println("Sample 1:");
        System.out.print("List1:  "); printList(head1_1);
        System.out.print("List2:  "); printList(head1_2);
        System.out.print("Output: "); printList(alternateMerge(head1_1, head1_2));
        System.out.println();

        // Example 2
        Object[] arr2_1 = {5, 3, 2, -4};
        Object[] arr2_2 = {-4, -6, 1};
        Node head2_1 = createList(arr2_1);
        Node head2_2 = createList(arr2_2);
        System.out.println("Sample 2:");
        System.out.print("List1:  "); printList(head2_1);
        System.out.print("List2:  "); printList(head2_2);
        System.out.print("Output: "); printList(alternateMerge(head2_1, head2_2));
        System.out.println();

        // Example 3
        Object[] arr3_1 = {4, 2, -2, -4};
        Object[] arr3_2 = {8, 6, 5, -3};
        Node head3_1 = createList(arr3_1);
        Node head3_2 = createList(arr3_2);
        System.out.println("Sample 3:");
        System.out.print("List1:  "); printList(head3_1);
        System.out.print("List2:  "); printList(head3_2);
        System.out.print("Output: "); printList(alternateMerge(head3_1, head3_2));
        System.out.println();
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

    // Helper method to print the linked list ending with "None"
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.elem + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }
}
