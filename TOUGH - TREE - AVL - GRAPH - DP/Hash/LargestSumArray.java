import java.util.HashMap;
import java.util.LinkedHashMap;

public class LargestSumArray {
      public static void largestSumArray() { // O(n)
            int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };

            HashMap<Integer, Integer> map = new HashMap<>();

            int sum = 0;
            int len = 0;

            for (int j = 0; j < arr.length; j++) {
                  sum += arr[j];
                  if (map.containsKey(sum)) {
                        LinkedHashMap<Integer, Integer> sumMap = new LinkedHashMap<>();
                        len = Math.max(len, j - map.get(sum));
                        for (int i = map.get(sum) + 1; i <= j; i++) {
                              sumMap.put(arr[i], i);
                        }
                        System.out.println(sumMap.keySet());
                  } else {
                        map.put(sum, j);
                  }
            }

            System.out.println("maximum length of subArray with total sum 0 : " + len);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            largestSumArray();
      }

      // ? Output
      // 1.
      //      [-2, 2]
      //      [-2, 2, -8, 1, 7]
      //      maximum length of subArray with total sum 0 : 5
}
