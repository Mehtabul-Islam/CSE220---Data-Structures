
public class LAB5_Part1_Main_Task1 {
    public static void printPreOrder(TreeNode root) {
        if (root == null) return;

        // Print the root
        System.out.print(root.elem + " ");
        // Recur on left child
        printPreOrder(root.left);
        // Recur on right child
        printPreOrder(root.right);
    }

    // 1.2. Post-order Traversal with Levels (Left -> Right -> Root)
    public static void printPostOrderWithLevels(TreeNode root, int level) {
        if (root == null) return;

        // Recur on left child
        printPostOrderWithLevels(root.left, level + 1);
        // Recur on right child
        printPostOrderWithLevels(root.right, level + 1);
        // Print the root and its level
        System.out.println(root.elem + ":" + level);
    }

    // 1.3. In-order Traversal with Even Levels (Left -> Root -> Right)
    public static void printInOrderEvenLevels(TreeNode root, int level) {
        if (root == null) return;

        // Recur on left child
        printInOrderEvenLevels(root.left, level + 1);
        
        // Print the root only if the level is even
        if (level % 2 == 0) {
            System.out.println(root.elem + ":" + level);
        }
        
        // Recur on right child
        printInOrderEvenLevels(root.right, level + 1);
    }

    // Tester method to run the tasks
    public static void main(String[] args) {
        // Create tree from image_58cfdd.png
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(30);
        TreeNode n4 = new TreeNode(40);
        TreeNode n5 = new TreeNode(60);
        TreeNode n6 = new TreeNode(50);

        n1.left = n2;   n1.right = n3;
        n2.left = n4;   n2.right = n5;
        n3.right = n6;

        System.out.println("--- 1.1 Pre-order ---");
        printPreOrder(n1); // Output: 10 20 40 60 30 50 
        
        System.out.println("\n\n--- 1.2 Post-order with Levels ---");
        printPostOrderWithLevels(n1, 0); 
        
        System.out.println("\n--- 1.3 In-order (Even Levels only) ---");
        printInOrderEvenLevels(n1, 0);
    }
}
