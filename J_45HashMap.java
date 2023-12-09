import java.util.*;
public class J_45HashMap {

      public static void hashMap(){
            HashMap<String , Integer> hm = new HashMap<>();

            // put  O(1)
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

      public static void hashMapIteration(){
            HashMap<String , Integer> hm = new HashMap<>();
            hm.put("India", 1000);
            hm.put("USA", 200);
            hm.put("China", 500);
            hm.put("indonesia", 150);
            hm.put("Leo", 501);

            System.out.println(hm);

            // using a function the will store the keys of all hashMap...
            Set<String> keys = hm.keySet();
            System.out.println(keys); // set of a keys --- [USA, China, Leo, indonesia, India]

            System.out.println(hm.entrySet());  //--- [USA=200, China=500, Leo=501, indonesia=150, India=1000]

            for (String k : keys) {
                  System.out.println("[ Key: "+k +" , value : "+hm.get(k)+" ]");
            }
      }

//----------------------------------------------------------------------------------------------

      // linked HashMap ...order of adding is as we wright...
      // we use doubly linked list in linkedHashMap for maintaining the order...
      public static void LinkedHashMap(){
            LinkedHashMap<String , Integer> lhm = new LinkedHashMap<>();
            lhm.put("India", 1000);
            lhm.put("USA", 200);
            lhm.put("China", 500);
            lhm.put("Indonesia", 150);
            lhm.put("Leo", 501);

            System.out.println(lhm);
      }

//----------------------------------------------------------------------------------------------

      // ordered by keys... and used red black tree...
      // put remove get --- O( log n) 
      public static void TreeMap(){
            TreeMap<String, Integer> tm = new TreeMap<>();
            tm.put("India", 1000);
            tm.put("USA", 200);
            tm.put("China", 500);
            tm.put("Indonesia", 150);
            tm.put("Leo", 501);

            System.out.println(tm);
      }

//----------------------------------------------------------------------------------------------

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

//----------------------------------------------------------------------------------------------

      // valid anagram...
      //Given two strings s and t, return true if t is an anagram of s, and false otherwise.
      // An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
      // typically using all the original letters exactly once.
      // s = "race" t = "care" ---TRUE
      public static boolean isAnagram(String s , String t){   // O(n)
            if (s.length() != t.length()) {
                  return false;
            }
            HashMap<Character ,Integer> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                  map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            for (int i = 0; i < t.length(); i++) {
                  char ch = t.charAt(i);
                  if (map.get(ch) != null) {
                        if (map.get(ch) == 1) {
                              map.remove(ch);
                        }else{
                              map.put(ch, map.get(ch) - 1);
                        }
                  }else{
                        return false;
                  }
            }

            return map.isEmpty();
      }

      public static void main(String[] args) {
            // 1...hashMap();
            // 2...hashMapIteration();
            // 3...LinkedHashMap();
            // 4...LinkedHashMap();
            // 5...TreeMap();
            // 6...majorityElement();
            // 7...System.out.println(isAnagram("race", "care"));
      }
}
