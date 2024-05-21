public class TransposeMatrix {

      // Transpose of a matrix ...
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
            System.out.println("Real Matrix ");
            for (int i = 0; i < m; i++) {
                  for (int j = 0; j < n; j++) {
                        System.out.print(mat[i][j] + " ");
                  }
                  System.out.println();
            }
            System.out.println("\nTranspose Matrix ");
            // transpose matrix ...
            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                        System.out.print(trMat[i][j] + " ");
                  }
                  System.out.println();
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            transposeMatrix();
      }

      // ? Output

      // Real Matrix
      // 11 45 45
      // 55 76 98

      // Transpose Matrix
      // 11 55
      // 45 76
      // 45 98

}
