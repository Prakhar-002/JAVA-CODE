import java.util.ArrayList;

public class WaterContainer {

      // brute force approach ...O(n^2)
      public static int containWaterBrute(ArrayList<Integer> height) {
            int maxWater = 0;
            for (int i = 0; i < height.size(); i++) {
                  for (int j = i + 1; j < height.size(); j++) {
                        int ht = Math.min(height.get(i), height.get(j));
                        int width = j - i;
                        int curWater = ht * width;
                        maxWater = Math.max(maxWater, curWater);
                  }
            }
            return maxWater;
      }// output 49

      // two pointer approach...O(n)

      public static int waterContain(ArrayList<Integer> height) {
            int maxWater = 0;
            int lp = 0;
            int rp = height.size() - 1;
            while (lp < rp) {
                  // cur = ht*width
                  int curWater = (rp - lp) * Math.min(height.get(rp), height.get(lp));
                  maxWater = Math.max(maxWater, curWater);
                  // update ptr ... move the smaller one ... area control by small height building
                  if (height.get(lp) < height.get(rp)) {
                        lp++;
                  } else {
                        rp--;
                  }
            }
            return maxWater;
      }// output 49

      public static void containWaterCall() {
            ArrayList<Integer> height = new ArrayList<>();
            height.add(1);
            height.add(8);
            height.add(6);
            height.add(2);
            height.add(5);
            height.add(4);
            height.add(8);
            height.add(3);
            height.add(7);

            // System.out.println(containWaterBrute(height));
            System.out.println(waterContain(height));
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            containWaterCall();
      }
}
