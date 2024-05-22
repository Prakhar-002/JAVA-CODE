import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueByDeque {
      // Queue using Deque...
      static class QueueDeque {
            Deque<Integer> deque = new LinkedList<>();

            // push... 
            public void add(int data){
                  deque.addLast(data);
            }

            // pop...
            public int remove(){
                  return deque.removeFirst();
            }

            // peek...
            public int peek(){
                  return deque.getFirst();
            }
      }

      // call...
      public static void queueDequeCall(){
            System.out.println("Queue by using Deque...");
            QueueDeque q = new QueueDeque();
            q.add(17);
            q.add(1274);
            q.add(41);

            for (int i = 1; i < 4; i++) {
                  System.out.println(i + " peek is --> " + q.peek());
                  q.remove();
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            queueDequeCall();
      }

      // ? Output
      //  1.
      //     Queue by using Deque...
      //     1 peek is --> 17
      //     2 peek is --> 1274
      //     3 peek is --> 41
}
