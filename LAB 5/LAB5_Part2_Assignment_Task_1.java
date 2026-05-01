class BSTNode {
    int elem;
    BSTNode left, right;

    public BSTNode(int elem) {
        this.elem = elem;
        this.left = null;
        this.right = null;
    }
}
public class LAB5_Part2_Assignment_Task_1 {
    public static Integer rangeSum(BSTNode root, Integer low, Integer high) {

        if (root == null) {
            return 0;
        }

        int total = 0;

        if (root.elem >= low && root.elem <= high) {
            total += root.elem;
        }

        if (root.elem > low) {
            total += rangeSum(root.left, low, high);
        }

        if (root.elem < high) {
            total += rangeSum(root.right, low, high);
        }

        return total;
    }

    public static void main(String[] args) {

        // --- Sample 1 ---
        BSTNode root1 = new BSTNode(8);
        root1.left = new BSTNode(4);
        root1.right = new BSTNode(12);
        root1.left.left = new BSTNode(2);
        root1.left.right = new BSTNode(6); // ✅ FIXED HERE
        root1.right.left = new BSTNode(10);
        root1.right.right = new BSTNode(14);

        System.out.println("Sample 1 (Range 5, 13): " + rangeSum(root1, 5, 13));

        // --- Sample 2 ---
        BSTNode root2 = new BSTNode(10);
        root2.left = new BSTNode(5);
        root2.right = new BSTNode(15);
        root2.left.left = new BSTNode(3);
        root2.left.right = new BSTNode(7);
        root2.right.right = new BSTNode(18);

        System.out.println("Sample 2 (Range 7, 15): " + rangeSum(root2, 7, 15));
    }
}
