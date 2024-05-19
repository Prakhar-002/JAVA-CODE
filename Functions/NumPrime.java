import java.util.*;

public class NumPrime {

      // to check a number is prime or not...
      public static Boolean prime(int n) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                  if (n % i == 0) {
                        return false;
                  }
            }
            return true;
      }

      // print up to n prime number...
      public static void nPrime() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number for prime number up to...");
            int prime = sc.nextInt();
            for (int i = 2; i < prime; i++) {
                  if (prime(i)) {
                        System.out.print(i + " ");
                  }
            }
            sc.close();
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            nPrime();
      }

      //? Output 
      // 1. 
      //      Enter a number for prime number up to...
      //      40
      //      2 3 5 7 11 13 17 19 23 29 31 37 

}
