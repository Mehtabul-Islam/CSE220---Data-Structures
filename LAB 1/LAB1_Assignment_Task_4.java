public class LAB1_Assignment_Task_4{
    public static void rotateSecret(char[][] board) {
        if (board == null || board.length == 0 || board.length % 2 != 0) {
            return; 
        }

        int n = board.length;
        int numLayers = n / 2;

        for (int layer = 0; layer < numLayers; layer++) {
            int rotations = numLayers - layer;
            int L = layer;               
            int R = n - 1 - layer;       
            
            int perimeter = 4 * (R - L); 
            if (perimeter > 0) {
                rotations = rotations % perimeter;
            }

            for (int r = 0; r < rotations; r++) {
                char temp = board[L][L];
                
                for (int i = L; i < R; i++) {
                    board[i][L] = board[i + 1][L];
                }
                for (int i = L; i < R; i++) {
                    board[R][i] = board[R][i + 1];
                }
                for (int i = R; i > L; i--) {
                    board[i][R] = board[i - 1][R];
                }
                for (int i = R; i > L + 1; i--) {
                    board[L][i] = board[L][i - 1];
                }
                board[L][L + 1] = temp;
            }
        }

        // Print the recovered message
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        char[][] board = {
            {'T', 'A', 'U', 'S'},
            {'A', 'R', 'I', '.'},
            {'D', 'T', 'T', 'N'},
            {'S', 'C', 'F', 'U'}
        };
        
        System.out.println("Given Board: ");
        print2D(board);
        
        System.out.println("\nExpected Output:");
        System.out.print("DATASTRUCTISFUN.\n");
        
        System.out.print("\nYour Output:\n");
        rotateSecret(board);

        System.out.print("\n======================\n");
    }

    // Helper method to simulate the Arr.print2D logic from your sample
    public static void print2D(char[][] arr) {
        for (char[] row : arr) {
            System.out.print("{");
            for (int i = 0; i < row.length; i++) {
                System.out.print("'" + row[i] + "'" + (i < row.length - 1 ? ", " : ""));
            }
            System.out.println("}");
        }
    }
}