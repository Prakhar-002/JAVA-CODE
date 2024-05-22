import java.util.Arrays;

public class MinSumOfAbsoluteDiff {

      public static void minSumOfAbsoluteDiff() { // O(n log n)
            int A[] = { 1, 2, 3 };
            int B[] = { 2, 1, 3 };

            Arrays.sort(A);
            Arrays.sort(B);

            int minDiffSum = 0;
            for (int i = 0; i < A.length; i++) {
                  minDiffSum += Math.abs(A[i] - B[i]);
            }

            System.out.println("Minimum sum of absolute difference is " + minDiffSum);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            minSumOfAbsoluteDiff();
      }

      // ? Output
      // 1.
      // Minimum sum of absolute difference is 0
}
