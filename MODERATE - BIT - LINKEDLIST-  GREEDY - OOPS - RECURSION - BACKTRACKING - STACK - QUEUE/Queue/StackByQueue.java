import java.util.LinkedList;
import java.util.Queue;

public class StackByQueue {
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

      public static void stackByTwoQueueCall(){
            StackByTwoQueue s = new StackByTwoQueue();
            s.push(10);
            s.push(45);
            s.push(410);

            while (!s.isEmpty()) {
                  System.out.println(s.peek());
                  s.pop();
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            stackByTwoQueueCall();
      }

      // ? Output
      //  1.
      //     410
      //     45
      //     10
}
