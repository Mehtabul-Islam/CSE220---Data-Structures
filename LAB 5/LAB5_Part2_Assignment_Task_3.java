class BSTNode {
    int elem;
    BSTNode left, right;

    public BSTNode(int elem) {
        this.elem = elem;
        this.left = null;
        this.right = null;
    }
}
public class LAB5_Part2_Assignment_Task_3 {
    public static Boolean isBST(BSTNode root) {
        // Start recursion with no initial bounds
        return isBSTH(root, null, null);
    }

    /**
     * Helper function that carries min and max constraints down the tree.
     */
    private static Boolean isBSTH(BSTNode root, Integer min, Integer max) {
        // Base case: an empty tree is a valid BST
        if (root == null) {
            return true;
        }

        // Check if current node violates the min/max constraints
        if ((min != null && root.elem <= min) || (max != null && root.elem >= max)) {
            return false;
        }

        // Recurse left: update max bound to current node's value
        boolean s1 = isBSTH(root.left, min, root.elem);
        // Recurse right: update min bound to current node's value
        boolean s2 = isBSTH(root.right, root.elem, max);

        // Both subtrees must be valid BSTs
        return s1 && s2;
    }

    public static void main(String[] args) {
        // --- Sample Input 1 (Invalid BST) ---
        BSTNode root1 = new BSTNode(4);
        root1.left = new BSTNode(9);
        root1.right = new BSTNode(2);
        root1.left.left = new BSTNode(3);
        root1.left.right = new BSTNode(-5);
        root1.right.right = new BSTNode(7);

        System.out.println("Sample 1 is BST: " + isBST(root1)); // Output: false

        // --- Sample Input 2 (Valid BST) ---
        BSTNode root2 = new BSTNode(4);
        root2.left = new BSTNode(2);
        root2.right = new BSTNode(7);
        root2.left.left = new BSTNode(-5);
        root2.left.right = new BSTNode(3);
        root2.right.right = new BSTNode(9);

        System.out.println("Sample 2 is BST: " + isBST(root2)); // Output: true
    }
}
