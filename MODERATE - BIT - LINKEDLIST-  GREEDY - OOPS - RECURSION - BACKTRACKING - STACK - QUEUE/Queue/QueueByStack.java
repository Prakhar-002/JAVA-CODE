import java.util.Stack;

public class QueueByStack {
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

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            queueByTwoStackCall();
      }

      // ? Output
      //  1.
      //     10
      //     20
      //     30
      //     14
}
