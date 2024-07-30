import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetBasics {

      public static void LinkedHashSet() {
            HashSet<String> cities1 = new HashSet<>();

            cities1.add("Delhi");
            cities1.add("Kanpur");
            cities1.add("GN");
            cities1.add("Lucknow");

            System.out.println("by hashSet --> " + cities1);

            LinkedHashSet<String> cities = new LinkedHashSet<>();

            cities.add("Delhi");
            cities.add("Kanpur");
            cities.add("GN");
            cities.add("Lucknow");

            System.out.println("by LinkedHashSet --> " + cities);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            LinkedHashSet();
      }

      //? Output 
      // 1. 
      //     by hashSet --> [Lucknow, Delhi, Kanpur, GN]
      //     by LinkedHashSet --> [Delhi, Kanpur, GN, Lucknow]
}
