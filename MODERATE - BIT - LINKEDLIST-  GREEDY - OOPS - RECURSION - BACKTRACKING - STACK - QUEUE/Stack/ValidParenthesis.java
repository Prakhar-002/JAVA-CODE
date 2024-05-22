import java.util.Stack;

public class ValidParenthesis {
      public static boolean validParenthesis(String str) { // O(n)
            Stack<Character> s = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                  char ch = str.charAt(i);

                  // opening
                  if (ch == '(' || ch == '{' || ch == '[') {
                        s.push(ch);
                  } else {
                        // closing
                        if (s.isEmpty()) {
                              return false;
                        }

                        if ((s.peek() == '(' && ch == ')') || // ()
                                    (s.peek() == '{' && ch == '}') || // {}
                                    (s.peek() == '[' && ch == ']')) { // []
                              s.pop();
                        } else {
                              return false;
                        }
                  }
            }

            if (s.isEmpty()) {
                  return true;
            } else {
                  return false;
            }
      }

      public static void validParenthesisCall() {
            boolean ans = validParenthesis("({}(){})");
            if (ans) {
                  System.out.println("string is valid parenthesis...");
            } else {
                  System.out.println("string is not a valid parenthesis...");
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            validParenthesisCall();
      }

      // ? Output
      //  1.
      //     string is valid parenthesis...
}
