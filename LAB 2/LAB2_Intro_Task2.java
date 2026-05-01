class Node {
    Object elem;
    Node next;

    public Node(Object elem) {
        this.elem = elem;
        this.next = null;
    }
}
class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // 1. Complete the append() method
    public void append(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode; // If empty, new node becomes head
            return;
        }
        Node current = head;
        // Traverse to the end of the list
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode; // Insert at the back
    }

    // 2. Complete the printList() method
    public void printList() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
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

    // 3. Complete the prepend() method
    public void prepend(Object value) {
        Node newNode = new Node(value);
        newNode.next = head; // Point new node's next to current head
        head = newNode;      // Update head reference
    }

    // 4. Complete the nodeAt() method
    public Node nodeAt(int index) {
        if (index < 0 || head == null) {
            return null; // Invalid index or empty list
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current;
            }
            count++;
            current = current.next;
        }
        return null; // Index out of bounds
    }

    // 5. Complete the removeFirst() method
    public void removeFirst() {
        if (head != null) {
            head = head.next; // Move head to the next node
        }
    }

    // 6. Complete the removeLast() method
    public void removeLast() {
        if (head == null) {
            return; // Empty list, do nothing
        }
        if (head.next == null) {
            head = null; // Only one node, head becomes null
            return;
        }
        
        Node current = head;
        // Traverse to the second-to-last node
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null; // Sever the link to the last node
    }
}
public class LAB2_Intro_Task2 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("=== 1. Testing append() & 2. printList() ===");
        list.append(10);
        list.append(20);
        list.append(30);
        System.out.print("List after appending 10, 20, 30: ");
        list.printList(); 

        System.out.println("\n=== 3. Testing prepend() ===");
        list.prepend(5);
        System.out.print("List after prepending 5: ");
        list.printList(); 

        System.out.println("\n=== 4. Testing nodeAt() ===");
        Node targetNode = list.nodeAt(2);
        if (targetNode != null) {
            System.out.println("Node at index 2 (Expected 20): " + targetNode.elem);
        } else {
            System.out.println("Node at index 2: Invalid index");
        }
        
        Node invalidNode = list.nodeAt(10);
        System.out.println("Node at index 10 (Expected null): " + (invalidNode == null ? "null" : invalidNode.elem));

        System.out.println("\n=== 5. Testing removeFirst() ===");
        list.removeFirst();
        System.out.print("List after removeFirst() (Expected 10 -> 20 -> 30): ");
        list.printList(); 

        System.out.println("\n=== 6. Testing removeLast() ===");
        list.removeLast();
        System.out.print("List after removeLast() (Expected 10 -> 20): ");
        list.printList(); 

        System.out.println("\n=== Edge Cases: Removing remaining nodes ===");
        list.removeLast(); // Removes 20
        list.removeFirst(); // Removes 10
        System.out.print("List after removing all elements: ");
        list.printList();
        
        // Testing empty list robustness
        list.removeFirst(); // Should not crash
        list.removeLast();  // Should not crash
        System.out.println("Attempted removing from empty list successfully (no crashes).");
    }
}
