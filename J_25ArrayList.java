import java.util.ArrayList;
import java.util.Collections;

public class J_25ArrayList {

      // we'll study about array list in this module...

      // ----------------------------------------------------------------------------------------

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

            // sort in build... we need to import the collections
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

      // ----------------------------------------------------------------------------------------

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
            // output...
            // before swapping...
            // [14, 15, 19, 145, 141, 140]
            // 15
            // 19
            // before swapping...
            // 19
            // 15
            // [14, 19, 15, 145, 141, 140]
      }

      // ----------------------------------------------------------------------------------------

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

            // Output
            // [[1, 2, 3, 4, 5], [2, 4, 6, 8, 10], [3, 6, 9, 12, 15]]

            // nested loop print
            for (int i = 0; i < mainList.size(); i++) {
                  ArrayList<Integer> object = new ArrayList<>(mainList.get(i)); // or ArrayList<Integer> ob
                                                                                // =mainList.get(i);
                  for (int j = 0; j < object.size(); j++) {
                        System.out.print(object.get(j) + " ");
                  }
                  System.out.println();
            }
            // output is :
            // [[1, 2, 3, 4, 5], [2, 4, 6, 8, 10], [3, 6, 9, 12, 15]]
            // 1 2 3 4 5
            // 2 4 6 8 10
            // 3 6 9 12 15
      }

      // ----------------------------------------------------------------------------------------

      // brute force approach ...O(n^2)
      public static int containWaterBrute(ArrayList<Integer> height) {
            int maxWater = 0;
            for (int i = 0; i < height.size(); i++) {
                  for (int j = i + 1; j < height.size(); j++) {
                        int ht = Math.min(height.get(i), height.get(j));
                        int width = j - i;
                        int curWater = ht * width;
                        maxWater = Math.max(maxWater, curWater);
                  }
            }
            return maxWater;
      }// output 49

      // two pointer approach...O(n)

      public static int waterContain(ArrayList<Integer> height) {
            int maxWater = 0;
            int lp = 0;
            int rp = height.size() - 1;
            while (lp < rp) {
                  // cur = ht*width
                  int curWater = (rp - lp) * Math.min(height.get(rp), height.get(lp));
                  maxWater = Math.max(maxWater, curWater);
                  // update ptr
                  if (height.get(lp) < height.get(rp)) {
                        lp++;
                  } else {
                        rp--;
                  }
            }
            return maxWater;
      }// output 49

      public static void containWaterCall() {
            ArrayList<Integer> height = new ArrayList<>();
            height.add(1);
            height.add(8);
            height.add(6);
            height.add(2);
            height.add(5);
            height.add(4);
            height.add(8);
            height.add(3);
            height.add(7);

            // System.out.println(containWaterBrute(height));
            System.out.println(waterContain(height));
      }

// ----------------------------------------------------------------------------------------

      // pair sum 1    arrayList is sorted...
      // pair sum brute force approach

      public static void pairSumBrute(ArrayList<Integer> pair, int sum) {
            for (int i = 0; i < pair.size(); i++) {
                  for (int j = i + 1; j < pair.size(); j++) {
                        if (pair.get(i) + pair.get(j) == sum) {
                              System.out.println("[" + pair.get(i) + "," + pair.get(j) + "]");
                        }
                  }
            }
      }     // output 
            // [1,4]
            // [2,3]

      // 2 pointer approach...O(n)
      public static void pairSumPointer(ArrayList<Integer> pair ,int sum){
            int lp =0;
            int rp =pair.size()-1;
            while(lp!=rp){
                  // case one 
                  if(pair.get(lp) + pair.get(rp) == sum){
                              System.out.println("["+pair.get(lp)+","+ pair.get(rp)+"]");
                  }
                  // case two
                  if(pair.get(lp) + pair.get(rp) < sum){
                        lp++;
                  }// case 3 
                  else{
                        rp--;
                  }
            }
      }     // output 
            // [1,4]
            // [2,3]

      public static void pairSumCall() {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(1);
            pair.add(2);
            pair.add(3);
            pair.add(4);
            pair.add(5);
            pair.add(6);
            pair.add(7);

            System.out.println(pair);
            // pairSumBrute(pair, 5);
            pairSumPointer(pair,6);
      }

// ----------------------------------------------------------------------------------------

      // pair sum 2 in rotated arrayList and sorted list

      public static void PairSumTwo(ArrayList<Integer> pair,int sum){  // O(n)
            // finding pivot for this arrayList
            int pivot =-1;
            for (int i = 0; i < pair.size(); i++) {
                  if(pair.get(i) > pair.get(i+1)){
                        pivot =i;
                        break;
                  }
            }
            // we'll find sum pair now...
            int lp =pivot+1;
            int rp =pivot-1;
            while(lp!=rp){
                  // case one 
                  if(pair.get(lp) + pair.get(rp) == sum){
                        System.out.println("["+pair.get(lp)+","+ pair.get(rp)+"]");
                  }
                  // case two
                  if(pair.get(lp) + pair.get(rp) < sum){
                        lp = (lp + 1) % pair.size();  // lp = (lp+1)%n
                  }// case 3 
                  else{
                        rp = (pair.size() + rp -1) % pair.size();  // rp =(n +rp -1)%n
                  }
            }
      }

      public static void pairSum2Call() {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(8);
            pair.add(9);
            pair.add(10);
            pair.add(11);
            pair.add(1);
            pair.add(2);
            pair.add(3);
            pair.add(4);
            pair.add(5);
            pair.add(6);
            pair.add(7);
            
            System.out.println(pair);
            PairSumTwo(pair,17);
      }

      public static void main(String args[]) {
            // 1... arrayList();
            // 2...swapCall();
            // 3...multiDimensionArrayList();
            // 4...containWaterCall();
            // 5...pairSumCall();
            // 6...pairSum2Call();
      }
}
