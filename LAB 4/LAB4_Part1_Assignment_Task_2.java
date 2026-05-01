class HashNode {
    String key;
    int value;
    HashNode next;

    public HashNode(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
class HashTable {
    HashNode[] ht;

    public HashTable(int size) {
        ht = new HashNode[size];
    }

    // --- REQUIRED METHOD 1: hashFunction ---
    // Takes a key-value pair, calculates index based on ASCII concatenation
    public int hashFunction(String key, int value) {
        String s = key;
        
        // If odd length string, add 'N' at the end
        if (s.length() % 2 != 0) {
            s += "N";
        }

        long sum = 0; // Using long to prevent integer overflow on long strings
        
        // Take consecutive two letters, concatenate their ASCII values, and sum them
        for (int i = 0; i < s.length(); i += 2) {
            int ascii1 = (int) s.charAt(i);
            int ascii2 = (int) s.charAt(i + 1);
            
            String concatAscii = String.valueOf(ascii1) + String.valueOf(ascii2);
            sum += Long.parseLong(concatAscii);
        }

        // "think for yourself with which number should we mod the summation"
        // Answer: We must modulo the sum by the length of the Hash Table array to stay within bounds.
        return (int) (sum % ht.length);
    }

    // --- REQUIRED METHOD 2: searchHashtable ---
    // Hash-based search method (O(1) average time complexity)
    public String searchHashtable(String key, int value) {
        // Find the index using the hash function (NO sequential search across the array)
        int index = hashFunction(key, value);

        HashNode curr = ht[index];
        
        // Traverse the linked list (forward chain) at that specific index
        while (curr != null) {
            if (curr.key.equals(key)) {
                return "Found";
            }
            curr = curr.next;
        }
        
        return "Not Found";
    }

    // --- GIVEN CODE: Insertion logic (Pre-written as per prompt instructions) ---
    public void insert(String key, int value) {
        int index = hashFunction(key, value);
        HashNode newNode = new HashNode(key, value);
        
        if (ht[index] == null) {
            ht[index] = newNode;
        } else {
            // Forward chaining (insert at head for simplicity)
            newNode.next = ht[index];
            ht[index] = newNode;
        }
    }
    
    // Helper method to print the hash table
    public void printTable() {
        for (int i = 0; i < ht.length; i++) {
            System.out.print("Index " + i + ": ");
            HashNode curr = ht[i];
            if (curr == null) {
                System.out.println("Empty");
            } else {
                while (curr != null) {
                    System.out.print("[" + curr.key + ", " + curr.value + "] -> ");
                    curr = curr.next;
                }
                System.out.println("None");
            }
        }
    }
}
public class LAB4_Part1_Assignment_Task_2 {
    public static void main(String[] args) {
        HashTable myTable = new HashTable(5);

        System.out.println("=== 1. Inserting Values into HashTable ===\n");
        // "Mortis" -> Even length. 
        // "Morti"  -> Odd length. Will be padded to "MortiN".
        myTable.insert("Mortis", 100);
        myTable.insert("Morti", 200);
        myTable.insert("Apple", 300);
        myTable.insert("Banana", 400);
        
        myTable.printTable();

        System.out.println("\n=== 2. Testing Hash-Based Search ===\n");
        
        // Searching for keys that EXIST
        System.out.println("Search 'Mortis': " + myTable.searchHashtable("Mortis", 100)); // Expected: Found
        System.out.println("Search 'Morti': " + myTable.searchHashtable("Morti", 200));   // Expected: Found
        System.out.println("Search 'Apple': " + myTable.searchHashtable("Apple", 300));   // Expected: Found
        
        System.out.println();
        
        // Searching for keys that DO NOT EXIST
        System.out.println("Search 'Mango': " + myTable.searchHashtable("Mango", 500));   // Expected: Not Found
        System.out.println("Search 'Zebra': " + myTable.searchHashtable("Zebra", 999));   // Expected: Not Found
    }
}
