import java.util.*;

public class Array_2D {

      public static void inputAndOutput() {
            int matrix[][] = new int[3][3];
            int m = matrix.length, n = matrix[0].length;
            Scanner Joe = new Scanner(System.in);
            System.out.println("Enter the elements of matrix...");
            for (int i = 0; i < m; i++) {
                  for (int j = 0; j < n; j++) {
                        matrix[i][j] = Joe.nextInt();
                  }
            }
            System.out.println("Your 2D array is ...");
            for (int i = 0; i < m; i++) {
                  for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                  }
                  System.out.println();
            }
            Joe.close();
      }

      public static void main(String args[]) {
            inputAndOutput();
      }
}
