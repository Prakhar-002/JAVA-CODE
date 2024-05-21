public class ArrEdit {

      // print array function...
      public static void printArr(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
            System.out.println();
      }

      // correct or edit in array ...
      public static void arrEdit(int arr[], int i, int val) {
            // base case...
            if (i == arr.length) {
                  printArr(arr);
                  return;
            }
            // recursion call...
            arr[i] = val;
            arrEdit(arr, i + 1, val + 1);
            arr[i] = arr[i] - 2; // backtracking...
      }

      public static void editArrCall() {
            int arr[] = new int[5];
            arrEdit(arr, 0, 1);
            printArr(arr);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            editArrCall();
      }

      // ? Output
      //  1. 
      //     1 2 3 4 5 
      //    -1 0 1 2 3 
}
