import java.util.HashMap;

public class NSubArraySumK {

      // SubArray sum equal to K
      public static void nSubArraySumK() {
            int arr[] = { 10, 2, -2, -20, 10 };
            int k = -10;

            HashMap<Integer, Integer> map = new HashMap<>();
            // (sum ,count)
            map.put(0, 1);

            int sum = 0;
            int ans = 0;

            for (int j = 0; j < arr.length; j++) {
                  sum += arr[j];
                  if (map.containsKey(sum - k)) {
                        ans += map.get(sum - k);
                  }
                  map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            System.out.println("Total number of array of sum " + k + " is : " + ans);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            nSubArraySumK();
      }

      // ? Output
      // 1.
      //     Total number of array of sum -10 is : 3
}
