import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoin {
      
      public static void indianCoin() { // canonical coin system...O( n log n)
            Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

            // first we sort it in reverse order...
            Arrays.sort(coins, Comparator.reverseOrder());

            int amount = 590;
            int countOfCoin = 0;
            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < coins.length; i++) {
                  if (amount >= coins[i]) {
                        while (amount >= coins[i]) {
                              countOfCoin++;
                              arr.add(coins[i]);
                              amount -= coins[i];
                        }
                  }
            }
            System.out.println("number of coins are : " + countOfCoin);
            System.out.println("notes/coins used are : " + arr);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            indianCoin();
      }

      // ? Output
      //  1.
      //     number of coins are : 4
      //     notes/coins used are : [500, 50, 20, 20]
}
