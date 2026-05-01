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
public class LAB5_Part1_Assignment_Task_2 {
    
public static Integer levelSum(BTNode root) {
        // Start recursion from level 0
        return dif(root, 0);
    }

    private static Integer dif(BTNode root, int level) {
        if (root == null) {
            return 0;
        }
        
        // If level is even (0, 2, 4...), subtract the value
        if (level % 2 == 0) {
            return -(Integer)root.elem + dif(root.left, level + 1) + dif(root.right, level + 1);
        } 
        // If level is odd (1, 3, 5...), add the value
        else {
            return (Integer)root.elem + dif(root.left, level + 1) + dif(root.right, level + 1);
        }
    }

    public static void main(String[] args) {
        // Constructing the tree from image_57197f.png
        BTNode root = new BTNode(1);      // Level 0 (Even)
        
        root.left = new BTNode(2);       // Level 1 (Odd)
        root.right = new BTNode(3);      // Level 1 (Odd)
        
        root.left.left = new BTNode(4);  // Level 2 (Even)
        root.right.left = new BTNode(5); // Level 2 (Even)
        root.right.right = new BTNode(6);// Level 2 (Even)
        
        root.right.left.left = new BTNode(7);  // Level 3 (Odd)
        root.right.left.right = new BTNode(8); // Level 3 (Odd)

        // Calculation: (-1) + (2 + 3) + (-4 - 5 - 6) + (7 + 8)
        // -1 + 5 - 15 + 15 = 4
        int result = levelSum(root);
        System.out.println("Sample Output: " + result); // Expected: 4
    }
}
