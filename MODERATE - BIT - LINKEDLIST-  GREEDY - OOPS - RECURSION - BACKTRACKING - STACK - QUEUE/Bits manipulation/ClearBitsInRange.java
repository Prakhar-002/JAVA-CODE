public class ClearBitsInRange {

      public static void clearBitsInRange(int n, int sI, int eI) {
            int a = ((~0) << (eI + 1));
            int b = (1 << sI) - 1;
            int bitMask = a | b;
            System.out.println(n & bitMask);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            clearBitsInRange(1254, 4, 7);
      }

      //? Output 
      // 1. 
      //     1030
      
}
