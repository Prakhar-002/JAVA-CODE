import java.util.*;
public class JavaQueueLinkedList {
      static class Node {
            int data;
            Node next;

            Node(int data) {
                  this.data = data;
                  this.next = null;
            }
      }

//---------------------------------------------------------------------------------------
      static class QueueLL {
            public static Node head = null;
            public static Node tail = null;

            // is empty...
            public boolean isEmpty() {
                  return head == null && tail == null;
            }

            //add...
            public void add(int data){
                  Node newNode = new Node(data);
                  // base condition
                  if( head == null){
                        head = tail = newNode;
                        return;
                  }

                  tail.next = newNode;
                  tail = newNode;
            }

            // remove...
            public int remove(){
                  if(isEmpty()){
                        System.out.println("Queue is empty please enter some node data first");
                        return -1;
                  }

                  int front = head.data;
                  if (tail == head) {
                        tail = head = null;
                  }else{
                        head = head.next;
                  }
                  return front;
            }

            // peek...
            public int peek(){
                  if(isEmpty()){
                        System.out.println("Queue is empty");
                        return -1;
                  }

                  return head.data;
            }
      }

      // queue ll call...
      public static void queueCall(){
            QueueLL ql = new QueueLL();
            ql.add(10);
            ql.add(20);
            ql.add(75);

            while (!ql.isEmpty()) {
                  System.out.println(ql.peek());
                  ql.remove();
            }
      }

//-----------------------------------------------------------------------------
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

//-----------------------------------------------------------------------------------------
      static class QueueByTwoStack{
            static Stack<Integer> s1 = new Stack<>();
            static Stack<Integer> s2 = new Stack<>();

            // is empty 
            public boolean isEmpty(){
                  return s1.isEmpty();
            }

            // add ...O(n)
            public void add(int data){
                  // copying 1st stack to 2nd...
                  while(!s1.isEmpty()){
                        s2.push(s1.pop());
                  }

                  // add new data tp stack 1...
                  s1.push(data);

                  // again store 2nd stack to 1st stack...
                  while (!s2.isEmpty()) {
                        s1.push(s2.pop());
                  }
            }

            // remove  ...O(1)...
            public int remove(){
                  if (s1.isEmpty()) {
                        System.out.println("Queue is empty...");
                        return -1;
                  }

                  return s1.pop();
            }

            // peek  ...O(1)...
            public int peek(){
                  if (s1.isEmpty()) {
                        System.out.println("Queue is empty...");
                        return -1;
                  }

                  return s1.peek();
            }
      }

      public static void queueByTwoStackCall(){
            QueueByTwoStack q = new QueueByTwoStack();
            q.add(10);
            q.add(75);
            q.add(780);

            while (!q.isEmpty()) {
                  System.out.println(q.peek());
                  q.remove();
            }
      }

//------------------------------------------------------------------------------------------
      static class StackByTwoQueue{
            static Queue<Integer> q1 = new LinkedList<>();
            static Queue<Integer> q2 = new LinkedList<>();

            // is empty
            public boolean isEmpty(){
                  return q1.isEmpty() && q2.isEmpty();
            }

            // add
            public void push(int data){
                  if (!q1.isEmpty()) {
                        q1.add(data);
                  }else{
                        q2.add(data);
                  }
            }

            // pop...
            public int pop(){
                  if (isEmpty()) {
                        System.out.println("Stack is empty...");
                        return -1;
                  }

                  int top = -1;

                  // case 1 
                  if (!q1.isEmpty()) {
                        while (!q1.isEmpty()) {
                              top = q1.remove();
                              if(q1.isEmpty()){
                                    break;
                              }
                              q2.add(top);
                        }
                  }else{
                        while (!q2.isEmpty()) {
                              top = q2.remove();
                              if(q2.isEmpty()){
                                    break;
                              }
                              q1.add(top);
                        }
                  }
                  return top;
            }

            // peek...
            public int peek(){
                  if (isEmpty()) {
                        System.out.println("Stack is empty...");
                        return -1;
                  }

                  int top = -1;

                  // case 1 
                  if (!q1.isEmpty()) {
                        while (!q1.isEmpty()) {
                              top = q1.remove();
                              q2.add(top);
                        }
                  }else{
                        while (!q2.isEmpty()) {
                              top = q2.remove();
                              q1.add(top);
                        }
                  }
                  return top;
            }
      }

      public static void StackByTwoQueueCall(){
            StackByTwoQueue s = new StackByTwoQueue();
            s.push(10);
            s.push(45);
            s.push(410);

            while (!s.isEmpty()) {
                  System.out.println(s.peek());
                  s.pop();
            }
      }

      public static void main(String[] args) {
            // 1...queueCall();
            // 2...queueJCF();
            // 3...queueByTwoStackCall();
            // 4...StackByTwoQueueCall();
      }
}
