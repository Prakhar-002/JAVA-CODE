import java.util.Scanner;

public class BinarySearch {

      public static int binarySearch(int arr[], int key) {
            int start = 0, end = arr.length - 1;
            while (start <= end) {
                  int mid = (start + end) / 2;
                  // comparisons
                  if (arr[mid] == key) {
                        return mid;
                  }
                  if (arr[mid] < key) {
                        start = mid + 1;
                  } else {
                        end = mid - 1;
                  }
            }
            return -1;
      }

      public static void binaryCall() {
            Scanner sc = new Scanner(System.in);
            int arr[] = { 2, 4, 6, 8, 10, 12, 16, 18 };
            System.out.println("search num value...");
            int key = sc.nextInt();
            int ans = binarySearch(arr, key);
            if (ans == -1) {
                  System.out.println("value not found !!!");
            } else {
                  System.out.println("value " + arr[ans] + " found at index " + ans);
            }
            sc.close();
      }



      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            binaryCall();
      }

      //? Output 
      // 1. 
      //     search num value...
      //     12
      //     value 12 found at index 5

}
