import java.util.*;

public class DequeByStack {
      // Stack using Deque...
      static class StackDeque {
            Deque<Integer> deque = new LinkedList<>();

            // push... 
            public void push(int data){
                  deque.addLast(data);
            }

            // pop...
            public int pop(){
                  return deque.removeLast();
            }

            // peek...
            public int peek(){
                  return deque.getLast();
            }
      }

      // call...
      public static void stackDequeCall(){
            System.out.println("Stack by using Deque...");
            StackDeque s = new StackDeque();
            s.push(10);
            s.push(12);
            s.push(15);

            for (int i = 1; i < 4; i++) {
                  System.out.println(i + " peek is --> " + s.peek());
                  s.pop();
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            stackDequeCall();
      }

      // ? Output
      //  1.
      //      Stack by using Deque...
      //      1 peek is --> 15
      //      2 peek is --> 12
      //      3 peek is --> 10
}
