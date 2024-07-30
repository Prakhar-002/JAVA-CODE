import java.util.HashMap;
import java.util.Set;

public class HashMapBasic {

      public static void hashMap() {
            HashMap<String, Integer> hm = new HashMap<>();

            // put O(1)
            hm.put("India", 1000);
            hm.put("USA", 200);
            hm.put("China", 500);

            System.out.println(hm);

            // get-- O(1)
            System.out.println(hm.get("India"));

            // containKey -- O(1)
            System.out.println(hm.containsKey("India"));

            // remove-- O(1)
            hm.remove("USA");

            // size
            System.out.println(hm.size());

            // clear...
            hm.clear();

            // isEmpty
            System.out.println(hm.isEmpty());
      }

      public static void hashMapIteration() {
            HashMap<String, Integer> hm = new HashMap<>();
            hm.put("India", 1000);
            hm.put("USA", 200);
            hm.put("China", 500);
            hm.put("indonesia", 150);
            hm.put("Leo", 501);

            System.out.println(hm);

            // using a function the will store the keys of all hashMap...
            Set<String> keys = hm.keySet();
            System.out.println(keys); // set of a keys --- [USA, China, Leo, indonesia, India]

            System.out.println(hm.entrySet()); // --- [USA=200, China=500, Leo=501, indonesia=150, India=1000]

            for (String k : keys) {
                  System.out.println("[ Key: " + k + " , value : " + hm.get(k) + " ]");
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            hashMapIteration();
      }

      //? Output 
      // 1. 
      //     {USA=200, China=500, Leo=501, indonesia=150, India=1000}
      //     [USA, China, Leo, indonesia, India]
      //     [USA=200, China=500, Leo=501, indonesia=150, India=1000]
      //     [ Key: USA , value : 200 ]
      //     [ Key: China , value : 500 ]
      //     [ Key: Leo , value : 501 ]
      //     [ Key: indonesia , value : 150 ]
      //     [ Key: India , value : 1000 ]
}
