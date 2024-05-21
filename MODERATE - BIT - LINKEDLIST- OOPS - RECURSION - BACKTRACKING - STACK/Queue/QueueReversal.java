import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
      public static void queueReversal(Queue<Integer> q){
            Stack <Integer> s = new Stack<>();

            while (!q.isEmpty()) {
                  s.push(q.remove());
            }

            while (!s.isEmpty()) {
                  q.add(s.pop());
            }
      }

      // call...
      public static void queueReversalCall(){
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < 11; i++) {
                  q.add(i);
            }
            System.out.println("Before call --> " + q);
            queueReversal(q);
            System.out.println();
            System.out.println("After call --> " + q);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            queueReversalCall();
      }

      // ? Output
      //  1.
      //     Before call --> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
      //     
      //     
      //     After call --> [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
}
