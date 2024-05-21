import java.util.Stack;

public class StockStack {

      public static void stockStack(int stock[], int span[]) {
            Stack<Integer> s = new Stack<>();
            span[0] = 1;
            s.push(0);

            for (int i = 1; i < stock.length; i++) {
                  int curPrice = stock[i];
                  while (!s.isEmpty() && curPrice > stock[s.peek()]) {
                        s.pop();
                  }
                  if (s.isEmpty()) {
                        span[i] = i + 1;
                  } else {
                        int prevHeight = s.peek();
                        span[i] = i - prevHeight;
                  }

                  s.push(i);
            }
      }

      public static void stockStackCall() {
            int stock[] = { 100, 80, 60, 70, 80, 85, 100 };
            int span[] = new int[stock.length];
            stockStack(stock, span);

            // print the span
            System.out.println("Span data...");
            for (int i = 0; i < span.length; i++) {
                  System.out.print(span[i] + " ");
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            stockStackCall();
      }

      // ? Output
      //  1.
      //     Span data...
      //     1 1 1 2 3 5 6
}
