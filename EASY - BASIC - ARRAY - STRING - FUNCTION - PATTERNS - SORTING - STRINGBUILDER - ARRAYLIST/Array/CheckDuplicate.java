public class CheckDuplicate {

      public static void numRp(int array[], int num) {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                  if (num == array[i]) {
                        count++;
                  }
            }
            System.out.println("Number " + num + " repeating " + count + " times...");
      }

      public static void checkDouble() {
            int arr[] = { 4, 6, 0, 9, 10, -8, -8, -10, 5, -8, 8 };
            for (int i = 0; i < arr.length; i++) {
                  int num = arr[i];
                  // arr[i] = Integer.MIN_VALUE;
                  for (int j = i + 1; j < arr.length; j++) {
                        if (num == arr[j]) {
                              // System.out.println("number " + num + " is repeating ...");
                              numRp(arr, num);
                              System.exit(0);
                        }
                  }
            }
            System.out.println("no number is repeating...");
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            checkDouble();
      }

      //? Output 
      // 1. 
      //     Number -8 repeating 3 times...
      
}
