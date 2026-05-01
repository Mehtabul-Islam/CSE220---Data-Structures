class Node {
    Object elem;
    Node next;

    public Node(Object elem) {
        this.elem = elem;
        this.next = null;
    }
}
public class LAB2_Main_Task_2 {
    // Complete this method to decode the word
    public static Node wordDecoder(Node head) {
        // Return an empty dummy list if the input is null
        if (head == null) {
            return new Node("None");
        }

        // 1. Calculate the length of the linked list
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // 2. Determine the step size based on the formula
        int step = 13 % length;

        // Initialize the dummy headed list that we will return
        Node dummyHead = new Node("None");

        // Safety check to avoid division/modulo by zero later if step is 0
        if (step == 0) {
            return dummyHead;
        }

        // 3. Traverse and extract characters at multiple positions
        current = head;
        int index = 0;
        while (current != null) {
            // Check if index is a multiple of step (excluding the 0th index)
            if (index != 0 && index % step == 0) {
                
                Node newNode = new Node(current.elem);
                
                // Insert right after the dummy head to reverse the order automatically
                // e.g., Dummy -> T becomes Dummy -> A -> T
                newNode.next = dummyHead.next;
                dummyHead.next = newNode;
            }
            index++;
            current = current.next;
        }

        return dummyHead;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        System.out.println("=== Testing Word Decoder Task ===");

        // Sample Input 1: B -> M -> D -> T -> N -> O -> A -> P -> S -> C
        Object[] arr1 = {"B", "M", "D", "T", "N", "O", "A", "P", "S", "C"};
        Node head1 = createList(arr1);
        System.out.print("Sample Input 1: ");
        printList(head1);
        
        Node result1 = wordDecoder(head1);
        System.out.print("Expected Output: None -> C -> A -> T\n");
        System.out.print("Your Output:     ");
        printList(result1);

        System.out.println("\n-----------------------------------\n");

        // Sample Input 2: Z -> O -> T -> N -> X
        Object[] arr2 = {"Z", "O", "T", "N", "X"};
        Node head2 = createList(arr2);
        System.out.print("Sample Input 2: ");
        printList(head2);
        
        Node result2 = wordDecoder(head2);
        System.out.print("Expected Output: None -> N\n");
        System.out.print("Your Output:     ");
        printList(result2);
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
