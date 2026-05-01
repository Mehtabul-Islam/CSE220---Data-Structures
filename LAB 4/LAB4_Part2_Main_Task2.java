class Node {
    Object elem;
    Node next;

    public Node(Object elem) {
        this.elem = elem;
        this.next = null;
    }
}
class LinkedListQueue {
    Node front;
    Node rear;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue(Object element) {
        Node newNode = new Node(element);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public Object deQueue() {
        if (this.isEmpty()) return null;
        Object temp = this.front.elem;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        return temp;
    }

    public Object peek() {
        if (this.isEmpty()) return null;
        return this.front.elem;
    }

    public boolean isEmpty() {
        return this.front == null;
    }
}
public class LAB4_Part2_Main_Task2 {
    public static String removeConsecutiveDups(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        LinkedListQueue queue = new LinkedListQueue();

        // Step 1: Enqueue all characters of the string into the queue
        for (int i = 0; i < s.length(); i++) {
            queue.enQueue(s.charAt(i));
        }

        String result = "";
        char lastAdded = '\0'; // Initialize with a null character

        // Step 2: Dequeue and build the result string without consecutive duplicates
        while (!queue.isEmpty()) {
            char currentChar = (char) queue.deQueue();

            // If the result is empty (first char) OR the current char is different from the last one
            if (result.isEmpty() || currentChar != lastAdded) {
                result += currentChar;
                lastAdded = currentChar; // Update the last added character tracker
            }
        }

        return result;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        System.out.println("=== Testing Remove Consecutive Duplicates (Queue) ===\n");

        // Sample 1
        String input1 = "aabbbccccdd";
        System.out.println("Sample Given String:   " + input1);
        System.out.println("Expected Output:       abcd");
        System.out.println("Your Returned String:  " + removeConsecutiveDups(input1) + "\n");

        // Sample 2
        String input2 = "aaabbaa";
        System.out.println("Sample Given String:   " + input2);
        System.out.println("Expected Output:       aba");
        System.out.println("Your Returned String:  " + removeConsecutiveDups(input2) + "\n");

        // Sample 3
        String input3 = "abcabcabc";
        System.out.println("Sample Given String:   " + input3);
        System.out.println("Expected Output:       abcabcabc");
        System.out.println("Your Returned String:  " + removeConsecutiveDups(input3) + "\n");

        // Sample 4
        String input4 = "aaaaa";
        System.out.println("Sample Given String:   " + input4);
        System.out.println("Expected Output:       a");
        System.out.println("Your Returned String:  " + removeConsecutiveDups(input4) + "\n");
    }
}
