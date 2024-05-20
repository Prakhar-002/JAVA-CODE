public class ModifiedBubble {
      // modified bubble sort 

      public static void modifiedBubbleSort(Integer arr[]){   //... n square
            for (int turn = 0; turn < arr.length; turn++) {
                  int swap = 0;
                  for (int j = 0; j < arr.length-1-turn; j++) {
                        if(arr[j] > arr[j+1]){
                              //swap...
                              int temp = arr[j];
                              arr[j] = arr[j+1];
                              arr[j+1] = temp;
                              swap++;
                        }
                  }
                  if(swap == 0){
                        break;
                  }
            }
            JavaSorting.printArr(arr);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            modifiedBubbleSort(new Integer[] {85, 28, 62, 70, 22});
      }

      //? Output 
      // 1. 
      //     22 28 62 70 85 
      
}


