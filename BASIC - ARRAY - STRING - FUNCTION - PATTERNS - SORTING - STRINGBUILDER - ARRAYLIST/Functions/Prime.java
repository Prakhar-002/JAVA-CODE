public class Prime {

      // to check a number is prime or not...
      public static Boolean prime(int n) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                  if (n % i == 0) {
                        return false;
                  }
            }
            return true;
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            System.out.println(prime(22));
      }

      //? Output 
      // 1. 
      //     false

      
}
