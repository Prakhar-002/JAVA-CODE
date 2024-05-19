import java.util.*;
public class JavaDeque_DoubleEndedQueue{

      public static void Deque(){
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

//-----------------------------------------------------------------------------------------
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
      public static void StackDequeCall(){
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

//----------------------------------------------------------------------------------------
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
      public static void QueueDequeCall(){
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

//-----------------------------------------------------------------------------------------------

      public static void main(String[] args) {
            System.out.println("Welcome to the world of Deque...");
            // 1...deque();
            // 2...StackDequeCall();
            // 3...QueueDequeCall();
      }
}