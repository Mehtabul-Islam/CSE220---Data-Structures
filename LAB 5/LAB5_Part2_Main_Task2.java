class BTNode {
    int elem;
    BTNode left, right;

    public BTNode(int elem) {
        this.elem = elem;
    }
}
public class LAB5_Part2_Main_Task2 {
    public static BTNode findLCA(BTNode root, int n1, int n2) {
        BTNode current = root;

        while (current != null) {
            // If both n1 and n2 are smaller than current, LCA is in left
            if (n1 < current.elem && n2 < current.elem) {
                current = current.left;
            }
            // If both n1 and n2 are greater than current, LCA is in right
            else if (n1 > current.elem && n2 > current.elem) {
                current = current.right;
            }
            // If values "split" or one value equals current.elem, this is the LCA
            else {
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Build the tree from the image
        BTNode root = new BTNode(15);
        root.left = new BTNode(10);
        root.right = new BTNode(25);
        root.left.left = new BTNode(8);
        root.left.right = new BTNode(12);
        root.left.left.left = new BTNode(6);
        root.left.left.right = new BTNode(9);
        root.right.left = new BTNode(20);
        root.right.right = new BTNode(30);
        root.right.left.left = new BTNode(18);
        root.right.left.right = new BTNode(22);

        // Test Cases from image_570dc5.png
        System.out.println("LCA(6, 12): " + findLCA(root, 6, 12).elem);   // Result: 10
        System.out.println("LCA(20, 6): " + findLCA(root, 20, 6).elem);   // Result: 15
        System.out.println("LCA(18, 22): " + findLCA(root, 18, 22).elem); // Result: 20
        System.out.println("LCA(20, 25): " + findLCA(root, 20, 25).elem); // Result: 25
        System.out.println("LCA(10, 12): " + findLCA(root, 10, 12).elem); // Result: 10
    }
}
