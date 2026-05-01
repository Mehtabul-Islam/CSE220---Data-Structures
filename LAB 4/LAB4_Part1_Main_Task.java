class HashNode {
    Object[] data; // Stores the tuple as an array: [String key, Integer value]
    HashNode next;

    public HashNode(String key, int value) {
        this.data = new Object[]{key, value};
        this.next = null;
    }
}
class HashTable {
    HashNode[] table;

    public HashTable(int size) {
        table = new HashNode[size];
    }

    // Hash Function based on the specific rules in the prompt
    public int hash_function(String key) {
        if (key == null || key.length() == 0) return 0;
        
        int len = key.length();
        int sum = 0;

        if (len % 2 == 0) {
            // If length is even, sum ASCII values of even indexed characters
            for (int i = 0; i < len; i += 2) {
                sum += (int) key.charAt(i);
            }
        } else {
            // If length is odd, sum ASCII values of odd indexed characters
            for (int i = 1; i < len; i += 2) {
                sum += (int) key.charAt(i);
            }
        }
        
        return sum % table.length;
    }

    // Insert function with Forward Chaining and Descending Order
    public void insert(String key, int value) {
        int index = hash_function(key);
        
        HashNode prev = null;
        HashNode curr = table[index];
        HashNode targetNode = null;

        // Step 1: Check if the key already exists
        while (curr != null) {
            if (((String) curr.data[0]).equals(key)) {
                targetNode = curr;
                
                // Detach the node from its current position so we can reposition it 
                // if the updated value changes its sorting order.
                if (prev == null) {
                    table[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                
                // Update the value without creating a new node
                targetNode.data[1] = value; 
                targetNode.next = null;
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        // Step 2: If it didn't exist, create a new node
        if (targetNode == null) {
            targetNode = new HashNode(key, value);
        }

        // Step 3: Insert the targetNode into the correct position (Descending Order of price)
        curr = table[index];
        prev = null;

        while (curr != null && (int) curr.data[1] >= (int) targetNode.data[1]) {
            prev = curr;
            curr = curr.next;
        }

        if (prev == null) {
            // Insert at the head of the chain
            targetNode.next = table[index];
            table[index] = targetNode;
        } else {
            // Insert in the middle or end of the chain
            targetNode.next = curr;
            prev.next = targetNode;
        }
    }

    // Helper method to visualize the hash table
    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("Index " + i + ": ");
            HashNode curr = table[i];
            if (curr == null) {
                System.out.println("Empty");
            } else {
                while (curr != null) {
                    System.out.print("[" + curr.data[0] + ": " + curr.data[1] + "] -> ");
                    curr = curr.next;
                }
                System.out.println("None");
            }
        }
    }
}
public class LAB4_Part1_Main_Task {
    public static void main(String[] args) {
        HashTable ht = new HashTable(5);

        System.out.println("=== Testing Hash Function Calculations ===");
        // apple (odd length 5): p(112) + l(108) = 220. 220 % 5 = 0
        System.out.println("Hash of 'apple': " + ht.hash_function("apple")); 
        
        // mango (odd length 5): a(97) + g(103) = 200. 200 % 5 = 0 (Guaranteed Collision with apple)
        System.out.println("Hash of 'mango': " + ht.hash_function("mango")); 
        
        // papaya (even length 6): p(112) + p(112) + y(121) = 345. 345 % 5 = 0 (Guaranteed Collision with apple)
        System.out.println("Hash of 'papaya': " + ht.hash_function("papaya"));

        System.out.println("\n=== Testing Insert and Collision (Descending Order) ===");
        ht.insert("apple", 100);
        ht.insert("papaya", 50);  // Should go AFTER apple (50 < 100)
        ht.insert("mango", 300);  // Should go BEFORE apple (300 > 100)
        ht.printTable();
        // Expected Index 0: [mango: 300] -> [apple: 100] -> [papaya: 50] -> None

        System.out.println("\n=== Testing Value Update (Key already exists) ===");
        System.out.println("Updating 'apple' price to 400...");
        ht.insert("apple", 400); // Should move 'apple' to the front of the chain without making a new node
        ht.printTable();
        // Expected Index 0: [apple: 400] -> [mango: 300] -> [papaya: 50] -> None
        
        System.out.println("\n=== Testing Other Indexes ===");
        ht.insert("banana", 150);
        ht.insert("cherry", 200);
        ht.printTable();
    }
}
