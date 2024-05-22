public class FirstOccur {

      public static int firstOccur(int arr[], int key, int i) { // tc is O(n)
            if (i == arr.length) {
                  return -1;
            }
            if (arr[i] == key) {
                  return i;
            }
            return firstOccur(arr, key, i + 1);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            System.out.println(firstOccur(new int[] {5, 12, 62, 12, 22}, 12, 0));
      }

      //? Output 
      // 1. 
      //     1
}
