import java.util.*;
public class JavaDeque_DoubleEndedQueue{

      public static void deque(){
            System.out.println("Deque from JCF in java...");
            Deque<Integer> deque = new LinkedList<>();

            // adding...
            deque.addFirst(12);
            deque.addFirst(121);
            deque.addLast(85);
            deque.addLast(45);
            System.out.println(deque);

            // remove...
            System.out.println("removeFirst--> " + deque.removeFirst());
            System.out.println("removeLast--> " + deque.removeLast());

            // getting...
            System.out.println("getFirst--> " + deque.getFirst());
            System.out.println("getLast--> " + deque.getLast());

            System.out.println(deque);
      }

//-----------------------------------------------------------------------------------------------

      public static void main(String[] args) {
            System.out.println("Welcome to the world of Deque...");
            deque();
      }

      // ? Output
      //  1.
      //     Welcome to the world of Deque...
      //     Deque from JCF in java...
      //     [121, 12, 85, 45]
      //     removeFirst--> 121
      //     removeLast--> 45
      //     getFirst--> 12
      //     getLast--> 85
      //     [12, 85]
}