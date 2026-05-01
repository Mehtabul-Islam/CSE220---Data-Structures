public class LAB1_Assignment_Task_3 {
    public static void playGame( Integer[][] arena ){
        int rownum = arena.length;
        int colnum = arena[0].length;
        int sum = 0;
        for(int a = 0; a < rownum; a++){
            for(int b = 0; b < colnum; b++){
                if(arena[a][b] % 50 == 0 && arena[a][b] != 0){
                    if(a + 1 < rownum){
                        if(arena[a+1][b] == 2){
                            sum += 2;
                        }
                        else{
                            continue;
                        }
                    }
                    if(a - 1 >= 0){
                        if(arena[a-1][b] == 2){
                            sum += 2;
                        }
                        else{
                            continue;
                        }
                    }
                    if(b + 1 < colnum){
                        if(arena[a][b+1] == 2){
                            sum += 2;
                        }
                        else{
                            continue;
                        }
                    }
                    if(b - 1 >= 0){
                        if(arena[a][b-1] == 2){
                            sum += 2;
                        }
                        else{
                            continue;
                        }
                    }
                }
            }
        }
        if(sum >= 10){
            System.out.println("Points Gained: " + sum + ". Your team has survived the game.");
        }
        else{
            System.out.println("Points Gained: " + sum + ". Your team is out.");
        }
    }
    public static void main(String[] args){
        Integer[][] arena = {
            {0,2,2,0},
            {50,1,2,0},
            {2,2,2,0},
            {1,100,2,0}
        };
        System.out.println("Given Arena: ");
        print2D(arena);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 6. Your team is out.\n");
        
        System.out.print("\nYour Output:\n");
        playGame( arena );

        System.out.print("\n======================\n");

        Integer[][] arena1 = {
            {0,2,2,0,2},
            {1,50,2,1,100},
            {2,2,2,0,2},
            {0,200,2,0,0}
        };
        System.out.println("\nGiven Arena: ");
        print2D(arena1);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 14. Your team has survived the game.\n");
        
        System.out.print("\nYour Output:\n");
        playGame( arena1 );
    }

    // Helper method added to fix the missing Arr.print2D logic
    public static void print2D(Integer[][] arr) {
        for (Integer[] row : arr) {
            System.out.print("{");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + (i < row.length - 1 ? ", " : ""));
            }
            System.out.println("}");
        }
    }
}
