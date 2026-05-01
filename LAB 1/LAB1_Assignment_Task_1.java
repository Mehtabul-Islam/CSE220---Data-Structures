public class LAB1_Assignment_Task_1 {
    public static Integer rowRotation( Integer examWeek, String[][] matrix ){

        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < examWeek-1; i++){
            String [] array = matrix[row - 1];
            for(int j = row - 1; j > 0; j--){
                matrix[j] = matrix [j - 1];
            }
            matrix[0] = array;
        }

        for(int i = 0; i < row; i++){
            System.out.print("| ");
            for(int j = 0; j < col; j++){
                System.out.print(matrix[i][j]);
                if(matrix[i][j].length() == 1){
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
        
        int number = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j].equals("AA")) {
                    number = i + 1;
                    break;
                }
            }
        }
        return number;
    }

    public static void main(String[] args){
        String[][] seatStatus = {
                {"A" , "B"  , "C"  , "D"  , "E"},
                {"F" , "G"  , "H"  , "I"  , "J"},
                {"K" , "L"  , "M"  , "N"  , "O"},
                {"P" , "Q"  , "R"  , "S"  , "T"},
                {"U" , "V"  , "W"  , "X"  , "Y"},
                {"Z" , "AA" , "BB" , "CC" , "DD"}
        };
        System.out.println("Given Seat Status: ");
        print2D(seatStatus);
        
        System.out.println("\nExpected Output:");
        System.out.println("| U  | V  | W  | X  | Y  | ");
        System.out.println("| Z  | AA | BB | CC | DD | ");
        System.out.println("| A  | B  | C  | D  | E  | ");
        System.out.println("| F  | G  | H  | I  | J  | ");
        System.out.println("| K  | L  | M  | N  | O  | ");
        System.out.println("| P  | Q  | R  | S  | T  | ");
        System.out.println("Your friend AA will be on row 2");
        
        System.out.print("\nYour Output:\n");
        Integer examWeek = 3;
        //This following should print modified seat status after rotation and return the current exam week
        Integer rowNumber = rowRotation( examWeek, seatStatus );
        //The following should print Your friend AA will be on row 2
        System.out.println("Your friend AA will be on row "+rowNumber);
    }

    // Helper method added to fix the missing Arr.print2D logic
    public static void print2D(String[][] arr) {
        for (String[] row : arr) {
            System.out.print("{");
            for (int i = 0; i < row.length; i++) {
                System.out.print("\"" + row[i] + "\"" + (i < row.length - 1 ? ", " : ""));
            }
            System.out.println("}");
        }
    }
}