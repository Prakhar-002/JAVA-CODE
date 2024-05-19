public class SubArray {

      public static void subArr() {
            int arr[] = { 2, 4, 6, 8, 10 };
            for (int i = 0; i < arr.length; i++) {
                  for (int j = i; j < arr.length; j++) {
                        for (int k = i; k <= j; k++) {
                              System.out.print(arr[k] + " ");
                        }
                        System.out.println();
                  }
                  System.out.println();
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            subArr();
      }

      //? Output 
      //  1. 
      //      2 
      //      2 4
      //      2 4 6
      //      2 4 6 8
      //      2 4 6 8 10

      //      4
      //      4 6
      //      4 6 8
      //      4 6 8 10

      //      6
      //      6 8
      //      6 8 10

      //      8
      //      8 10

      //      10

}
