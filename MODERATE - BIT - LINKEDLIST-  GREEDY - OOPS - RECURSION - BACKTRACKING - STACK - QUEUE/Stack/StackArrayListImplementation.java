import java.util.ArrayList;

public class StackArrayListImplementation {

      static class Stack {
            // initialize an ArrayList
            static ArrayList<Integer> list = new ArrayList<>();

            // A function will check
            public boolean isEmpty() {
                  return list.size() == 0;
            }

            // push
            public void push(int data) {
                  list.add(data);
            }

            // pop
            public int pop() {
                  if (isEmpty()) {
                        return -1;
                  }
                  int top = list.get(list.size() - 1);
                  list.remove(list.size() - 1);
                  return top;
            }

            // peek
            public int peek() {
                  if (isEmpty()) {
                        return -1;
                  }
                  return list.get(list.size() - 1);
            }
      }

      public static void main(String[] args) {
            System.out.println("Welcome to the world of STACK...");
            Stack s = new Stack();

            s.push(10);
            s.push(50);
            s.push(40);

            while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
            }
      }

      //? Output 
      //  1.
      //     40
      //     50
      //     10
}
