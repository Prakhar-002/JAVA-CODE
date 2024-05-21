public class ReverseArray {

      public static void print(int arr[]) {
            System.out.println("Array is ...");
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
            System.out.println();
      }

      public static void reverse(int arr[]) {
            for (int i = 0; i < arr.length / 2; i++) {
                  int temp;
                  temp = arr[i];
                  arr[i] = arr[arr.length - 1 - i];
                  arr[arr.length - 1 - i] = temp;
            }
            print(arr);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            reverse(new int[] { 7, 5, 6, 2, 10, 45 });
      }

      //? Output 
      // 1. 
      //     Array is ...
      //    45 10 2 6 5 7 


}
