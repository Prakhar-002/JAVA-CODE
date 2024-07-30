import java.util.TreeSet;

public class TreeSetBasics {

      public static void TreeSet() { // O( log n)
            // Sorted in ascending order
            // values are NOT allowed NULL
            TreeSet<String> cities = new TreeSet<>();

            cities.add("Delhi");
            cities.add("Kanpur");
            cities.add("GN");
            cities.add("Lucknow");

            System.out.println("By TreeSet -- " + cities);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            TreeSet();
      }

      // ? Output
      // 1.
      //       By TreeSet -- [Delhi, GN, Kanpur, Lucknow]
}
