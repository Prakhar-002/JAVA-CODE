public class MaxSumSubArr {

      // time complexity is very bad big oh of N_cube...
      // brute force...
      public static void maxSumSubArr() {
            int arr[] = { 2, 4, 6, 8, 10 };
            int sum = 0;
            int maxSum = Integer.MIN_VALUE; // it represent -infinity value...
            for (int i = 0; i < arr.length; i++) {
                  for (int j = i; j < arr.length; j++) {
                        sum = 0;
                        for (int k = i; k < j; k++) {
                              // System.out.print(arr[k] + " ");
                              sum += arr[k];
                              if (maxSum < sum) {
                                    maxSum = sum;
                              }
                        }
                  }
            }
            System.out.println("max sum of sub array is -> " + maxSum);
      }

      //----------------------------------------------------------------------------------

      // prefix sum ...
      // It has time complexity N_square...better the previous one...
      public static void maxSumPrefix() {
            int arr[] = { 2, 4, 6, 8, 10 };
            int sum = 0;
            int maxSum = Integer.MIN_VALUE;
            int prefix[] = new int[arr.length];
            prefix[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                  prefix[i] = prefix[i - 1] + arr[i];
            }

            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr.length; j++) {
                        sum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                        if (maxSum < sum) {
                              maxSum = sum;
                        }
                  }
            }
            System.out.println(maxSum);
      }

      //----------------------------------------------------------------------------------

      // kadane's is most easy way to find max sum of sub array...
      //! LEET-CODE 53
      public static void kadanes() {
            int cs = 0;
            int ms = Integer.MIN_VALUE;
            int arr[] = { -2, 4, -6, 8, -10 };
            for (int i = 0; i < arr.length; i++) {
                  if (cs < 0) {
                        cs = arr[i]; // Either each box will start it's own train
                  } else {
                        cs += arr[i]; // Or it will add to our existing train
                  }
                  ms = Math.max(cs, ms);
            }
            System.out.println("MAX sum of subArray is : " + ms);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            maxSumSubArr();
            maxSumPrefix();
            kadanes();
      }

      //? Output 
      // 1. 
      //      max sum of sub array is -> 20
      //      30
      //      MAX sum of subArray is : 8
}
