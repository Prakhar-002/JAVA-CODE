import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectorNonSorted {

      public static void activitySelectorNonSorted() { // O(n log n)
            int start[] = { 1, 3, 0, 8, 5, 5 };
            int end[] = { 2, 4, 6, 9, 7, 9 };

            // sorting...
            int activities[][] = new int[start.length][3];
            for (int i = 0; i < activities.length; i++) {
                  activities[i][0] = i;
                  activities[i][1] = start[i];
                  activities[i][2] = end[i];
            }

            // we'll short 2-D array by col 2
            // lambda function ->sort form...
            Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // to sort

            // end time bases sort...
            int maxAct = 0;
            ArrayList<Integer> ans = new ArrayList<>();

            maxAct++;
            ans.add(activities[0][0]);
            int lastEnd = activities[0][2];

            for (int i = 0; i < end.length; i++) {
                  if (activities[i][1] >= lastEnd) {
                        maxAct++;
                        lastEnd = activities[i][2];
                        ans.add(activities[i][0]);
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
            activitySelectorNonSorted();
      }

      // ? Output
      // 1.
      // Maximum activities : 4
      // A0 A1 A4 A3
}
