import java.util.HashSet;

public class CountDistinctElement {
      

      public static int countDistinctElement(){
            int num[] ={ 4, 3, 2, 5, 6, 7, 3, 4, 2, 1};

            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < num.length; i++) {
                  set.add(num[i]);
            }

            return set.size();
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            System.out.println(countDistinctElement());
      }

      //? Output 
      // 1. 
      //    7
}
