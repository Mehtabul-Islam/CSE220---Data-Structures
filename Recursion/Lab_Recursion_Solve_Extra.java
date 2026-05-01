package Recursion;
import java.util.ArrayList;
import java.util.Arrays;
public class Lab_Recursion_Solve_Extra {
    // ==========================================
    // Extra Task: Flatten a nested array
    // ==========================================
    public static int[] flattenArray(Object[] nestedArray) {
        // We use an ArrayList locally to collect items because we don't 
        // know the final size of the flattened array in advance.
        ArrayList<Integer> resultList = new ArrayList<>();
        
        // Call the recursive helper
        flattenHelper(nestedArray, resultList);

        // Convert the ArrayList back to a standard primitive int[] array for the final return
        int[] flatArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            flatArray[i] = resultList.get(i);
        }
        
        return flatArray;
    }

    // Helper method to traverse the nested structure
    private static void flattenHelper(Object[] currentArray, ArrayList<Integer> resultList) {
        for (int i = 0; i < currentArray.length; i++) {
            Object element = currentArray[i];
            
            // Base Case behavior: If the element is a plain Integer, add it to our list
            if (element instanceof Integer) {
                resultList.add((Integer) element);
            } 
            // Recursive Step: If the element is another array, dive into it
            else if (element instanceof Object[]) {
                flattenHelper((Object[]) element, resultList);
            }
        }
    }

    // ==========================================
    // Main Method (Tester)
    // ==========================================
    public static void main(String[] args) {
        // Constructing the exact complex array from the image:
        // [1, [2, [3, [4], 5], 6], 7, 8, [9, [[10, 11], 12], 13], 14, [15, [16, [17]]]]
        Object[] complexNestedArray = {
            1,
            new Object[]{2, new Object[]{3, new Object[]{4}, 5}, 6},
            7,
            8,
            new Object[]{9, new Object[]{new Object[]{10, 11}, 12}, 13},
            14,
            new Object[]{15, new Object[]{16, new Object[]{17}}}
        };

        System.out.println("--- Flattening Nested Array ---");
        
        int[] result = flattenArray(complexNestedArray);
        
        System.out.println("Output Array: ");
        System.out.println(Arrays.toString(result));
        // Expected Output:
        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17]
    }
}
