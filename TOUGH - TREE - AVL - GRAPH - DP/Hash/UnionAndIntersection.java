import java.util.HashSet;

public class UnionAndIntersection {

      public static void unionAndIntersection() {
            int arr1[] = { 7, 3, 9 };
            int arr2[] = { 6, 3, 9, 2, 9, 4 };

            HashSet<Integer> union = new HashSet<>();
            for (int i = 0; i < arr1.length; i++) {
                  union.add(arr1[i]);
            }
            for (int i = 0; i < arr2.length; i++) {
                  union.add(arr2[i]);
            }

            System.out.println("union is ---" + union);

            HashSet<Integer> set = new HashSet<>();
            HashSet<Integer> intersection = new HashSet<>();

            for (int i = 0; i < arr1.length; i++) {
                  set.add(arr1[i]);
            }

            for (int i = 0; i < arr2.length; i++) {
                  if (set.contains(arr2[i])) {
                        intersection.add(arr2[i]);
                  }
            }

            System.out.println("intersection is ---" + intersection);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            unionAndIntersection();
      }

      // ? Output
      // 1.
      //      union is ---[2, 3, 4, 6, 7, 9]
      //      intersection is ---[3, 9]
}
