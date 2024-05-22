import java.util.Arrays;
import java.util.Collections;

public class ChocolateCuttingProblem {
      
      public static void chocolateCuttingProblem() {
            int horizontal = 3, vertical = 5;
            Integer verCost[] = { 2, 1, 3, 1, 4 };
            Integer horCost[] = { 4, 1, 2 };

            // sort the cost according to their cost on vertical and horizontal...
            Arrays.sort(verCost, Collections.reverseOrder());
            Arrays.sort(horCost, Collections.reverseOrder());

            int horCut = 0, verCut = 0;
            int horPiece = 1, verPiece = 1;
            int cost = 0;

            while (horCut < horizontal && verCut < vertical) {
                  // hor cost > ver cost --> horCost first
                  if (horCost[horCut] >= verCost[verCut]) { // horizontal cut...
                        cost += (horCost[horCut] * verPiece);
                        horPiece++;
                        horCut++;
                  } else { // vertical cut...
                        cost += (verCost[verCut] * horPiece);
                        verPiece++;
                        verCut++;
                  }
            }

            // remaining part of horizontal
            while (horCut < horizontal) {
                  cost += (horCost[horCut] * verPiece);
                  horPiece++;
                  horCut++;
            }

            // remaining part of vertical
            while (verCut < vertical) {
                  cost += (verCost[verCut] * horPiece);
                  verPiece++;
                  verCut++;
            }

            System.out.println(
                        "minimum cost to cut a piece of chocolate according to their verCost and horCost is : " + cost);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            chocolateCuttingProblem();
      }

      // ? Output
      //  1.
      //     minimum cost to cut a piece of chocolate according to their verCost and horCost is : 42
}
