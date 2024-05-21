import java.util.Stack;

public class NextGreater {
      public static void nextGreater() {
            int arr[] = { 6, 8, 0, 1, 3 };
            Stack<Integer> s = new Stack<>();
            int nextGreater[] = new int[arr.length];

            for (int i = arr.length - 1; i >= 0; i--) {
                  // 1 while
                  while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                        s.pop();
                  }

                  // 2 if-else
                  if (s.isEmpty()) {
                        nextGreater[i] = -1;
                  } else {
                        nextGreater[i] = arr[s.peek()];
                  }

                  // 3 push in stack
                  s.push(i);
            }

            // print nextGreater
            for (int i = 0; i < nextGreater.length; i++) {
                  System.out.print(nextGreater[i] + " ");
            }
            System.out.println();

            // more que
            // next greater right int i = arr.length-1; i >=0 ; i--
            // next greater left int i = 0; i <arr.length ; i++
            // next smaller left int i = 0; i <arr.length ; i++ && arr[s.peek()] >= arr[i]
            // next smaller right int i = arr.length-1; i >=0 ; i-- && arr[s.peek()] >=
            // arr[i]
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            nextGreater();
      }

      // ? Output
      //  1.
      //     8 -1 1 3 -1 

}
