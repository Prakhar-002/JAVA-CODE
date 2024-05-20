import java.util.ArrayList;

public class SwapFunc {

      // swap function for arrayList
      public static void swap(ArrayList<Integer> list, int index1, int index2) {
            int temp = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, temp);
      }

      // swap function call
      public static void swapCall() {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(14);
            list.add(15);
            list.add(19);
            list.add(145);
            list.add(141);
            list.add(140);
            int i = 1;
            int j = 2;
            System.out.println("before swapping...");
            System.out.println(list);
            System.out.println(list.get(i));
            System.out.println(list.get(j));
            swap(list, i, j);
            System.out.println("before swapping...");
            System.out.println(list.get(i));
            System.out.println(list.get(j));
            System.out.println(list);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            swapCall();
      }

      //? Output 
      //     before swapping...
      //     [14, 15, 19, 145, 141, 140]
      //     15
      //     19
      //     After swapping...
      //     19
      //     15
      //     [14, 19, 15, 145, 141, 140]

}
