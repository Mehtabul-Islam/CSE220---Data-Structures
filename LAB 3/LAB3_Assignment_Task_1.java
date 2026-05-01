class Node {
    Object elem;
    Node next;

    public Node(Object elem) {
        this.elem = elem;
        this.next = null;
    }
}
public class LAB3_Assignment_Task_1 {
    // Your main logic, preserved exactly as you wrote it.
    public static void sumOddAppend(Node dh) {
        Node temp = dh;
        int sum = 0; 
        
        // Traverse until we loop back to the dummy head
        while(temp.next != dh){
            // Check if the next element is odd
            if((int)temp.next.elem % 2 != 0){
                sum += (int)temp.next.elem;
                // Remove the odd node by bypassing it
                temp.next = temp.next.next;
            }
            else{
                // Move forward only if we didn't delete the next node
                temp = temp.next;
            }
        }
        
        // Create the single allowed extra new node with the summation
        Node newN = new Node(sum);
        
        // Append it at the end (temp is currently the last node before dh)
        temp.next = newN;
        newN.next = dh;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        System.out.println("=== Testing Sum Odd Append Task ===\n");

        // Sample Input
        Object[] arr = {11, 22, 33, 44, 55, 66};
        
        // Create the Dummy-Headed Singly Circular Linked List
        Node dh = createDummyCircularList(arr);
        
        System.out.println("Given Dummy Headed Singly Circular Linked List:");
        printCircularList(dh);
        
        // Execute the function
        sumOddAppend(dh);
        
        System.out.println("\nExpected Modified Linked List: \nX -> 22 -> 44 -> 66 -> 99 -> (back to X)");
        System.out.println("\nYour Output:");
        printCircularList(dh);
    }

    // Helper method to create a Dummy-Headed Singly Circular Linked List
    public static Node createDummyCircularList(Object[] arr) {
        Node dh = new Node("X"); // Dummy head
        Node tail = dh;
        
        for (int i = 0; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        
        // Make it circular by pointing the last node back to the dummy head
        tail.next = dh;
        return dh;
    }

    // Helper method to print the Circular Linked List
    public static void printCircularList(Node dh) {
        if (dh == null) return;
        
        System.out.print(dh.elem);
        Node current = dh.next;
        
        while (current != dh) {
            System.out.print(" -> " + current.elem);
            current = current.next;
        }
        System.out.println(" -> (back to " + dh.elem + ")");
    }
}
