class BTNode {
    Object elem;
    BTNode left;
    BTNode right;

    public BTNode(Object elem) {
        this.elem = elem;
        this.left = null;
        this.right = null;
    }
}
public class LAB5_Part1_Assignment_Task_1 {
    public static Integer subtractSummation(BTNode root) {
        // Base case for the root of the entire tree
        if (root == null) {
            return 0;
        }

        // Calculate the sum of the left subtree nodes
        int lSum = sumOfsub(root.left);
        // Calculate the sum of the right subtree nodes
        int rSum = sumOfsub(root.right);

        // Return the difference: Left Sum - Right Sum
        return lSum - rSum;
    }

    /**
     * Helper function to calculate the total summation of a subtree.
     */
    private static int sumOfsub(BTNode root) {
        if (root == null) {
            return 0;
        }
        // Current node element + sum of its left side + sum of its right side
        return (Integer) root.elem + sumOfsub(root.left) + sumOfsub(root.right);
    }

    public static void main(String[] args) {
        // Constructing the tree from the Sample Input in image_58440c.png
        BTNode root = new BTNode(71);

        // Left Subtree
        root.left = new BTNode(27);
        root.left.left = new BTNode(80);
        root.left.right = new BTNode(75);
        root.left.left.left = new BTNode(87);
        root.left.left.right = new BTNode(56);

        // Right Subtree
        root.right = new BTNode(62);
        root.right.left = new BTNode(41);
        root.right.right = new BTNode(3);
        root.right.right.left = new BTNode(19);
        root.right.right.right = new BTNode(89);

        // Execute the function
        int result = subtractSummation(root);

        // Explanation matches: (27+75+80+87+56) - (62+41+3+19+89) = 325 - 214 = 111
        System.out.println("Sample Output: " + result); 
    }
}
