public class LAB1_Intro_Task {
    
    // 1. Print Row-wise
    public static void printRowWise(int[][] mat) {
        System.out.println("Row-wise Print:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 2. Print Column-wise
    public static void printColumnWise(int[][] mat) {
        System.out.println("Column-wise Print:");
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 3. Diagonal absolute difference
    public static int diagonalDifference(int[][] mat) {
        int n = mat.length;
        int primary = 0;
        int secondary = 0;

        for (int i = 0; i < n; i++) {
            primary += mat[i][i];
            secondary += mat[i][n - i - 1];
        }

        return Math.abs(primary - secondary);
    }

    // 4. Transpose matrix
    public static int[][] transpose(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] result = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[j][i] = mat[i][j];
            }
        }

        return result;
    }

    // Helper function to print matrix
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
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(mat);

        System.out.println();

        printRowWise(mat);
        System.out.println();

        printColumnWise(mat);
        System.out.println();

        int diff = diagonalDifference(mat);
        System.out.println("Diagonal Absolute Difference: " + diff);

        System.out.println();

        int[][] transposed = transpose(mat);
        System.out.println("Transposed Matrix:");
        printMatrix(transposed);
    }
}