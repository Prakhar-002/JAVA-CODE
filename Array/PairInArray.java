public class PairInArray {

      public static void pairs() {
            int arr[] = { 2, 4, 6, 8, 10, 12, 16, 18 };
            for (int i = 0; i < arr.length; i++) {
                  for (int j = i + 1; j < arr.length; j++) {
                        System.out.print("(" + arr[i] + "," + arr[j] + ")" + " ");
                  }
                  System.out.println();
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            pairs();
      }

      //? Output 
      //   1. 
      //      (2,4) (2,6) (2,8) (2,10) (2,12) (2,16) (2,18) 
      //      (4,6) (4,8) (4,10) (4,12) (4,16) (4,18) 
      //      (6,8) (6,10) (6,12) (6,16) (6,18) 
      //      (8,10) (8,12) (8,16) (8,18)
      //      (10,12) (10,16) (10,18)
      //      (12,16) (12,18)
      //      (16,18)

}
