public class SelectionSort {

      public static void selectionSort(Integer arr[]){   //... n square
            for (int i = 0; i < arr.length; i++) {
                  int minPos = i;
                  for(int j = i+1; j<arr.length; j++){
                        if(arr[minPos] > arr[j]){   //increasing order ...< ---for decreasing order...
                              minPos=j;
                        }
                  }
                  // swap...
                  int temp = arr[minPos];
                  arr[minPos] = arr[i];
                  arr[i] = temp;
            }
            JavaSorting.printArr(arr);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            selectionSort(new Integer[] {5, 84, 62, 1001, 22});
      }

      //? Output 
      // 1. 
      //    5 22 62 84 1001 
      
      
}
