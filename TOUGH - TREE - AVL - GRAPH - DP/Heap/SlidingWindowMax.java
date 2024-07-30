import java.util.PriorityQueue;

public class SlidingWindowMax {

      // sliding maximum window...
      static class Pair implements Comparable<Pair> {
            int val;
            int idx;

            public Pair(int val, int idx) {
                  this.val = val;
                  this.idx = idx;
            }

            @Override
            public int compareTo(Pair p) {
                  // return this.val - value.val; // ascending order....
                  return p.val - this.val; // descending order...
            }
      }

      public static void slidingWindowMax() { // O(n log k)
            int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
            int k = 3; // window length...

            int res[] = new int[arr.length - k + 1]; // array of n-k+1...

            PriorityQueue<Pair> pq = new PriorityQueue<>();

            // 1st window...
            for (int i = 0; i < k; i++) {
                  pq.add(new Pair(arr[i], i));
            }

            // first max value in first window
            res[0] = pq.peek().val;

            // rest window...
            for (int i = k; i < arr.length; i++) {
                  // delete upTo where the size of window start...
                  while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                        pq.remove();
                  }

                  // add next window value...
                  pq.add(new Pair(arr[i], i));
                  // add next window's max ...
                  res[i - k + 1] = pq.peek().val;
            }

            for (int i = 0; i < res.length; i++) {
                  System.out.print(res[i] + " ");
            }
            System.out.println();
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            slidingWindowMax();
      }

      // ? Output
      // 1.
      //     3 3 5 5 6 7 

}
