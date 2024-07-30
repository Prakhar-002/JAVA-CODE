import java.util.PriorityQueue;

public class MaxCarsNearest {

      // max cars nearest...
      static class Point implements Comparable<Point> {
            int x;
            int y;
            int distSq;
            int idx;

            public Point(int x, int y, int distSq, int idx) {
                  this.x = x;
                  this.y = y;
                  this.distSq = distSq;
                  this.idx = idx;
            }

            @Override
            public int compareTo(Point p) {
                  return this.distSq - p.distSq;
            }
      }

      public static void maxCarsNearest() {
            int ptn[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } }; // cars locations...
            int k = 2; // numbers of cars...
            PriorityQueue<Point> pq = new PriorityQueue<>();

            for (int i = 0; i < ptn.length; i++) {
                  int distSq = ptn[i][0] * ptn[i][0] + ptn[i][1] * ptn[i][1];
                  pq.add(new Point(ptn[i][0], ptn[i][1], distSq, i));
            }

            // nearest cars...
            for (int i = 0; i < k; i++) {
                  System.out.println("Car number - " + pq.remove().idx);
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            maxCarsNearest();
      }

      // ? Output
      // 1.
      //    Car number - 0
      //    Car number - 2
}
