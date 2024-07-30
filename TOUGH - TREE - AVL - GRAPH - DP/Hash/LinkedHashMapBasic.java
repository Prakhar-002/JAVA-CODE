import java.util.LinkedHashMap;

public class LinkedHashMapBasic {

      // linked HashMap ...order of adding is as we wright...
      // we use doubly linked list in linkedHashMap for maintaining the order...
      public static void LinkedHashMap() {
            LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
            lhm.put("India", 1000);
            lhm.put("USA", 200);
            lhm.put("China", 500);
            lhm.put("Indonesia", 150);
            lhm.put("Leo", 501);

            System.out.println(lhm);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            LinkedHashMap();
      }

      //? Output 
      // 1. 
      //    {India=1000, USA=200, China=500, Indonesia=150, Leo=501}
}
