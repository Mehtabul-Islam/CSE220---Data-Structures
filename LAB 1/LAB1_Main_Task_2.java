public class LAB1_Main_Task_2 {
    // Method to decrypt matrix
    public static int[] decrypt_matrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: find column-wise sums
        int[] colSum = new int[cols];

        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += matrix[i][j];
            }
            colSum[j] = sum;
        }

        // Step 2: find difference between consecutive column sums
        int[] result = new int[cols - 1];

        for (int i = 0; i < cols - 1; i++) {
            result[i] = colSum[i + 1] - colSum[i];
        }

        return result;
    }

    // Helper to print array
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // DRIVER CODE
    public static void main(String[] args) {

        int[][] matrix = {
            {1, 3, 1, 6},
            {4, 2, 5, 1},
            {7, 9, 3, 3},
            {8, 5, 4, 2}
        };

        int[] decrypted = decrypt_matrix(matrix);

        System.out.print("Decrypted Array: ");
        printArray(decrypted);
    }
}
