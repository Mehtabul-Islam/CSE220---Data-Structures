class TreeNode {
    Object elem;
    TreeNode left;
    TreeNode right;

    // Constructor assigns parameter value to elem
    public TreeNode(Object elem) {
        this.elem = elem;
        this.left = null;
        this.right = null;
    }
}
public class LAB5_Part1_Main_Task3 {
    public static int sumNodes(TreeNode root) {
        // Base case: if the node is null, it contributes 0 to the sum
        if (root == null) {
            return 0;
        }

        // Recursive step: Cast elem to int and add sums of subtrees
        return (int)root.elem + sumNodes(root.left) + sumNodes(root.right);
    }

    /**
     * 3.2: Re-uses 3.1 to print the final summation.
     */
    public static void printSum(TreeNode root) {
        int totalSum = sumNodes(root);
        System.out.println("Summation of nodes: " + totalSum);
    }

    public static void main(String[] args) {
        // Constructing the sample tree from image_5879e0.png
        TreeNode root = new TreeNode(10);
        
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(90);
        
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(70);
        root.right.right = new TreeNode(80);
        root.right.right.left = new TreeNode(30);
        root.right.right.right = new TreeNode(40);

        // Execute the merged tasks
        printSum(root); 
        // Expected Output: 420
    }
}
