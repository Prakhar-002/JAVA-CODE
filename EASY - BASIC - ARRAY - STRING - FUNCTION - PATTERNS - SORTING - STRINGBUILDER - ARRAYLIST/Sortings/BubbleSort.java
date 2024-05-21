public class BubbleSort {

      public static void bubbleSort(Integer arr[]){   //... n square
            for (int turn = 0; turn < arr.length; turn++) {
                  for (int j = 0; j < arr.length-1-turn; j++) {
                        if(arr[j] > arr[j+1]){
                              //swap...
                              int temp = arr[j];
                              arr[j] = arr[j+1];
                              arr[j+1] = temp;
                        }
                  }
            }
            JavaSorting.printArr(arr);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            bubbleSort(new Integer[] {5, 8, 62, 10, 22});
      }

      //? Output 
      // 1. 
      //     5 8 10 22 62
      
}
