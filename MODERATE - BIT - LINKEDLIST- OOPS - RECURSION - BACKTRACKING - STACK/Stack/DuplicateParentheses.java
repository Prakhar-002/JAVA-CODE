import java.util.Stack;

public class DuplicateParentheses {
      public static void duplicateParentheses(String str) { // O(n)
            Stack<Character> s = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                  char ch = str.charAt(i);

                  // closing tag
                  if (ch == ')') {
                        int count = 0;
                        while (s.peek() != '(') { // !str.isEmpty() -> not necessary
                              count++;
                              s.pop();
                        }

                        if (count < 1) { // duplicate condition
                              System.out.println(str + " -- It is a duplicate parentheses ");
                              return;
                        } else {
                              s.pop(); // opening pair remove
                        }
                  } else {
                        // opening condition
                        s.push(ch);
                  }
            }

            System.out.println(str + " -- It is a not duplicate parentheses ");
      }

      public static void duplicateParenthesesCall() {
            duplicateParentheses("((a+b)+(o-k)())"); // false
            duplicateParentheses("((a+b)+(o-k)+(l-k))"); // true
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            duplicateParenthesesCall();
      }

      // ? Output
      //  1.
      //     ((a+b)+(o-k)()) -- It is a duplicate parentheses 
      //     ((a+b)+(o-k)+(l-k)) -- It is a not duplicate parentheses
}
