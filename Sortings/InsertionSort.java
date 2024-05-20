public class InsertionSort {

      public static void insertionSort(Integer arr[]){    //... n square
            for (int i = 1; i < arr.length; i++) {
                  int cur = arr[i];
                  int prev = i-1;
                  // finding pos to insert
                  while(prev >= 0 && arr[prev] > cur){
                        arr[prev+1] = arr[prev];
                        prev--;
                  }
                  // inserting... 
                  arr[prev+1] = cur;
            }
            JavaSorting.printArr(arr);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            insertionSort(new Integer[] {510, 888, 62, 10, 22});
      }

      //? Output 
      // 1. 
      //     10 22 62 510 888 
      
      
}
