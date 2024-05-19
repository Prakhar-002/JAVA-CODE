import java.nio.file.Path;

public class ShortestPathFromOrigin {

      public static void shortestPath(String path) {
            float X = 0, Y = 0;
            for (int i = 0; i < path.length(); i++) {
                  if (path.charAt(i) == 'N' || path.charAt(i) == 'n') {
                        Y++;
                  } else if (path.charAt(i) == 'E' || path.charAt(i) == 'e') {
                        X++;
                  } else if (path.charAt(i) == 'S' || path.charAt(i) == 's') {
                        Y--;
                  } else if (path.charAt(i) == 'W' || path.charAt(i) == 'w') {
                        X--;
                  } else {
                        continue;
                  }
            }
            System.out.println("Path from X = " + X + " From Y = " + Y);
            System.out.println("Shortest path is : " + Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2)));
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            shortestPath("NSWWsESSEE");
      }

      // ? Output
      // 1.
      //      Path from X = 1.0 From Y = -3.0
      //      Shortest path is : 3.1622776601683795

}
