import java.util.Stack;

public class ReverseStack {

      public static void reverseStack(Stack<Integer> s) {
            if (s.isEmpty()) {
                  return;
            }

            int top = s.pop();
            reverseStack(s);
            PushBottom.pushBottom(s, top);
      }

      public static void reverseStackCall() {
            Stack<Integer> s = new Stack<>(); // --> in build Stack
            System.out.println("Before");
            s.push(10);
            s.push(20);
            s.push(30);

            while (!s.isEmpty()) {
                  System.out.println(s.pop());
            }

            s.push(10);
            s.push(20);
            s.push(30);

            reverseStack(s);
            System.out.println("After");
            while (!s.isEmpty()) {
                  System.out.println(s.pop());
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            reverseStackCall();
      }

      // ? Output
      //  1.
      //     Before
      //     30
      //     20
      //     10
      //     After
      //     10
      //     20
      //     30
}
