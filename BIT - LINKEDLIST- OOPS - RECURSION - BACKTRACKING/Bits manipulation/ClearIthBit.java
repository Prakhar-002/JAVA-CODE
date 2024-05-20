public class ClearIthBit {

      public static int clearIthBit(int n, int i) {
            int bitMask = ~(1 << i);
            System.out.println(n & bitMask);
            return (n & bitMask);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            clearIthBit(124, 4);
      }

      //? Output 
      // 1. 
      //     108
      
}
