import java.util.*;

public class TwoHavesQueue {
      public static void twoHalvesOfAQueue(Queue<Integer> q){  // only even ...
            Queue<Integer> firstHalf = new LinkedList<>();
            int size = q.size();
            // find our first half...
            for (int i = 0; i < size/2; i++) {
                  firstHalf.add(q.remove());
            }

            // we'll add now to our new queue to older queue
            while (!firstHalf.isEmpty()) {
                  q.add(firstHalf.remove());  // add first half to it's tail...
                  q.add(q.remove()); // add 2nd half to it's end...
            }
      }

      /// call...
      public static void twoHalvesOfAQueueCall(){
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < 11; i++) {
                  q.add(i);
            }
            System.out.println("Before call --> " + q);
            System.out.println();
            // call function
            twoHalvesOfAQueue(q);
            System.out.println("After call --> " + q);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            twoHalvesOfAQueueCall();
      }

      // ? Output
      //  1.
      //     Before call --> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
      //     
      //     
      //     After call --> [1, 6, 2, 7, 3, 8, 4, 9, 5, 10]
}
