class Node {
    String elem;
    Node next;

    public Node(String elem) {
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

    public void enqueue(String element) {
        Node newNode = new Node(element);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public String dequeue() {
        if (this.isEmpty()) return null;
        String temp = this.front.elem;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        return temp;
    }

    public String peek() {
        if (this.isEmpty()) return null;
        return this.front.elem;
    }

    public boolean isEmpty() {
        return this.front == null;
    }
    
    // Helper to get current size to check if game is over
    public int size() {
        int count = 0;
        Node curr = front;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
public class LAB4_Part2_Assignment_Task_2 {
    public static String hotPotato(String[] players, int k) {
        LinkedListQueue queue = new LinkedListQueue();

        // Step 1: Add all players to the queue
        for (String player : players) {
            queue.enqueue(player);
        }

        // Step 2: Play the game until only 1 player is left
        while (queue.size() > 1) {
            // Rotate the queue k-1 times
            // This simulates passing the potato to the next person
            for (int i = 0; i < k - 1; i++) {
                String passingPlayer = queue.dequeue();
                queue.enqueue(passingPlayer);
            }

            // The person at the front now is the kth person (holding the potato)
            String eliminatedPlayer = queue.dequeue();
            System.out.println(eliminatedPlayer + " eliminated");
        }

        // The final player remaining is the winner
        String winner = queue.dequeue();
        System.out.println("Winner: " + winner);
        return winner;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Sample Input 1 ===");
        String[] players1 = {"Ali", "Ben", "Cia", "Dan", "Eli", "Faye"};
        int k1 = 3;
        hotPotato(players1, k1);

        System.out.println("\n=== Sample Input 2 ===");
        String[] players2 = {"Ali", "Rafi", "Sara", "Nina"};
        int k2 = 2;
        hotPotato(players2, k2);
    }
}
