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
public class LAB3_Assignment_Task_3 {
    public static void rangeMove(DNode dh, int start, int end) {
        
        // 1. Count original nodes to prevent re-evaluating nodes moved to the back
        int count = 0;
        DNode curr = dh.next;
        while (curr != dh) {
            count++;
            curr = curr.next;
        }
        
        DNode temp = dh.next;
        
        // 2. Iterate exactly 'count' times
        for (int i = 0; i < count; i++) {
            
            // SAVE the next node before breaking any links!
            DNode nextNode = temp.next; 
            
            int a = (int)temp.elem;
            
            if (a >= start && a <= end) {
                // Detach temp from its current position
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                
                // Attach temp to the tail (before dh)
                DNode tail = dh.prev;
                tail.next = temp;
                temp.prev = tail;
                temp.next = dh;
                dh.prev = temp;
            }
            
            // Safely move to the next original node
            temp = nextNode; 
        }
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        System.out.println("=== Testing Range Move Task ===\n");

        // Sample Input Elements
        Object[] arr = {5, 3, 7, 1, 9, 6, 2, 4};
        
        // Create the Dummy Headed Doubly Circular Linked List
        DNode dh = createDDLL(arr);
        
        System.out.println("Given Dummy Headed Doubly Linked List:");
        printDDLL(dh);
        
        System.out.println("\nExecuting rangeMove(dh, 5, 7)...");
        rangeMove(dh, 5, 7);
        
        System.out.println("\nExpected Modified Linked List: \nX <-> 3 <-> 1 <-> 9 <-> 2 <-> 4 <-> 5 <-> 7 <-> 6 <-> (back to X)");
        System.out.println("\nYour Output:");
        printDDLL(dh);
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
