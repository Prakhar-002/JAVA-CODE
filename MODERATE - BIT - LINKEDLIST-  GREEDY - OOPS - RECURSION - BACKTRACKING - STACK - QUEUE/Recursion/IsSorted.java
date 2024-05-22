public class IsSorted {

      public static boolean isSorted(int arr[], int i) { // i should be 0 from calling of function... // O(n) is tc
            if (i == arr.length - 1) {
                  return true;
            }
            if (arr[i] > arr[i + 1]) {
                  return false;
            }
            return isSorted(arr, i + 1);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            System.out.println(isSorted(new int[] {5, 8, 62, 10, 22}, 0));
      }

      //? Output 
      // 1. 
      //     false
}
