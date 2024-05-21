public class DiagonalSum {

      public static void diagonalSum(int matrix[][]) {
            int sum = 0;

            // n^2 complexity...
            // for (int i = 0; i < matrix.length; i++) {
            // for (int j = 0; j < matrix[0].length; j++) {
            // if (i == j) {
            // sum += matrix[i][j];
            // } else if (i + j == matrix.length - 1) {
            // sum += matrix[i][j];
            // }
            // }
            // }

            for (int i = 0; i < matrix.length; i++) {
                  // primary diagonal ...
                  sum += matrix[i][i];
                  // secondary diagonal ...
                  if (i != matrix.length - i - 1) { // If i != j
                        sum += matrix[i][matrix.length - i - 1];
                  }
            }
            System.out.println("Total diagonal elements sum is ... -> " + sum);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
            diagonalSum(matrix);
      }

      //? Output

      // Total diagonal elements sum is ... -> 68

}
