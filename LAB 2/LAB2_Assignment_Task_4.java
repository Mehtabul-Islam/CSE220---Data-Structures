class Node {
    Object elem;
    Node next;

    public Node(Object elem) {
        this.elem = elem;
        this.next = null;
    }
}
public class LAB2_Assignment_Task_4 {
    public static Node idGenerator(Node head1, Node head2, Node head3) {
        
        Node temp = head1;
        Node head = null;
        
        // Reverse the first list
        while(temp != null){
            Node a1 = new Node(temp.elem);
            a1.next = head;
            head = a1;
            temp = temp.next;
        }
        
        Node temp2 = head2;
        Node temp3 = head3;
        Node n1 = null;
        Node o1 = null;
        
        // Add the second and third lists element-wise
        while(temp2 != null && temp3 != null){
            int sum = 0;
            sum = (int)temp2.elem + (int)temp3.elem;
            if(sum >= 10){
                sum = sum % 10;
            }
            Node newNode = new Node(sum);
            
            if(n1 == null){
                n1 = newNode;
                o1 = newNode;
            }
            else{
                o1.next = newNode;
                o1 = newNode;
            }
            temp2 = temp2.next;
            temp3 = temp3.next;
        }
        
        // Connect the reversed first list to the summed list
        Node fin = head;
        while(fin.next != null){
            fin = fin.next;
        }
        fin.next = n1;
        
        return head; 
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        System.out.println("=== Testing ID Generator Task ===\n");

        // Sample Input 1
        Object[] arr1_1 = {0, 3, 2, 2};
        Object[] arr1_2 = {5, 2, 2, 1};
        Object[] arr1_3 = {4, 3, 2, 1};
        Node head1_1 = createList(arr1_1);
        Node head1_2 = createList(arr1_2);
        Node head1_3 = createList(arr1_3);
        
        System.out.println("Sample 1:");
        System.out.print("List 1: "); printList(head1_1);
        System.out.print("List 2: "); printList(head1_2);
        System.out.print("List 3: "); printList(head1_3);
        System.out.print("Output: "); printList(idGenerator(head1_1, head1_2, head1_3));
        System.out.println("Expected: 2 -> 2 -> 3 -> 0 -> 9 -> 5 -> 4 -> 2\n");

        // Sample Input 2
        Object[] arr2_1 = {0, 3, 9, 1};
        Object[] arr2_2 = {3, 6, 5, 7};
        Object[] arr2_3 = {2, 4, 3, 8};
        Node head2_1 = createList(arr2_1);
        Node head2_2 = createList(arr2_2);
        Node head2_3 = createList(arr2_3);
        
        System.out.println("Sample 2:");
        System.out.print("List 1: "); printList(head2_1);
        System.out.print("List 2: "); printList(head2_2);
        System.out.print("List 3: "); printList(head2_3);
        System.out.print("Output: "); printList(idGenerator(head2_1, head2_2, head2_3));
        System.out.println("Expected: 1 -> 9 -> 3 -> 0 -> 5 -> 0 -> 8 -> 5\n");
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

    // Helper method to print the linked list
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
