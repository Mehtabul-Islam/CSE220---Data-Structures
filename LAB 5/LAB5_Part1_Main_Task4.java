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
public class LAB5_Part1_Main_Task4 {
    // The recursive method to find and print leaf nodes
    public static void printLeafNodes(TreeNode root) {
        // Base Case: If the current node is null, return immediately
        if (root == null) {
            return;
        }

        // Logic: A leaf node has no left child AND no right child
        if (root.left == null && root.right == null) {
            System.out.print(root.elem + " "); //
        } else {
            // If it's not a leaf, search the left subtree, then the right
            printLeafNodes(root.left);
            printLeafNodes(root.right);
        }
    }

    public static void main(String[] args) {
        // Constructing the specific tree from image_586ee0.png
        TreeNode root = new TreeNode(10);
        
        // Left Subtree
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(90);
        
        // Right Subtree
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(70);
        root.right.right = new TreeNode(80);
        root.right.right.left = new TreeNode(30);
        root.right.right.right = new TreeNode(40);

        // Printing the output
        System.out.println("Leaf Nodes:");
        printLeafNodes(root); 
        // Expected Output: 50 90 70 30 40
    }
}
