import java.util.Arrays;
import java.util.Comparator;

public class MaxLenChairPair {
      
      public static void maxLenChairPair() { // O(n log n)
            int pair[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

            Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));

            int chainLen = 1;
            int chainEnd = pair[0][1];

            System.out.print("pairs are in ...[ ");
            System.out.print("(" + pair[0][0] + " , " + pair[0][1] + ")" + " ");
            for (int i = 1; i < pair.length; i++) {
                  if (pair[i][0] > chainEnd) {
                        chainLen++;
                        chainEnd = pair[i][1];
                        System.out.print("(" + pair[i][0] + " , " + pair[i][1] + ")" + " ");
                  }
            }
            System.out.println("]");

            System.out.println("max number of chain can be form is : " + chainLen);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            maxLenChairPair();
      }

      // ? Output
      //  1.
      //     pairs are in ...[ (5 , 24) (27 , 40) (50 , 90) ]
      //     max number of chain can be form is : 3
}
