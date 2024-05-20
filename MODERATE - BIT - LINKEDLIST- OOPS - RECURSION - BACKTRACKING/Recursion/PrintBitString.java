public class PrintBitString {

      // bitString which can't content 1 1 simultaneously ...
      public static void printBitString(int len, int lastBit, String str) {
            // base case
            if (len == 0) {
                  System.out.println(str);
                  return;
            }

            // work...
            // if (lastBit == 0) {
            //    printBitString(len-1, 0, str+"0");
            //    printBitString(len-1, 1, str+"1");
            // } else {
            //    printBitString(len-1, 0, str+"0");
            // }

            // optimize work ...
            printBitString(len - 1, 0, str + "0");

            if (lastBit == 0) {
                  printBitString(len - 1, 1, str + "1");
            }

      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            printBitString(2, 0, "00");
      }

      //? Output 
      // 1. 
      //     0000
      //     0001
      //     0010
}
