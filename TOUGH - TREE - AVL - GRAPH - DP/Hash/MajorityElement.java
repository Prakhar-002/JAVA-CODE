import java.util.HashMap;

public class MajorityElement {
      
      public static void majorityElement(){  // O(n)
            int arr[] = {1, 3, 2, 1, 5, 1, 3, 1, 3, 5, 1, 3, 3};
            HashMap<Integer ,Integer> map = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                  // if (map.containsKey(arr[i])) {
                  //       map.put(arr[i], map.get(arr[i])+1);
                  // }else{
                  //       map.put(arr[i] , 1);
                  // }

                  // or we can right
                  map.put(arr[i], map.getOrDefault(arr[i] , 0)+1);
            }

            System.out.println("Numbers that are greater then array length's third time...");
            for (Integer key : map.keySet()) {
                  if (map.get(key) > arr.length/3) {
                        System.out.print(key+" ");
                  }
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            majorityElement();
      }

      //? Output 
      // 1. 
      //    Numbers that are greater then array length's third time...
      //    1 3

}
