import java.util.ArrayList;
import java.util.Collections;

public class JavaArrayList {

      // we'll study about array list in this module...

      public static void arrayList() {
            // initializing
            ArrayList<Integer> list = new ArrayList<>();
            // ArrayList<String> list =new ArrayList<>(); // String type
            // ArrayList<Boolean> list =new ArrayList<>(); // Boolean type

            System.out.println("empty ->" + list);
            // print arrayList...
            // output
            // empty ->[]

            // operation on arrayList
            // add element...O(1)
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(40);
            System.out.println("add ->" + list);
            // output
            // add ->[10, 20, 30, 40]

            // add element at index...O(n)
            list.add(1, 52); 
            System.out.println("add ->" + list);
            // output
            // add ->[10, 52, 20, 30, 40]

            // get element...O(1)
            int key = list.get(2);
            System.out.println("get ->" + key);
            // output
            // get ->30

            // remove ...O(n)
            list.remove(1);
            System.out.println("remove ->" + list);
            // output
            // remove ->[10, 30, 40]

            // set element...O(n)
            list.set(0, 74);
            System.out.println("set ->" + list);
            // output
            // set ->[74, 30, 40]

            // contain element...O(n)
            System.out.println(list.contains(1));
            System.out.println(list.contains(30));
            // output
            // false
            // true

            // to get length of arrayList
            System.out.println(list.size());
            // output
            // 4

            // print all elements of arrayList...O(n)
            for (int i = 0; i < list.size(); i++) {
                  System.out.print(list.get(i) + " ");
            }
            System.out.println();
            // output
            // 74 20 30 40

            // max array...O(n)
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < list.size(); i++) {
                  max = Math.max(max, list.get(i));
            }
            System.out.println("max is : " + max);
            // output
            // max is : 74

            // sort in build... we need to import the (collections)
            System.out.println("Initial list :" + list);
            Collections.sort(list); // ascending order
            System.out.println("final list after sorting :" + list);
            Collections.sort(list, Collections.reverseOrder()); // descending order
            System.out.println("final list after sorting :" + list);
            // output
            // Initial list :[74, 20, 30, 40]
            // final list after sorting :[20, 30, 40, 74]
            // final list after sorting :[74, 40, 30, 20]
      }


      public static void main(String args[]) {
            arrayList();
      }
}
