import java.util.*;
public class J_43Heap {

      static class Heap{
            ArrayList<Integer> arr = new ArrayList<>();

            // Add function...
            public void add(int data){  //O( log n)
                  arr.add(data); // add at last integer...  O(1)

                  int childIdx = arr.size()-1;
                  int parentIdx = (childIdx-1)/2;   //O(1)

                  while(arr.get(childIdx) < arr.get(parentIdx)){  // O(log n)
                  // while(arr.get(childIdx) > arr.get(parentIdx)){   // for max heap...    
                        // swap...
                        int temp = arr.get(childIdx);
                        arr.set(childIdx, arr.get(parentIdx));
                        arr.set(parentIdx, temp);

                        childIdx = parentIdx;
                        parentIdx = (childIdx -1)/2;
                  }
            }

            public int peek(){
                  return arr.get(0);
            }

            private void heapIfy(int i){  // O(log n)
                  int leftIdx = 2*i+1;
                  int rightIdx = 2*i+2;
                  int minIdx = i;
                  // int maxIdx = i ; // for max heap change the name everywhere...

                  // If left child is small...
                  if (leftIdx < arr.size() && arr.get(minIdx) > arr.get(leftIdx)) {
                  // if (leftIdx < arr.size() && arr.get(minIdx) < arr.get(leftIdx)) { // for max heap...
                        minIdx = leftIdx ;
                  }

                  // If right child is small...
                  if (rightIdx < arr.size() && arr.get(minIdx) > arr.get(rightIdx)) {
                  // if (rightIdx < arr.size() && arr.get(minIdx) < arr.get(rightIdx)) { // for max heap...
                        minIdx = rightIdx;
                  }

                  // change...
                  if (minIdx != i) {
                        // swap with the smallerOne...
                        int temp = arr.get(i);
                        arr.set(i, arr.get(minIdx));
                        arr.set(minIdx , temp);

                        // if does not set proper then call for minIdx...
                        heapIfy(minIdx);
                  }
            }

            public int remove(){
                  int data = arr.get(0); //min value will delete...

                  // step -1 swap first and last
                  int temp = arr.get(0);
                  arr.set(0, arr.get(arr.size()-1));
                  arr.set(arr.size()-1 , temp);

                  // delete the last node from arraylist
                  arr.remove(arr.size()-1);

                  // heapIfy ... it will correct the heap...
                  heapIfy(0);
                  return data;
            }

            public boolean isEmpty(){
                  return arr.size() == 0;
            }
      }

      public static void heapCall(){
            Heap h = new Heap();
            h.add(12);
            h.add(4);
            h.add(41);
            h.add(1);

            while (!h.isEmpty()) {
                  System.out.print(h.peek()+" ");
                  h.remove();
            }
      }

//-------------------------------------------------------------------------------------------

      // max cars nearest...
      static class Point implements Comparable<Point>{
            int x;
            int y;
            int distSq;
            int idx;

            public Point(int x , int y, int distSq , int idx){
                  this.x = x ;
                  this.y = y;
                  this.distSq = distSq;
                  this.idx = idx;
            }

            @Override
            public int compareTo(Point p){
                  return this.distSq - p.distSq;
            }
      }

      public static void maxCarsNearest(){
            int ptn [][] = {{3,3} , {5,-1}, {-2,4}}; // cars locations...
            int k =2; // numbers of cars...
            PriorityQueue<Point> pq = new PriorityQueue<>();

            for (int i = 0; i < ptn.length; i++) {
                  int distSq = ptn[i][0]*ptn[i][0] + ptn[i][1]*ptn[i][1];
                  pq.add(new Point(ptn[i][0], ptn[i][1], distSq, i));
            }

            // nearest cars...
            for (int i = 0; i < k; i++) {
                  System.out.println("Car number- "+pq.remove().idx);
            }
      }

//-------------------------------------------------------------------------------------------

      // connect n ropes with minimum cast... cast is equal to length of ropes...
      public static void connectRopes(){
            int arr[] ={2, 3, 3, 4, 6};

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < arr.length; i++) {
                  pq.add(arr[i]);
            }

            int cost =0;
            while(pq.size() > 1){
                  int min1 = pq.remove();  // first min...
                  int min2 = pq.remove();  // second min...
                  cost += min1 + min2;     // cast is sum of ropes length...
                  pq.add(min1+min2);       // again add the some of rope combined before...
            }

            System.out.println("Cost of connecting N ropes is : "+cost);
            // logic...(2, 3, 3, 4, 6)-- 2+3 = 5 (3, 4, 5, 6) -- 3+4 =7 (5, 6, 7)-- 5+6 = 11 (7 ,11) -- 18
            // cost will be ...5+7+11+18 == 41
      }

//-------------------------------------------------------------------------------------------

      // weakest soldier...
      // We are given an mxn binary matrix of I's (soldiers) and O's (civilians). The soldiers are
      // positioned in front of the civilians. That is, all the I's will appear to the left of all the 0's
      // in each row.
      // A row i is weaker than a row j if one of the following is true:
      // • The number of soldiers in row i is less than the number of soldiers in row j.
      // • Both rows have the same number of soldiers and i < j.
      // Find the K weakest rows.
      static class Row implements Comparable<Row>{
            int soldiers;
            int idx;

            public Row(int soldier , int idx){
                  this.soldiers = soldier;
                  this.idx = idx;
            }

            @Override
            public int compareTo(Row r){
                  if (this.soldiers == r.soldiers) {  // if soldiers are same then compare on idx value
                        return this.idx - r.idx;
                  }else{
                        return this.soldiers - r.soldiers; // else compare count of soldiers...
                  }
            }
      }

      public static void weakSoldiersRow(){
            int army[][] ={
                  {1, 0, 0, 0},
                  {1, 1, 1, 1},
                  {1, 0, 0, 0},
                  {1, 0, 0, 0}
            };
            int k =2;

            PriorityQueue<Row> pq = new PriorityQueue<>();

            for (int i = 0; i < army.length; i++) {
                  int count =0;
                  for (int j = 0; j < army[0].length; j++) {
                        count += army[i][j] == 1 ? 1 : 0 ; 
                  }
                  pq.add(new Row(count, i));
            }

            // print...
            for (int i = 0; i < k; i++) {
                  System.out.println("ROW--> "+pq.remove().idx);
            }
      }

//-------------------------------------------------------------------------------------------

      // sliding maximum window...
      static class Pair implements Comparable<Pair>{
            int val;
            int idx;

            public Pair(int val , int idx){
                  this.val = val;
                  this.idx = idx;
            }

            @Override
            public int compareTo(Pair p){
                  // return this.val - value.val; // ascending order....
                  return p.val - this.val;        // descending order...
            }
      }

      public static void slidingWindowMax(){  // O(n log k)
            int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
            int k = 3 ;  // window length...

            int res[] = new int[arr.length - k + 1];  // array of n-k+1...

            PriorityQueue<Pair> pq = new PriorityQueue<>();

            // 1st window...
            for (int i = 0; i < k; i++) {
                  pq.add(new Pair(arr[i], i));
            }

            // first max value in first window 
            res[0] = pq.peek().val;

            // rest window...
            for (int i = k; i < arr.length; i++) {  
                  // delete upTo where the size of window start...
                  while (pq.size() > 0 && pq.peek().idx <= (i-k)) {
                        pq.remove();
                  }

                  // add next window value...
                  pq.add(new Pair(arr[i], i));
                  // add next window's max ...
                  res[i - k+1] = pq.peek().val;
            }

            for (int i = 0; i < res.length; i++) {
                  System.out.print(res[i] +" ");
            }
            System.out.println();
      }



      public static void main(String[] args) {
            // 1...heapCall();
            // 2...maxCarsNearest();
            // 3...connectRopes();
            // 4...weakSoldiersRow();
            slidingWindowMax();

      }
}
