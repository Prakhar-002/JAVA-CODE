import java.util.PriorityQueue;

public class WeakSoldiersRow {

      // weakest soldier...
      // We are given an mxn binary matrix of I's (soldiers) and O's (civilians). The
      // soldiers are
      // positioned in front of the civilians. That is, all the I's will appear to the
      // left of all the 0's
      // in each row.
      // A row i is weaker than a row j if one of the following is true:
      // • The number of soldiers in row i is less than the number of soldiers in row
      // j.
      // • Both rows have the same number of soldiers and i < j.
      // Find the K weakest rows.
      static class Row implements Comparable<Row> {
            int soldiers;
            int idx;

            public Row(int soldier, int idx) {
                  this.soldiers = soldier;
                  this.idx = idx;
            }

            @Override
            public int compareTo(Row r) {
                  if (this.soldiers == r.soldiers) { // if soldiers are same then compare on idx value
                        return this.idx - r.idx;
                  } else {
                        return this.soldiers - r.soldiers; // else compare count of soldiers...
                  }
            }
      }

      public static void weakSoldiersRow() {
            int army[][] = {
                        { 1, 0, 0, 0 },
                        { 1, 1, 1, 1 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 }
            };
            int k = 2;

            PriorityQueue<Row> pq = new PriorityQueue<>();

            for (int i = 0; i < army.length; i++) {
                  int count = 0;
                  for (int j = 0; j < army[0].length; j++) {
                        count += army[i][j] == 1 ? 1 : 0;
                  }
                  pq.add(new Row(count, i));
            }

            // print...
            for (int i = 0; i < k; i++) {
                  System.out.println("ROW --> " + pq.remove().idx);
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            weakSoldiersRow();
      }

      // ? Output
      // 1.
      //      ROW --> 0
      //      ROW --> 2
}
