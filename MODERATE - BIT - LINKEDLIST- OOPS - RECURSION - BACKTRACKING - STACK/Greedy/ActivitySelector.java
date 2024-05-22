import java.util.ArrayList;

public class ActivitySelector {

      public static void activitySelector() {  //O(n)
            int start[] = { 1, 3, 0, 5, 8, 5 };
            int end[] = { 2, 4, 6, 7, 9, 9 };

            // end time bases sort...
            int maxAct = 0;
            ArrayList<Integer> ans = new ArrayList<>();

            maxAct++;
            ans.add(0);
            int lastEnd = end[0];

            for (int i = 0; i < end.length; i++) {
                  if (start[i] >= lastEnd) {
                        maxAct++;
                        lastEnd = end[i];
                        ans.add(i);
                  }
            }

            System.out.println("Maximum activities : " + maxAct);
            for (int i = 0; i < ans.size(); i++) {
                  System.out.print("A" + ans.get(i) + " ");
            }
            System.out.println();
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            activitySelector();
      }

      // ? Output
      //  1.
      //     Maximum activities : 4
      //     A0 A1 A3 A4
}
