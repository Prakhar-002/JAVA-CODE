public class CountingSort {

      public static void countingSort(Integer arr[]){
            // find largest number in array...
            int largest = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                  largest = Math.max(largest, arr[i]);
            }

            // making a new array name count ...

            int count[] = new int[largest+1];
            for (int i = 0; i < arr.length; i++) {
                  count[arr[i]]++;
            }

            // sorting...
            int j = 0;
            for(int i = 0; i<count.length; i++){
                  while(count[i] > 0){
                        arr[j] = i;
                        j++;
                        count[i]--;
                  }
            }
            JavaSorting.printArr(arr);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            countingSort(new Integer[] { 10, 85, 45, 22, 30});
      }

      //? Output 
      // 1. 
      //     10 22 30 45 85

}
