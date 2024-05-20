public class XPowN {

      public static int xPowN(int x, int n) { // O(n)
            if (n == 1) {
                  return x;
            }
            return (x * xPowN(x, n - 1));
      }

      // optimize code for power a number upTo n times...
      // time complexity will be O(log n)...

      public static int optimizePower(int a, int n) {
            if (n == 0) {
                  return 1;
            }
            int halfPower = optimizePower(a, n / 2);
            int halfPowerSqr = halfPower * halfPower;

            if (n % 2 != 0) {
                  halfPowerSqr = (a * halfPowerSqr);
            }

            return halfPowerSqr;
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            System.out.println(xPowN(20, 4));
            System.out.println(optimizePower(12, 7));
      }

      //? Output 
      // 1. 
      //     160000
      //     35831808
}
