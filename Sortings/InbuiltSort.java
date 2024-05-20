import java.util.Arrays;
import java.util.Collections;

public class InbuiltSort {
      

      //! inbuilt sort in java ...
      // we have to import arrays class by ... import java.util.Arrays;
      // then we call... Arrays.sort(pass array as an args)...
      // or you can pass starting and ending i... as ...Arrays.sort(arr,Si,Ei)
      // time complexity is o(n log n);


      //! If we want *reverse* order then we use collections...
      // we import.java.util.Collections...
      // Arrays.sort(arr,Collections.reversOrder())
      // Arrays.sort(arr,Si,Ei,Collections.reversOrder()) 
      // Collection  work only with class variable Integer... 


      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            Integer arr[] = { 52, 1, 56, 87, 100 };
            Arrays.sort(arr);
            JavaSorting.printArr(arr);
            Arrays.sort(arr, Collections.reverseOrder());
            JavaSorting.printArr(arr);
      }

      //? Output 
      // 1. 
      //     1 52 56 87 100

      // 2. 
      //     100 87 56 52 1

}
