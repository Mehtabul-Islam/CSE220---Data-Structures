import java.util.ArrayList;

// BTNode class as established in previous tasks
class BTNode {
    int elem;
    BTNode left, right;

    public BTNode(int elem) {
        this.elem = elem;
        this.left = null;
        this.right = null;
    }
}
public class LAB5_Part2_Main_Task3 {
    public static void findPath(BTNode root, int key) {
        ArrayList<Integer> path = new ArrayList<>();
        BTNode current = root;
        boolean found = false;

        // Traverse the tree using BST logic
        while (current != null) {
            path.add(current.elem); // Add current node to the path

            if (current.elem == key) {
                found = true; // Destination reached
                break;
            } else if (key < current.elem) {
                current = current.left; // Search in the left subtree
            } else {
                current = current.right; // Search in the right subtree
            }
        }

        // Final Output based on whether the key was found
        if (found) {
            System.out.println("Path: " + path); //
        } else {
            System.out.println("No Path Found"); //
        }
    }

    public static void main(String[] args) {
        // Constructing the BST from image_56fafb.png
        BTNode root = new BTNode(30);
        root.left = new BTNode(10);
        root.right = new BTNode(40);
        
        root.left.left = new BTNode(3);
        root.left.right = new BTNode(15);
        
        root.right.left = new BTNode(35);
        root.right.right = new BTNode(55);

        // Test Case 1: Destination 15
        System.out.print("Source: 30, Destination: 15 -> ");
        findPath(root, 15); // Expected Output: Path: [30, 10, 15]

        // Test Case 2: Destination 50
        System.out.print("Source: 30, Destination: 50 -> ");
        findPath(root, 50); // Expected Output: No Path Found
    }
}
