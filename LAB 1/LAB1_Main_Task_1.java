public class LAB1_Main_Task_1 {
    // Zigzag walk on chessboard pattern (black tiles only)
    public static void zigzagWalk(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        System.out.println("Zigzag Walk Output:");

        for (int j = 0; j < m; j++) {

            // even column → top to bottom
            if (j % 2 == 0) {

                for (int i = 0; i < n; i++) {

                    // black tile condition
                    if ((i + j) % 2 == 0) {
                        System.out.print(mat[i][j] + " ");
                    }
                }
                System.out.println();
            }

            // odd column → bottom to top
            else {

                for (int i = n - 1; i >= 0; i--) {

                    // black tile condition
                    if ((i + j) % 2 == 0) {
                        System.out.print(mat[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    // Helper to print matrix
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // DRIVER CODE
    public static void main(String[] args) {

        int[][] mat = {
            {3, 8, 4, 6, 1},
            {7, 2, 1, 9, 3},
            {9, 0, 7, 5, 8},
            {2, 1, 3, 4, 0},
            {1, 4, 2, 8, 6}
        };

        System.out.println("Input Matrix:");
        printMatrix(mat);
        System.out.println();

        zigzagWalk(mat);
    }
}