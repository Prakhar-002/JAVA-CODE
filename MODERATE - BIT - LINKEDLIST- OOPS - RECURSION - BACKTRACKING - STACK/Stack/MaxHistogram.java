import java.util.Stack;

public class MaxHistogram {

      public static void maxHistogram(int arr[]) { // ...O(n)
            int nsr[] = new int[arr.length];
            int nsl[] = new int[arr.length];
            int maxArea = 0;
            // next smaller right ...O(n)
            Stack<Integer> s = new Stack<>();
            for (int i = arr.length - 1; i >= 0; i--) {
                  if (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                        s.pop();
                  }
                  if (s.isEmpty()) {
                        nsr[i] = arr.length;
                  } else {
                        nsr[i] = s.peek();
                  }
                  s.push(i);
            }
            // next smaller left ...O(n)
            s = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                  if (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                        s.pop();
                  }
                  if (s.isEmpty()) {
                        nsl[i] = -1;
                  } else {
                        nsl[i] = s.peek();
                  }
                  s.push(i);
            }
            // current area max area = j-i-1 ; nsr[i] - nsl[i] -1
            for (int i = 0; i < arr.length; i++) { // ...O(n)
                  int height = arr[i];
                  int width = nsr[i] - nsl[i] - 1;
                  int curArea = height * width;
                  maxArea = Math.max(maxArea, curArea);
            }
            // print
            System.out.println("max histogram area is : " + maxArea);
      }

      public static void maxHistogramCall() {
            int arr[] = { 2, 1, 5, 6, 2, 3 };
            maxHistogram(arr);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            maxHistogramCall();
      }

      // ? Output
      //  1.
      //     max histogram area is : 10
}
