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
public class LAB5_Part1_Assignment_Task_3 {
    public static void swap_child(BTNode root, int level, int M) {
        // Base Case: Stop if node is null
        if (root == null) {
            return;
        }

        // Logic: Swap children if the current level is M or "above" (0 to M)
        if (level <= M) {
            BTNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        // Recursive Calls: Process children and increment level
        // Note: We traverse the children regardless of whether we swapped them
        // to ensure we reach all nodes up to level M deeper in the tree.
        swap_child(root.left, level + 1, M);
        swap_child(root.right, level + 1, M);
    }

    public static void main(String[] args) {
        // Constructing the tree from the Input Tree in the image
        BTNode root = new BTNode("A");
        root.left = new BTNode("B");
        root.right = new BTNode("C");
        
        root.left.left = new BTNode("D");
        root.left.right = new BTNode("E");
        root.right.right = new BTNode("F");
        
        root.left.left.left = new BTNode("G");
        root.left.left.right = new BTNode("H");
        root.left.right.left = new BTNode("I");
        root.right.right.left = new BTNode("J");

        System.out.println("Swapping children for level 2 and above...");
        swap_child(root, 0, 2);
        
        // After swap_child(root, 0, 2):
        // Level 0: A's children swap (C is now left, B is now right)
        // Level 1: C and B's children swap
        // Level 2: D, E, and F's children swap
    }
}
