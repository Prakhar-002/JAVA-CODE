public class NCR {

      public static int ncr(int n, int r) {
            int f = 1;
            int fr = 1;
            if (n >= r) {
                  for (int i = n; i > n - r; i--) {
                        f *= i;
                  }
                  for (int i = r; i > 1; i--) {
                        fr *= i;
                  }
            } else {
                  System.out.println("are yrr mad hai kya....");
            }
            return f / fr;
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            System.out.println(ncr(10, 2));
      }

      //? Output 
      // 1. 
      //     45
}
