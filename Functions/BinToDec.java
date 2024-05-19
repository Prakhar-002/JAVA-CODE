public class BinToDec {

      // binary to decimal ...

      public static void binToDec(int bin) {
            int original = bin;
            int sum = 0;
            int i = 0;
            while (bin > 0) {
                  int res = bin % 10;
                  sum += res * Math.pow(2, i);
                  i++;
                  bin = bin / 10;
            }
            System.out.println("Binary number " + original + " has a dec value = " + sum);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            binToDec(11010);
      }

      //? Output 
      // 1. 
      //    Binary number 11010 has a dec value = 26
}
