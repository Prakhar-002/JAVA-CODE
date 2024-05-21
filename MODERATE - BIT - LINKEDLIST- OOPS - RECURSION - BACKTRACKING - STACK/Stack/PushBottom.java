import java.util.Stack;

public class PushBottom {

      public static void pushBottom(Stack<Integer> s, int data) {
            if (s.isEmpty()) {
                  s.push(data);
                  return;
            }

            int top = s.pop();
            pushBottom(s, data);
            s.push(top);
      }

      public static void pushBottomCall() {
            Stack<Integer> s = new Stack<>(); // --> in build Stack
            s.push(10);
            s.push(20);
            s.push(30);

            pushBottom(s, 50);

            StackLinkedListImplementation.printStack(s);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            pushBottomCall();
      }

      // ? Output
      //  1.
      //     30
      //     20
      //     10
      //     50
}
