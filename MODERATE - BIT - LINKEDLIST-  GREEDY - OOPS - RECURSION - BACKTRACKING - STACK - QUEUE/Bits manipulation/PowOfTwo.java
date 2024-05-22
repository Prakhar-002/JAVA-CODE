public class PowOfTwo {

      public static boolean isNumPowOfTwo(int n) {
            return (n & (n - 1)) == 0;
      }

      public static void isNumPowOfTwoCall(int n) {
            if (isNumPowOfTwo(n) == false) {
                  System.out.println("num is not a power of 2 ...");
            } else {
                  System.out.println("num is power of 2 ...");
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            isNumPowOfTwoCall(451);
      }

      //? Output 
      // 1. 
      //     num is not a power of 2 ...
      
}
