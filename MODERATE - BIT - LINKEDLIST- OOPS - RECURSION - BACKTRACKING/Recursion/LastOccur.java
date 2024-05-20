public class LastOccur {

      public static int lastOccur(int arr[], int key, int length) {
            if (length == -1) {
                  return -1;
            }
            if (arr[length - 1] == key) {
                  return (length - 1);
            }
            return lastOccur(arr, key, length - 1);
      }

      public static int lastOccurOptimize(int arr[], int key, int i) {
            if (i == arr.length) {
                  return -1;
            }
            int isFound = lastOccurOptimize(arr, key, i + 1);
            if (isFound == -1 && arr[i] == key) {
                  return i;
            }
            return isFound;
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            System.out.println(lastOccur(new int[] { 5, 8, 62, 22, 22 }, 22, 5));
            System.out.println(lastOccurOptimize(new int[] { 5, 22, 22, 22, 22, 0, 22 }, 22, 0));
      }

      // ? Output
      // 1.
      //     4
      //     6
}
