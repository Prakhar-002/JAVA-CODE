import java.util.HashSet;

public class HashSetBasics {

      public static void HashSet() {
            HashSet<Integer> set = new HashSet<>();

            set.add(1);
            set.add(2);
            set.add(4);
            set.add(2);
            set.add(3);

            System.out.println(set);

            System.out.println(set.remove(1));

            if (set.contains(2)) {
                  System.out.println("set contains 2");
            }

            System.out.println(set);

            System.out.println(set.size());

            set.clear();
            System.out.println(set.isEmpty());
      }

      // ----------------------------------------------------------------------------------------------

      public static void hashSetIteration() {
            HashSet<String> cities = new HashSet<>();

            cities.add("Delhi");
            cities.add("Kanpur");
            cities.add("GN");
            cities.add("Lucknow");

            // 1-st method...
            // Iterator it = cities.iterator();
            // while (it.hasNext()) {
            // System.out.println(it.next());

            // 2nd method
            for (String city : cities) {
                  System.out.println(city);
            }
      }


      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            hashSetIteration();
      }

      //? Output 
      // 1. 
      //     Lucknow
      //     Delhi
      //     Kanpur
      //     GN
}
