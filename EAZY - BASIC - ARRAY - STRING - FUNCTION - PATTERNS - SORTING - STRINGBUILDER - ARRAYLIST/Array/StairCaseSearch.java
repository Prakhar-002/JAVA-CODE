public class StairCaseSearch {

      // stair search in 2D array ...

      public static void stairCaseSearch(int matrix[][], int key) {
            int row = 0;
            int col = matrix[0].length - 1;
            while (row < matrix.length && col >= 0) {
                  if (matrix[row][col] == key) {
                        System.out.println("key found at pos (" + row + ", " + col + ")");
                        return;
                  } else if (key < matrix[row][col]) {
                        col--;
                  } else {
                        row++;
                  }
            }
            System.out.println("key not found ...");
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            int matrix[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 47, 50 } };
            int key = 33;
            stairCaseSearch(matrix, key);
      }

      // ? Output

      // key found at pos (3, 1)

}
