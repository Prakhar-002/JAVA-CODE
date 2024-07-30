import java.util.PriorityQueue;

public class ConnectRopes {

      // connect n ropes with minimum cast... cast is equal to length of ropes...
      public static void connectRopes() {
            int arr[] = { 2, 3, 3, 4, 6 };

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < arr.length; i++) {
                  pq.add(arr[i]);
            }

            int cost = 0;
            while (pq.size() > 1) {
                  int min1 = pq.remove(); // first min...
                  int min2 = pq.remove(); // second min...
                  cost += min1 + min2; // cast is sum of ropes length...
                  pq.add(min1 + min2); // again add the some of rope combined before...
            }

            System.out.println("Cost of connecting N ropes is : " + cost);
            // logic...(2, 3, 3, 4, 6)-- 2+3 = 5 (3, 4, 5, 6) -- 3+4 =7 (5, 6, 7)-- 5+6 = 11
            // (7 ,11) -- 18
            // cost will be ...5+7+11+18 == 41
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            connectRopes();
      }

      // ? Output
      // 1.
      //    Cost of connecting N ropes is : 41
}
