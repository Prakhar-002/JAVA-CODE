public class TillingProb {

      public static int tilingProb(int n) { // 2* n tile area ...
            if (n == 0 || n == 1) {
                  return 1;
            }
            // method ans choice in horizontal and vertical
            // when vertical is choose
            int type1 = tilingProb(n - 1);

            int type2 = tilingProb(n - 2);

            // total method to fill that area ...

            return (type1 + type2);

            // or we can simply right like
            // return (tilingProb(n-1) + tilingProb(n-2));
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            System.out.println(tilingProb(4));
      }

      //? Output 
      // 1. 
      //     5
}
