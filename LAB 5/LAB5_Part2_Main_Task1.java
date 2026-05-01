class BTNode {
    int elem;
    BTNode left, right;

    public BTNode(int elem) {
        this.elem = elem;
        this.left = null;
        this.right = null;
    }
}
public class LAB5_Part2_Main_Task1 {
    /**
     * Task 1a: Find the maximum number from a BST.
     * In a BST, the maximum value is always the rightmost node.
     */
    public static int getMaximum(BTNode root) {
        if (root == null) return -1; // Or throw exception

        BTNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.elem;
    }

    /**
     * Task 1b: Find the InOrder Predecessor.
     * The predecessor is the largest value smaller than the target.
     */
    public static Integer inOrderPred(BTNode root, int target) {
        BTNode predecessor = null;
        BTNode current = root;

        while (current != null) {
            if (target > current.elem) {
                // If target is greater, this node is a potential predecessor
                predecessor = current;
                current = current.right;
            } else if (target < current.elem) {
                // If target is smaller, predecessor must be in the left subtree
                current = current.left;
            } else {
                // We found the node! 
                // If it has a left child, the predecessor is the max of that left subtree
                if (current.left != null) {
                    BTNode temp = current.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    return temp.elem;
                }
                break; // If no left child, the last 'right turn' (stored in predecessor) is the answer
            }
        }

        return (predecessor != null) ? predecessor.elem : null;
    }

    public static void main(String[] args) {
        // Constructing the BST from the image
        BTNode root = new BTNode(54);
        root.left = new BTNode(16);
        root.right = new BTNode(66);
        
        root.left.left = new BTNode(-4);
        root.left.right = new BTNode(35);
        root.left.left.left = new BTNode(-6);
        root.left.right.left = new BTNode(20);
        root.left.right.right = new BTNode(50);
        
        root.right.left = new BTNode(58);
        root.right.right = new BTNode(71);

        // Testing 1a
        System.out.println("Maximum: " + getMaximum(root)); // Output: 71

        // Testing 1b
        System.out.println("Predecessor of 54: " + inOrderPred(root, 54)); // Output: 50
        System.out.println("Predecessor of 66: " + inOrderPred(root, 66)); // Output: 58
        System.out.println("Predecessor of 20: " + inOrderPred(root, 20)); // Output: 16
        System.out.println("Predecessor of 50: " + inOrderPred(root, 50)); // Output: 35
        System.out.println("Predecessor of -6: " + inOrderPred(root, -6)); // Output: null
    }
}
