import java.util.*;

public class Array_2D {

      public static void inputAndOutput() {
            int matrix[][] = new int[3][3];
            int m = matrix.length, n = matrix[0].length;
            Scanner Joe = new Scanner(System.in);
            System.out.println("enter the elements of matrix...");
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

      public static void spiralMatrixPrint(int matrix[][]) {
            int startRow = 0;
            int endRow = matrix.length - 1;
            int startCol = 0;
            int endCol = matrix[0].length - 1;
            while (startRow <= endRow && startCol <= endCol) {
                  // top ...
                  for (int j = startCol; j <= endCol; j++) {
                        System.out.print(matrix[startRow][j] + " ");
                  }
                  // left ...
                  for (int i = startRow + 1; i <= endRow; i++) {
                        System.out.print(matrix[i][endCol] + " ");
                  }
                  // bottom...
                  for (int j = endCol - 1; j >= startCol; j--) {
                        if (startRow == endRow) {
                              break;
                        }
                        System.out.print(matrix[endRow][j] + " ");
                  }
                  // left...
                  for (int i = endRow - 1; i >= startRow + 1; i--) {
                        if (startCol == endCol) {
                              break;
                        }
                        System.out.print(matrix[i][startCol] + " ");
                  }
                  startRow++;
                  startCol++;
                  endRow--;
                  endCol--;
            }
            System.out.println();
      }

      public static void diagonalSum(int matrix[][]) {
            int sum = 0;

            // n^2 complexity...
            // for(int i=0;i<matrix.length;i++){
            // for(int j=0;j<matrix[0].length;j++){
            // if(i == j){
            // sum+=matrix[i][j];
            // }
            // else if(i+j==matrix.length-1){
            // sum+=matrix[i][j];
            // }
            // }
            // }

            for (int i = 0; i < matrix.length; i++) {
                  // primary diagonal ...
                  sum += matrix[i][i];
                  // secondary diagonal ...
                  if (i != matrix.length - i - 1) {
                        sum += matrix[i][matrix.length - i - 1];
                  }
            }
            System.out.println("Total diagonal elements sum is ... -> " + sum);
      }

      // stair search in 2D array ...

      public static void stairCaseSearch(int matrix[][], int key) {
            int row = 0;
            int col = matrix[0].length - 1;
            while (row < matrix.length && col >= 0) {
                  if (matrix[row][col] == key) {
                        System.out.println("key found at pos (" + row + "," + col + ")");
                        return;
                  } else if (key < matrix[row][col]) {
                        col--;
                  } else {
                        row++;
                  }
            }
            System.out.println("key not found ...");
      }

      // transpose of a matrix ...
      public static void transposeMatrix() {
            // 2*3 matrix
            int mat[][] = { { 11, 45, 45 }, { 55, 76, 98 } };
            int m = mat.length;
            int n = mat[0].length;
            int trMat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                        trMat[i][j] = mat[j][i];
                  }
            }
            // real matrix ...
            for (int i = 0; i < m; i++) {
                  for (int j = 0; j < n; j++) {
                        System.out.print(mat[i][j] + " ");
                  }
                  System.out.println();
            }
            // transpose matrix ...
            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                        System.out.print(trMat[i][j] + " ");
                  }
                  System.out.println();
            }
      }

      public static void machine(int a, int b){
            
      }

      public static void main(String args[]) {
            // int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
            // // spiralMatrixPrint(matrix);
            // diagonalSum(matrix);
            // int matrix1[][]={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,47,50}};
            // int key =33;
            // starCaseSearch(matrix1, key);
            transposeMatrix();
            // String str = "ApnaCollege".replace( "1","");
            // System. out . println (str) ;
      }
}
