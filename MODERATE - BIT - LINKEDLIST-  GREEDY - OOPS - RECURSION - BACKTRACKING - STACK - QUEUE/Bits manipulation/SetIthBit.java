public class SetIthBit {

      public static void setIthBit(int n, int i) {
            int bitMask = 1 << i;
            System.out.println(n | bitMask);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            setIthBit(124, 4);
      }

      //? Output 
      // 1. 
      //     124
      
}
