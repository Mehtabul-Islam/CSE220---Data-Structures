class DNode {
    Object elem;
    DNode next;
    DNode prev;

    public DNode(Object elem) {
        this.elem = elem;
        this.next = null;
        this.prev = null;
    }
}
public class LAB3_Assignment_Task_2 {
    public static void pairJoin(DNode dh1, DNode dh2) {
        DNode temp1 = dh1.next;
        DNode temp2 = dh2.next;
        
        while(temp1 != dh1 && temp2 != dh2){
            DNode backup1 = temp1.next;
            DNode backup2 = temp2.next;
            
            temp1.next = temp2;
            temp2.prev = temp1;
            
            temp2.next = backup1;
            backup1.prev = temp2;
            
            temp1 = backup1;
            temp2 = backup2;
        }
        
        // Re-link the tail to close the circular doubly linked list
        dh1.prev = dh2.prev;
        dh2.prev.next = dh1;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        System.out.println("=== Testing Pair Join Task ===\n");

        // Sample Input Elements
        Object[] arr1 = {"A", "B", "C", "D"};
        Object[] arr2 = {"E", "F", "G", "H"};
        
        // Create the Dummy Headed Doubly Circular Linked Lists
        DNode dh1 = createDDLL(arr1);
        DNode dh2 = createDDLL(arr2);
        
        System.out.println("Given Dummy Headed Doubly Linked Lists:");
        System.out.print("List 1: "); printDDLL(dh1);
        System.out.print("List 2: "); printDDLL(dh2);
        
        // Execute the function
        pairJoin(dh1, dh2);
        
        System.out.println("\nExpected Modified Linked List: \nX <-> A <-> E <-> B <-> F <-> C <-> G <-> D <-> H <-> (back to X)");
        System.out.println("\nYour Output:");
        printDDLL(dh1);
    }

    // Helper method to create a Dummy Headed Doubly Circular Linked List
    public static DNode createDDLL(Object[] arr) {
        DNode dh = new DNode("X"); // Dummy head
        dh.next = dh;
        dh.prev = dh;
        
        DNode tail = dh;
        for (int i = 0; i < arr.length; i++) {
            DNode newNode = new DNode(arr[i]);
            
            // Wire the new node to the tail and dummy head
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = dh;
            dh.prev = newNode;
            
            // Move tail forward
            tail = newNode;
        }
        return dh;
    }

    // Helper method to print the Doubly Circular Linked List
    public static void printDDLL(DNode dh) {
        if (dh == null) return;
        
        System.out.print(dh.elem);
        DNode current = dh.next;
        
        while (current != dh) {
            System.out.print(" <-> " + current.elem);
            current = current.next;
        }
        System.out.println(" <-> (back to " + dh.elem + ")");
    }
}
