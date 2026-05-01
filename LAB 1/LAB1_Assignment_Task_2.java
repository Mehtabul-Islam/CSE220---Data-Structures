public class LAB1_Assignment_Task_2 {
    public static Integer[][] compressMatrix( Integer[][] matrix ){
        int row = matrix.length/2;
        int col = matrix[0].length/2;
        int sum = 0;
        Integer [][] answerA = new Integer [row][col];
        for(int i = 0; i < matrix.length; i += 2){
            for(int j = 0; j < matrix[0].length; j += 2){
                sum += matrix[i][j] + matrix[i+1][j] + matrix[i][j+1] + matrix[i+1][j+1];
                answerA[i/2][j/2] = sum;
                sum = 0;
            }
        }
        return answerA;
    }
    
    public static void main(String[] args){
        Integer[][] matrix = {
            { 1 , 2 , 3 , 4 },
            { 5 , 6 , 7 , 8 },
            { 1 , 3 , 5 , 2 },
            {-2 , 0 , 6 ,-3 }
        };
        System.out.println("Given Matrix: ");
        print2D(matrix);
        
        System.out.println("\nExpected Output:");
        System.out.print("| 14 | 22 |\n| 2  | 10 |\n");
        
        System.out.print("\nYour Output:\n");
        Integer[][] returnedArray = compressMatrix( matrix );
        print2D( returnedArray );
    }

    // Helper method added to fix the missing Arr.print2D logic
    public static void print2D(Integer[][] arr) {
        for (Integer[] row : arr) {
            System.out.print("|");
            for (int i = 0; i < row.length; i++) {
                System.out.print(" " + row[i] + " |");
            }
            System.out.println();
        }
    }
}

