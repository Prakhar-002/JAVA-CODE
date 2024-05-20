public class QuickSort {

      //quick sort ... in avg case time complexity is O(n log n) and space complexity is O(1)
      // in worst case it's time Complexity is O(n square)
      
      public static void quickSort(Integer arr[], int si, int ei){
            if(si >= ei){
                  return;
            }
            // partition for left and store it in pivot
            // last element
            int pivotInx=partition(arr,si,ei);
            quickSort(arr, si, pivotInx-1);  // left unsorted path ...
            quickSort(arr, pivotInx + 1, ei); // right unsorted part ...
            
      }
      // making a partition function for array to divide array in to part ...
      // before pivot and after pivot and set pivot in it's correct position ...
      // return the index of pivot
      public static int partition(Integer arr[],int si ,int ei){
            int pivot = arr[ei]; // last element as a pivot ...
            int i = si-1;       // taking i as -1...

            for( int j = si; j < ei; j++){
                  if(arr[j] <= pivot){
                        i++;
                        // swap 
                        int temp = arr[j];
                        arr[j] = arr[i] ;
                        arr[i] = temp;
                  }
            }
            i++;
            int temp = pivot;
            arr[ei] = arr[i];
            arr[i] = temp;
            return i;
      } 

      // quick sort calling
      public static void quickSortCall(Integer arr[]){
            quickSort(arr, 0, arr.length-1);
            JavaSorting.printArr(arr);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            quickSortCall(new Integer[] {51, 1208, 7462, 10, 22});
      }

      //? Output 
      // 1. 
      //     0 22 51 1208 7462 
      
      
}
