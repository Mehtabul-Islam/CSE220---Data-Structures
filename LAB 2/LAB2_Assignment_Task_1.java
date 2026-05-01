class Node {
    Object elem;
    Node next;

    public Node(Object elem) {
        this.elem = elem;
        this.next = null;
    }
}
public class LAB2_Assignment_Task_1 {
    public static String checkSimilar( Node building1, Node building2 ){
        Node temp1 = building1;
        Node temp2 = building2;
        int count1 = 0;
        int count2 = 0;
        
        while(temp1 != null){
            count1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            count2++;
            temp2 = temp2.next;
        }
        
        boolean test = true;
        
        if(count1 != count2){
            return "Not Similar";
        }
        else{
            temp1 = building1;
            temp2 = building2;
            while(temp1 != null && temp2 != null){
                if(!((String)temp1.elem).equals((String)temp2.elem)){
                    test = false;
                    break;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            
            if(test == false){
                return "Not Similar";
            }
            else{
                return "Similar";
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Building Blocks Task ===");

        // Sample Input 1
        Object[] arr1_A = {"Red", "Green", "Yellow", "Red", "Blue", "Green"};
        Object[] arr1_B = {"Red", "Green", "Yellow", "Red", "Blue", "Green"};
        Node b1_A = createList(arr1_A);
        Node b1_B = createList(arr1_B);
        System.out.println("\nSample 1:");
        System.out.print("building_1 = "); printList(b1_A);
        System.out.print("building_2 = "); printList(b1_B);
        System.out.println("Expected Output: Similar");
        System.out.println("Your Output:     " + checkSimilar(b1_A, b1_B));

        // Sample Input 2
        Object[] arr2_A = {"Red", "Green", "Yellow", "Red", "Yellow", "Green"};
        Object[] arr2_B = {"Red", "Green", "Yellow", "Red", "Blue", "Green"};
        Node b2_A = createList(arr2_A);
        Node b2_B = createList(arr2_B);
        System.out.println("\nSample 2:");
        System.out.print("building_1 = "); printList(b2_A);
        System.out.print("building_2 = "); printList(b2_B);
        System.out.println("Expected Output: Not Similar");
        System.out.println("Your Output:     " + checkSimilar(b2_A, b2_B));
        
        // Sample Input 3
        Object[] arr3_A = {"Red", "Green", "Yellow", "Red", "Blue", "Green"};
        Object[] arr3_B = {"Red", "Green", "Yellow", "Red", "Blue", "Green", "Blue"};
        Node b3_A = createList(arr3_A);
        Node b3_B = createList(arr3_B);
        System.out.println("\nSample 3:");
        System.out.print("building_1 = "); printList(b3_A);
        System.out.print("building_2 = "); printList(b3_B);
        System.out.println("Expected Output: Not Similar");
        System.out.println("Your Output:     " + checkSimilar(b3_A, b3_B));
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
