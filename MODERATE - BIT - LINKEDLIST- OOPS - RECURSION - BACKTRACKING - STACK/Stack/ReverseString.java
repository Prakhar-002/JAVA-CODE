import java.util.Stack;

public class ReverseString {

      public static String reverseString(String str) {
            Stack<Character> s = new Stack<>();
            int idx = 0;
            // copy data into stack
            while (idx < str.length()) {
                  s.push(str.charAt(idx));
                  idx++;
            }

            // new stringBuilder
            StringBuilder result = new StringBuilder();
            // copying the data into the sb
            while (!s.isEmpty()) {
                  result.append(s.pop());
            }

            return result.toString();
      }

      public static void reverseStringCall() {
            System.out.println(reverseString("abcde"));
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            reverseStringCall();
      }

      // ? Output
      //  1.
      //     edcba
}
