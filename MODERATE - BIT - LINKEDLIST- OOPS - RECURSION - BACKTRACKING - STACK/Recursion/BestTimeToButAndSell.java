public class BestTimeToButAndSell {

      // best time to buy and sell a stock....

      public static void bestTimeToBuyAndSell(int price[]) {
            int n = price.length;
            int maxPrice = 0;
            int buyPrice = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                  if (buyPrice < price[i]) {
                        int profit = price[i] - buyPrice;
                        maxPrice = Math.max(maxPrice, profit);
                  } else {
                        buyPrice = price[i];
                  }
            }
            System.out.println(maxPrice);
      }

      public static void bestTimeToBuyAndSellPrint() {
            int price[] = { 4, 7, 5, 2, 4, 8, 11 };
            bestTimeToBuyAndSell(price);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            bestTimeToBuyAndSellPrint();
      }

      // ? Output
      // 1.
      //     9
}
