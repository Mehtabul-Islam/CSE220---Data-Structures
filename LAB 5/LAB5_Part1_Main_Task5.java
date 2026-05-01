class TreeNode {
    Object elem;
    TreeNode left;
    TreeNode right;

    public TreeNode(Object elem) {
        this.elem = elem;
        this.left = null;
        this.right = null;
    }
}
public class LAB5_Part1_Main_Task5 {
    public static int findMax(TreeNode root) {
        // Base case: if node is null, return the smallest possible integer
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        // Cast current element to int
        int currentVal = (int) root.elem;
        
        // Recursive calls to find max in subtrees
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        // Compare current value with max of left and right
        int max = currentVal;
        if (leftMax > max) {
            max = leftMax;
        }
        if (rightMax > max) {
            max = rightMax;
        }

        return max;
    }

    public static void main(String[] args) {
        // Constructing the sample tree from the task image
        TreeNode root = new TreeNode(10);
        
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(90);
        
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(70);
        root.right.right = new TreeNode(80);
        root.right.right.left = new TreeNode(30);
        root.right.right.right = new TreeNode(40);

        // Calculate and print the result
        int maxValue = findMax(root);
        System.out.println("Maximum value in tree: " + maxValue); 
        // Expected Output: 90
    }
}
