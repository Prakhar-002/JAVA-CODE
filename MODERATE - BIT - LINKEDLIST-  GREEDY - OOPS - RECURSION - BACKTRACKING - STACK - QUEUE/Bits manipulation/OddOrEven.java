public class OddOrEven {

      public static void oddOrEven(int n) {
            int bitmask = 1;
            if ((n & bitmask) == 1) {
                  System.out.println("number is odd...");
            } else {
                  System.out.println("number is even...");
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            oddOrEven(10);
            oddOrEven(11);
      }

      //? Output 
      // 1. 
      //     number is even...
      //     number is odd...
      
      
}
