import java.util.Scanner;

public class LinearSearch {

      public static void linearSearch(int arr[]) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number you want to search...");
            int n = sc.nextInt();
            for (int i = 0; i < arr.length; i++) {
                  if (arr[i] == n) {
                        System.out.println("value found at index = " + i);
                        return;
                  }
            }
            System.out.println("value not found ");
            sc.close();
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            linearSearch(new int[] { 7, 5, 6, 2, 10, 45 });
      }

      //? Output 
      // 1. 
      //     Enter the number you want to search...
      //     10
      //     value found at index = 4

      // 2. 

      //      Enter the number you want to search...
      //      25
      //      value not found 
}
