import java.util.*;

public class JavaQueueCollections {
      // queue by java collection frame works...
      public static void queueJCF(){
            // Queue<Integer> q = new LinkedList<>();  // arrayDeque
            Queue<Integer> q = new ArrayDeque<>();
            q.add(10);
            q.add(75);
            q.add(78);

            while (!q.isEmpty()) {
                  System.out.println(q.peek());
                  q.remove();
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            queueJCF();
      }

      // ? Output
      //  1.
      //     10
      //     75
      //     78
}
