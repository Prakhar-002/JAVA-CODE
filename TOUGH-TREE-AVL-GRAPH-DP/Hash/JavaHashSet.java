import java.util.*;
public class JavaHashSet {

      public static void HashSet(){
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

//----------------------------------------------------------------------------------------------

      public static void hashSetIteration(){
            HashSet<String> cities = new HashSet<>();

            cities.add("Delhi");
            cities.add("Kanpur");
            cities.add("GN");
            cities.add("Lucknow");

            // 1-st method...
            // Iterator it = cities.iterator();
            // while (it.hasNext()) {
            //       System.out.println(it.next());
            // }
            
            // 2nd method
            for (String city : cities) {
                  System.out.println(city);
            }
      }

//----------------------------------------------------------------------------------------------

      public static void LinkedHashSet(){
            HashSet<String> cities1 = new HashSet<>();

            cities1.add("Delhi");
            cities1.add("Kanpur");
            cities1.add("GN");
            cities1.add("Lucknow");

            System.out.println("by hashSet --" + cities1);

            LinkedHashSet<String> cities = new LinkedHashSet<>();

            cities.add("Delhi");
            cities.add("Kanpur");
            cities.add("GN");
            cities.add("Lucknow");

            System.out.println("by LinkedHashSet --" +cities);
      }

//----------------------------------------------------------------------------------------------

      public static void TreeSet(){  // O( log n)
            // Sorted in ascending order
            // values are NOT allowed NULL
            TreeSet<String> cities = new TreeSet<>();

            cities.add("Delhi");
            cities.add("Kanpur");
            cities.add("GN");
            cities.add("Lucknow");

            System.out.println("By TreeSet -- "+cities);
      }

      public static int countDistinctElement(){
            int num[] ={ 4, 3, 2, 5, 6, 7, 3, 4, 2, 1};

            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < num.length; i++) {
                  set.add(num[i]);
            }

            return set.size();
      }

//----------------------------------------------------------------------------------------------

      public static void unionAndIntersection(){
            int arr1[] ={7, 3, 9};
            int arr2[] = {6, 3, 9, 2, 9, 4};

            HashSet<Integer> union = new HashSet<>();
            for (int i = 0; i < arr1.length; i++) {
                  union.add(arr1[i]);
            }for (int i = 0; i < arr2.length; i++) {
                  union.add(arr2[i]);
            }

            System.out.println("union is ---"+ union);

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

            System.out.println("intersection is ---"+ intersection);
      }

//----------------------------------------------------------------------------------------------

      public static String toStart(HashMap<String , String> tickets){
            HashMap<String , String> revMap = new HashMap<>();

            for (String key : tickets.keySet()) {
                  revMap.put(tickets.get(key), key);
            }

            for (String key : tickets.keySet()) {
                  if (!revMap.containsKey(key)) {
                        return key;
                  }
            }

            return null;
      }

      public static void ItineraryForTickets(){  //O(n)
            HashMap<String , String> tickets = new HashMap<>();
            tickets.put("Chennai", "Bengal");
            tickets.put("Mumbai","Delhi");
            tickets.put("Goa","Chennai");
            tickets.put("Delhi","Goa");

            String start = toStart(tickets);
            System.out.print(start);

            for (String key : tickets.keySet()) {
                  System.out.print(" -> "+tickets.get(start));
                  start = tickets.get(start);
            }
      }

//----------------------------------------------------------------------------------------------

      public static void largestSumArray(){  //O(n)
            int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

            HashMap<Integer , Integer> map = new HashMap<>();

            int sum = 0;
            int len = 0;

            for (int j = 0; j < arr.length; j++) {
                  sum += arr[j];
                  if (map.containsKey(sum)) {
                        LinkedHashMap<Integer , Integer > sumMap = new LinkedHashMap<>();
                        len = Math.max(len , j-map.get(sum));
                        for (int i = map.get(sum)+1; i <= j; i++) {
                              sumMap.put(arr[i], i);
                        }
                        System.out.println(sumMap.keySet());
                  }else{
                        map.put(sum, j);
                  }
            }

            System.out.println("maximum length of subArray with total sum 0 : "+len);
      }

//----------------------------------------------------------------------------------------------

      // SubArray sum equal to K
      public static void nSubArraySumK(){
            int arr[] = {10, 2, -2, -20, 10};
            int k = -10;

            HashMap<Integer , Integer> map = new HashMap<>();
            // (sum ,count)
            map.put(0, 1);

            int sum = 0;
            int ans = 0;

            for(int j = 0; j< arr.length ; j++){
                  sum += arr[j];
                  if (map.containsKey(sum - k)) {
                        ans += map.get(sum - k);
                  }
                  map.put(sum, map.getOrDefault(sum, 0) +1);
            }

            System.out.println("total number of array of sum "+ k+ " is : "+ans);
      }

      public static void main(String[] args) {
            // 1...HashSet();
            // 2...hashSetIteration();
            // 3...LinkedHashSet();
            // 4...TreeSet();
            // 5...System.out.println(countDistinctElement());
            // 6...unionAndIntersection();
            // 7...ItineraryForTickets();
            // 8...largestSumArray();
            // 9...nSubArraySumK();
      }
}
