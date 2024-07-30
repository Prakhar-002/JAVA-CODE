import java.util.TreeMap;

public class TreeMapBasic {

      // ordered by keys... and used red black tree...
      // put remove get --- O( log n)
      public static void TreeMap() {
            TreeMap<String, Integer> tm = new TreeMap<>();
            tm.put("India", 1000);
            tm.put("USA", 200);
            tm.put("China", 500);
            tm.put("Indonesia", 150);
            tm.put("Leo", 501);

            System.out.println(tm);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            TreeMap();
      }

      // ? Output
      // 1.
      //      {China=500, India=1000, Indonesia=150, Leo=501, USA=200}
}
