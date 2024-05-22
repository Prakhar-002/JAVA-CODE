import java.util.*;

public class FrictionalKnapsack {

      public static void frictionalKnapsack() {
            int val[] = { 60, 100, 120 }; // price of a value...
            int weight[] = { 10, 20, 30 }; // weight of each things
            int w = 50; // maximum weight of a knapsack ...(pocket)

            // sort things ...
            double ratio[][] = new double[val.length][2];
            // 0 th col => index ... 1st col =>ratio

            for (int i = 0; i < ratio.length; i++) {
                  ratio[i][0] = i; // 0sth col index...
                  ratio[i][1] = val[i] / (double) weight[i]; // 1st col ratio...
            }

            // sort 2-D array ascending
            Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

            int capacity = w;
            int maxProfit = 0;
            for (int i = ratio.length - 1; i >= 0; i--) {
                  int idx = (int) ratio[i][0];
                  if (capacity >= weight[idx]) {
                        maxProfit += val[idx]; // include full item...
                        capacity -= weight[idx];
                        System.out.println("item of value " + val[idx] + " of weight " + weight[idx] + " ");
                  } else {
                        // include fraction...
                        maxProfit += (ratio[i][1] * capacity);
                        System.out.println("And item of value " + val[idx] + " of weight " + capacity + " ");
                        capacity = 0;
                        break;
                  }
            }
            System.out.println("Max profit of all item taken up to weight " + w + " is : " + maxProfit);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            frictionalKnapsack();
      }

      // ? Output
      // 1.
      // item of value 60 of weight 10
      // item of value 100 of weight 20
      // And item of value 120 of weight 20
      // Max profit of all item taken up to weight 50 is : 240
}
