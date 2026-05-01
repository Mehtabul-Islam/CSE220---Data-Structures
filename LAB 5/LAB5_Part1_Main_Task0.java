class TreeNode {
    Object elem;
    TreeNode left;
    TreeNode right;

    // Constructor assigns parameter value to elem instance variable
    public TreeNode(Object elem) {
        this.elem = elem;
        this.left = null;
        this.right = null;
    }
}
public class LAB5_Part1_Main_Task0 {
    public static void main(String[] args) {
        // 1. Create 6 different objects of TreeNode class
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(70);
        TreeNode n4 = new TreeNode(40);
        TreeNode n5 = new TreeNode(60);
        TreeNode n6 = new TreeNode(50);

        // 2. Connect TreeNodes as shown in the illustration
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;

        System.out.println("=== Execution Trace and Error Fixes ===\n");

        // Row 1
        System.out.println("Code: System.out.println( n1.left );");
        System.out.println("Output: " + n1.left + " (Memory reference to node n2)\n");

        // Row 2
        System.out.println("Code: System.out.println( n3.right.elem );");
        System.out.println("Output: " + n3.right.elem + "\n");

        // Row 3
        TreeNode x = n2.left;
        System.out.println("Code: TreeNode x = n2.left; System.out.println( n1.elem + x.elem );");
        System.out.println("-> ERROR: Java cannot use '+' directly on Object types for math.");
        System.out.println("-> FIX: Cast elements to Integer to perform addition.");
        System.out.println("-> Fixed Output: " + ((Integer)n1.elem + (Integer)x.elem) + "\n");

        // Row 4
        x = new TreeNode(80);
        n3.left = x;
        System.out.println("Code: n3.left = x; System.out.println(n1.right.left.elem);");
        System.out.println("Output: " + n1.right.left.elem + "\n");

        // Row 5
        System.out.println("Code: System.out.println(n1.left.right + n5.left);");
        System.out.println("-> ERROR: Cannot add a TreeNode object (n1.left.right) and null (n5.left).");
        System.out.println("-> FIX: To print memory references, concatenate with a String.");
        System.out.println("-> Fixed Output: " + n1.left.right + " " + n5.left + "\n");

        // Row 6
        n1.left.right = null;
        System.out.println("Code: n1.left.right = null; System.out.println(n1.left.right.elem);");
        System.out.println("-> ERROR: java.lang.NullPointerException.");
        System.out.println("-> WHY: You set n1.left.right (node n5) to null, then tried to access '.elem' from null.");
        System.out.println("-> FIX: Ensure the node is not null before accessing its variables.\n");
    }
}
