import java.util.ArrayList;

public class HeapImplementation {

      static class Heap {
            ArrayList<Integer> arr = new ArrayList<>();

            // Add function...
            public void add(int data) { // O( log n)
                  arr.add(data); // add at last integer... O(1)

                  int childIdx = arr.size() - 1;
                  int parentIdx = (childIdx - 1) / 2; // O(1)

                  while (arr.get(childIdx) < arr.get(parentIdx)) { // O(log n)
                        // while(arr.get(childIdx) > arr.get(parentIdx)){ // for max heap...
                        // swap...
                        int temp = arr.get(childIdx);
                        arr.set(childIdx, arr.get(parentIdx));
                        arr.set(parentIdx, temp);

                        childIdx = parentIdx;
                        parentIdx = (childIdx - 1) / 2;
                  }
            }

            public int peek() {
                  return arr.get(0);
            }

            private void heapIfy(int i) { // O(log n)
                  int leftIdx = 2 * i + 1;
                  int rightIdx = 2 * i + 2;
                  int minIdx = i;
                  // int maxIdx = i ; // for max heap change the name everywhere...

                  // If left child is small...
                  if (leftIdx < arr.size() && arr.get(minIdx) > arr.get(leftIdx)) {
                        // if (leftIdx < arr.size() && arr.get(minIdx) < arr.get(leftIdx)) { // for max
                        // heap...
                        minIdx = leftIdx;
                  }

                  // If right child is small...
                  if (rightIdx < arr.size() && arr.get(minIdx) > arr.get(rightIdx)) {
                        // if (rightIdx < arr.size() && arr.get(minIdx) < arr.get(rightIdx)) { // for
                        // max heap...
                        minIdx = rightIdx;
                  }

                  // change...
                  if (minIdx != i) {
                        // swap with the smallerOne...
                        int temp = arr.get(i);
                        arr.set(i, arr.get(minIdx));
                        arr.set(minIdx, temp);

                        // if does not set proper then call for minIdx...
                        heapIfy(minIdx);
                  }
            }

            public int remove() {
                  int data = arr.get(0); // min value will delete...

                  // step -1 swap first and last
                  int temp = arr.get(0);
                  arr.set(0, arr.get(arr.size() - 1));
                  arr.set(arr.size() - 1, temp);

                  // delete the last node from arraylist
                  arr.remove(arr.size() - 1);

                  // heapIfy ... it will correct the heap...
                  heapIfy(0);
                  return data;
            }

            public boolean isEmpty() {
                  return arr.size() == 0;
            }
      }

      public static void heapCall() {
            Heap h = new Heap();
            h.add(12);
            h.add(4);
            h.add(41);
            h.add(1);

            while (!h.isEmpty()) {
                  System.out.print(h.peek() + " ");
                  h.remove();
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            heapCall();
      }

      // ? Output
      // 1.
      //    1 4 12 41 
}
