public class HeapSort {

      public static void heapIfy(int arr[], int i , int size){  //O(log n)
            int leftIdx = 2*i+1;
            int rightIdx = 2*i+2;
            int maxIdx = i;

            if (leftIdx < size && arr[leftIdx] > arr[maxIdx]) {
            // if (leftIdx < size && arr[leftIdx] < arr[maxIdx]) {   // for descending...
                  maxIdx = leftIdx;
            }

            if (rightIdx < size && arr[rightIdx] > arr[maxIdx]) {
            // if (rightIdx < size && arr[rightIdx] < arr[maxIdx]) {  // for descending...
                  maxIdx = rightIdx;
            }

            if (maxIdx != i) {
                  // swap ...
                  int temp = arr[i];
                  arr[i] = arr[maxIdx];
                  arr[maxIdx] = temp;

                  heapIfy(arr, maxIdx, size);
            }
      }

      public static void heapSort(int arr[]){  //O(n log n)
            // Build maxHeap...
            int n = arr.length;
            for (int i = n/2 ; i >=0 ; i--) {  //O(n log n)
                  heapIfy(arr, i, n);
            }

            // Step - 2 push largest at end...
            for(int i = n-1 ; i >0 ; i--){  //O(n log n)
                  // swap largest-first with last...
                  int temp = arr[0];
                  arr[0] = arr[i];
                  arr[i] = temp;

                  heapIfy(arr, 0, i);  // for variable n and fixed index...(0)
            }
      }

      public static void heapCall(){
            int arr[] ={10, 2, 41, 4, 23};
            heapSort(arr);

            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i]+" ");
            }
            System.out.println();
      } 

      public static void main(String[] args) {
            heapCall();
      }
}
