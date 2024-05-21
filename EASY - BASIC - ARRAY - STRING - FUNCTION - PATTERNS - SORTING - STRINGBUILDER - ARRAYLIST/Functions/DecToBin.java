public class DecToBin {

      // decimal to binary...

      public static void decToBin(int n) {
            int bin = 0;
            int i = 0;
            while (n > 0) {
                  int res = n % 2;
                  bin += res * (int) Math.pow(10, i);
                  i++;
                  n = n / 2;
            }
            System.out.println("binary number is " + bin);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            decToBin(201);
      }

      //? Output 
      // 1. 
      //     binary number is 11001001

}
