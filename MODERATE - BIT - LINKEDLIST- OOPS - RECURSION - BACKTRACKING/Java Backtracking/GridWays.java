import java.util.Scanner;

public class GridWays {
      
      // grid ways problem... time complexity is 2 ki power n*m ...very bad
      // (n-1 + m-1)! / (n-1)! * (m-1)! formula to found ans...
      // if we apply formula them complexity will be O(n)
      public static int gridWays(int i, int j, int n, int m) {
            if (i == n - 1 && j == m - 1) {
                  return 1;
            } else if (i == n || j == m) {
                  return 0;
            }

            int way1 = gridWays(i + 1, j, n, m);
            int way2 = gridWays(i, j + 1, n, m);
            return way1 + way2;
      }

      public static void gridWaysCall() {
            int n, m;
            System.out.println("Enter the grid dimension...");
            Scanner Joe = new Scanner(System.in);
            n = Joe.nextInt();
            m = Joe.nextInt();
            int ways = gridWays(0, 0, n, m);
            System.out.println("Total ways to get to target is : " + ways);
            Joe.close();
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            gridWaysCall();
      }

      // ? Output
      //  1. 
      //     Enter the grid dimension...
      //     3
      //     4
      //     Total ways to get to target is : 10 
}
