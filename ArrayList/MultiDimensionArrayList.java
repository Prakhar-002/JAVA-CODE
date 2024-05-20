import java.util.ArrayList;

public class MultiDimensionArrayList {

      public static void multiDimensionArrayList() {
            // main Array list initialize
            ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
            // sub lists
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            ArrayList<Integer> list3 = new ArrayList<>();

            for (int i = 1; i <= 5; i++) {
                  // list1 data
                  list1.add(i * 1);
                  // list2 data
                  list2.add(i * 2);
                  // list3 data
                  list3.add(i * 3);
            }

            // adding list in main list
            mainList.add(list1);
            mainList.add(list2);
            mainList.add(list3);

            System.out.println(mainList);

            //? Output
            // [[1, 2, 3, 4, 5], [2, 4, 6, 8, 10], [3, 6, 9, 12, 15]]

            // nested loop print
            for (int i = 0; i < mainList.size(); i++) {
                  ArrayList<Integer> object = new ArrayList<>(mainList.get(i)); // or ArrayList<Integer> ob
                  //                                                               mainList.get(i);
                  for (int j = 0; j < object.size(); j++) {
                        System.out.print(object.get(j) + " ");
                  }
                  System.out.println();
            }

            //? output is -->
            // 1 2 3 4 5
            // 2 4 6 8 10
            // 3 6 9 12 15
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            multiDimensionArrayList();
      }

}
