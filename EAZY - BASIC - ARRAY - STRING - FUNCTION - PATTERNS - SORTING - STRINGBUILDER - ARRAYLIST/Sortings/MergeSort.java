public class MergeSort {

      //? merge sort ...  // time complexity is O(n log n); // space complexity is O(n)
      // This is depth first concept... 
      public static void mergeSort(Integer arr[], int Si ,int Ei){
            //base case 
            if(Si >= Ei){
                  return;
            }
            //kam
            int mid = Si +(Ei - Si)/2; // (Si + Ei)/2
            mergeSort(arr, Si, mid);  // left part will sort
            mergeSort(arr, mid+1, Ei);// right part will sort
            merge(arr, Si, mid, Ei);
      }

      // This part or(function) will merge all number ... 
      public static void merge(Integer arr[], int si,int mid ,int ei){
            int temp[] = new int[ei - si +1]; // new array of same length
            // iterators ...
            int i = si ;// iterator for left part
            int j = mid+1 ;// iterator for right part 
            int k = 0;   // iterator for temp 

            while( i <= mid && j <=ei){
                  if(arr[i] < arr [j]){
                        temp[k] = arr[i];
                        i++;
                  }else{
                        temp[k] = arr[j];
                        j++;
                  }
                  k++;
            }
            // remaining left part elements... 
            while(i <= mid){
                  temp[k++] = arr[i++];
            }
            // remaining right part elements...
            while( j<= ei){
                  temp[k++] = arr[j++];
            }
            // copy temp into array ...
            for(k=0 , i=si; k <temp.length; i++,k++){
                  arr[i] = temp[k];
            }

      }
      // merge sort calling ...
      public static void mergeSortCall(Integer arr[]){
            mergeSort(arr,0,arr.length-1);
            JavaSorting.printArr(arr);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            mergeSortCall(new Integer[] {500, 410, 62, 10, 22});
      }

      //? Output 
      // 1. 
      //     10 22 62 410 500 
      
}
