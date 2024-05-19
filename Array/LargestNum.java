public class LargestNum {

      public static void largestNum(int arr[]) {
            int largestNum = arr[0];
            for (int i = 0; i < arr.length; i++) {
                  if (arr[i] > largestNum) {
                        largestNum = arr[i];
                  }
            }
            System.out.println("largest number in given array is : " + largestNum);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            largestNum(new int[] { 7, 5, 6, 2, 10, 45, 85 });
      }

      //? Output 

      // largest number in given array is : 85

}
