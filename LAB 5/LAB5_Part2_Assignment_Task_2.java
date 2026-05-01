class BSTNode {
    int elem;
    BSTNode left, right;

    public BSTNode(int elem) {
        this.elem = elem;
        this.left = null;
        this.right = null;
    }
}
public class LAB5_Part2_Assignment_Task_2 {
    public static Integer mirrorSum(BSTNode root) {
        // If the root is null, there are no subtrees to compare
        if (root == null) {
            return 0;
        }
        // Begin mirror comparison from the root's left and right children
        return mirrorH(root.left, root.right);
    }

    /**
     * Helper function to traverse and sum mirror nodes.
     */
    private static Integer mirrorH(BSTNode left, BSTNode right) {
        // If either corresponding node doesn't exist, do not sum
        if (left == null || right == null) {
            return 0;
        }

        // Add the current pair of mirror nodes
        int total = left.elem + right.elem;

        // Traverse outer mirror pairs (Left-Left with Right-Right)
        total += mirrorH(left.left, right.right);

        // Traverse inner mirror pairs (Left-Right with Right-Left)
        total += mirrorH(left.right, right.left);

        return total;
    }

    public static void main(String[] args) {
        // --- Sample Input 1 ---
        BSTNode root1 = new BSTNode(10);
        root1.left = new BSTNode(6);
        root1.right = new BSTNode(15);
        root1.left.left = new BSTNode(3);
        root1.left.right = new BSTNode(8);
        root1.right.left = new BSTNode(12);
        root1.right.right = new BSTNode(20);

        System.out.println("Sample Output 1: " + mirrorSum(root1)); 
        // Result: 64 (Explanation: 21 + 23 + 20)

        // --- Sample Input 2 ---
        BSTNode root2 = new BSTNode(20);
        root2.left = new BSTNode(15);
        root2.right = new BSTNode(25);
        root2.left.left = new BSTNode(10);
        root2.left.right = new BSTNode(18);
        root2.right.right = new BSTNode(30);
        root2.left.left.left = new BSTNode(5);

        System.out.println("Sample Output 2: " + mirrorSum(root2)); 
        // Result: 80 (Explanation: 40 + 40)
    }
}
