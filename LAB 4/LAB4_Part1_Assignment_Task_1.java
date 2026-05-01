class PairNode {
    Integer key;
    String value;
    PairNode next;

    public PairNode(Integer k, String v) {
        this.key = k;
        this.value = v;
        this.next = null;
    }
}
public class LAB4_Part1_Assignment_Task_1 {
    // Helper method for the hash function
    private static int hashFunction(Integer key) {
        return (key + 3) % 6;
    }

    // Your main logic, adapted to take the hashTable array as a parameter
    public static void remove(PairNode[] hashTable, Integer key) {
        int index = hashFunction(key);

        // If the bucket is empty, the key doesn't exist
        if (hashTable[index] == null) {
            return;
        }
        
        // If the node to be removed is the head of the linked list
        if (hashTable[index].key.equals(key)) {
            hashTable[index] = hashTable[index].next;
            return;
        }
        
        // Traverse the list to find the node and remove it
        PairNode curr = hashTable[index];
        while (curr.next != null) {
            if (curr.next.key.equals(key)) {
                curr.next = curr.next.next; // Bypass the node to delete it
                return;
            }
            curr = curr.next;
        }
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        // Initialize a hash table of length 6
        PairNode[] hashTable = new PairNode[6];

        System.out.println("=== Testing Hashtable Deletion Operation ===\n");

        // Insert given Key-value pairs: (34, "Abid") , (4, "Rafi"), (6, "Karim"), (3, "Chitra"), (22, "Nilu")
        // We use prepending (insert at head) to match the exact order shown in the sample
        insert(hashTable, 34, "Abid");
        insert(hashTable, 4, "Rafi");
        insert(hashTable, 6, "Karim");
        insert(hashTable, 3, "Chitra");
        insert(hashTable, 22, "Nilu");

        System.out.println("Original HashTable:");
        printHashTable(hashTable);

        System.out.println("\nExecuting: remove(hashTable, key=4) -> removing (4, \"Rafi\")");
        remove(hashTable, 4);
        System.out.println("New HashTable Output:");
        printHashTable(hashTable);

        System.out.println("\nExecuting: remove(hashTable, key=9) -> 9 doesn't exist");
        remove(hashTable, 9);
        System.out.println("New HashTable Output (Should be unchanged):");
        printHashTable(hashTable);
    }

    // Helper method to insert into the hash table (prepends to simulate the sample output state)
    public static void insert(PairNode[] hashTable, Integer key, String value) {
        int index = hashFunction(key);
        PairNode newNode = new PairNode(key, value);
        
        if (hashTable[index] == null) {
            hashTable[index] = newNode;
        } else {
            // Insert at the head to match the output order (e.g., 22 -> 4 -> 34)
            newNode.next = hashTable[index];
            hashTable[index] = newNode;
        }
    }

    // Helper method to print the hash table beautifully
    public static void printHashTable(PairNode[] hashTable) {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.print(i + ": ");
            PairNode curr = hashTable[i];
            if (curr == null) {
                System.out.println("None");
            } else {
                while (curr != null) {
                    System.out.print("(" + curr.key + ", \"" + curr.value + "\")");
                    if (curr.next != null) {
                        System.out.print(" -> ");
                    }
                    curr = curr.next;
                }
                System.out.println();
            }
        }
    }
}
