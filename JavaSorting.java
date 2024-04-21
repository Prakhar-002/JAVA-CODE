// import java.util.*;
public class JavaSorting {
      

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
            printArr(arr);
      }

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
            printArr(arr);
      }

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
            printArr(arr);
      }

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
            printArr(arr);
      }

      //inbuilt sort in java ...
      // we have to import arrays class by ... import java.util.Arrays;
      // then we call... Arrays.sort(pass array as an args)...
      // or you can pass starting and ending i... as ...Arrays.sort(arr,Si,Ei)
      // time complexity is o(n log n);


      // If we want reverse order then we use collections...
      // we import.java.util.Collections...
      // Arrays.sort(arr,Collections.reversOrder())
      // Arrays.sort(arr,Si,Ei,Collections.reversOrder()) 
      // Collection  work only with class variable Integer... 

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
            printArr(arr);
      }

      //merge sort ...  // time complexity is O(n log n); // space complexity is O(n)
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
            printArr(arr);
      }

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
            printArr(arr);
      }

      // search in rotated array around a pivot ...
      public static int searchRotatedArray(Integer arr[], int target, int si, int ei){
            if(si > ei){
                  return -1;
            }

            // finding our mid value ...
            int mid = si + (ei-si)/2; //(si+ei)/2;

            // target FOUND 
            if(arr[mid] == target){
                  return mid ;
            }

            // on line one L1 
            if(arr[si] <= arr[mid]){
                  // case 'a'
                  if(arr[si] >= target && target <= arr[mid]){
                        return searchRotatedArray(arr, target, si, mid-1);
                  }
                  // case 'b'
                  else{
                        return searchRotatedArray(arr, target, mid+1, ei);
                  }
            }

            // on line 2 ke 
            else{
                  // case 'c'
                  if(target >= arr[mid] && target <= arr[ei]){
                        return searchRotatedArray(arr, target, mid+1, ei);
                  }
                  // case 'd'
                  else{
                        return searchRotatedArray(arr, target, si, mid-1);
                  }
            }
      }


      public static void printArr(Integer arr[]){
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
            System.out.println();
      }

      public static void main(String args[]){
            Integer arr[] = {5,4,8,6,2,9};
            // Arrays.sort(arr,Collections.reverseOrder());
            // Arrays.sort(arr,sI,eI,Collections.reverseOrder()); array, starting Index, ending index, reverse condition...
            // printArr(arr);
            // quickSortCall(arr);
            // int target =0;
            // System.out.println(searchRotatedArray(arr, target, 0, arr.length));
            modifiedBubbleSort(arr);
      }
}

