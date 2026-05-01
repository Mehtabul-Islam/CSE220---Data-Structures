class Node {
    Object elem;
    Node next;

    public Node(Object elem) {
        this.elem = elem;
        this.next = null;
    }
}
public class LAB2_Assignment_Task_2 {
    public static Node organizeBooks(Node head, int[] popularity) {
        Node temp1 = head;
        int count = 0;
        
        // Count the number of nodes
        while(temp1 != null){
            count++;
            temp1 = temp1.next;
        }
        
        // Bubble sort logic for parallel sorting of Linked List and Array
        for(int i = 0; i < count - 1; i++){
            Node newh = head;
            int j = 0;
            while(newh.next != null && j < count - i - 1){
                // If the next book is strictly more popular, swap them 
                // (This strict '<' ensures stable sorting for equal popularities)
                if(popularity[j] < popularity[j + 1]){
                    
                    // Swap the elements in the linked list
                    String book = (String)newh.elem;
                    newh.elem = newh.next.elem;
                    newh.next.elem = book;
                    
                    // Swap the corresponding values in the popularity array
                    int num = popularity[j];
                    popularity[j] = popularity[j + 1];
                    popularity[j + 1] = num;
                }
                newh = newh.next;
                j++;
            }
        }
        return head;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        System.out.println("=== Testing Organize Books Task ===\n");

        // Example 1
        Object[] books1 = {"Dune", "IT", "Coraline", "Inferno", "Twilight"};
        int[] pop1 = {8, 10, 5, 10, 6};
        Node head1 = createList(books1);
        System.out.println("Sample 1:");
        System.out.print("Given LL: "); printList(head1);
        System.out.print("Output:   ");
        printList(organizeBooks(head1, pop1));
        System.out.println();

        // Example 2
        Object[] books2 = {"Hamlet", "Persuasion", "It", "Dracula", "Beloved"};
        int[] pop2 = {7, 9, 9, 6, 7};
        Node head2 = createList(books2);
        System.out.println("Sample 2:");
        System.out.print("Given LL: "); printList(head2);
        System.out.print("Output:   ");
        printList(organizeBooks(head2, pop2));
        System.out.println();

        // Example 3
        Object[] books3 = {"Matilda", "Franny", "Foundation", "Carrie", "Misery"};
        int[] pop3 = {5, 8, 8, 10, 6};
        Node head3 = createList(books3);
        System.out.println("Sample 3:");
        System.out.print("Given LL: "); printList(head3);
        System.out.print("Output:   ");
        printList(organizeBooks(head3, pop3));
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
