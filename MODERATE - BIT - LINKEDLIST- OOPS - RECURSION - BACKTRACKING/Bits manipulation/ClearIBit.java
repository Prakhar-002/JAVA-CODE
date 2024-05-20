public class ClearIBit {

      public static void clearIBits(int n, int i) {
            int bitMask = (~0) << i;
            System.out.println(n & bitMask);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            clearIBits(124, 5);
      }

      //? Output 
      // 1. 
      //     96
      
}
