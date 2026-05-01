
public class LAB5_Part1_Main_Task2 {
    public static int countNodes(TreeNode root) {
        // Base case: if the node is null, it doesn't contribute to the count
        if (root == null) {
            return 0;
        }

        // Recursive call: 1 (current node) + left subtree count + right subtree count
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        // Constructing the tree from the image
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(30);
        root.right = new TreeNode(20);
        
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(90);
        
        root.right.left = new TreeNode(70);
        root.right.right = new TreeNode(80);
        
        root.right.right.left = new TreeNode(30);
        root.right.right.right = new TreeNode(40);

        // Calculate total nodes
        int totalNodes = countNodes(root);
        System.out.println("Total number of nodes: " + totalNodes); 
        // Expected Output: 9
    }
}
