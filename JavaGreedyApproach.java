import java.util.*;

public class JavaGreedyApproach {

      public static void activitySelector() {  //O(n)
            int start[] = { 1, 3, 0, 5, 8, 5 };
            int end[] = { 2, 4, 6, 7, 9, 9 };

            // end time bases sort...
            int maxAct =0;
            ArrayList<Integer> ans = new ArrayList<>();

            maxAct++;
            ans.add(0);
            int lastEnd = end[0];

            for (int i = 0; i < end.length; i++) {
                  if (start[i] >= lastEnd) {
                        maxAct++;
                        lastEnd= end[i];
                        ans.add(i);
                  }
            }

            System.out.println("Maximum activities : "+maxAct);
            for (int i = 0; i < ans.size(); i++) {
                  System.out.print("A" + ans.get(i) + " ");
            }
            System.out.println();
      }

//-----------------------------------------------------------------------------------------------

      public static void activitySelectorNonSorted() {  //O(n log n)
            int start[] = { 1, 3, 0, 8, 5, 5 };
            int end[] = { 2, 4, 6, 9, 7, 9 };

            // sorting...
            int activities[][] = new int[start.length][3];
            for (int i = 0; i < activities.length; i++) {
                  activities[i][0] = i;
                  activities[i][1] = start[i];
                  activities[i][2] = end[i];
            }

            // we'll short 2-D array by col 2
            // lambda function ->sort form...
            Arrays.sort(activities, Comparator.comparingDouble(o ->o[2]));  // to sort 

            // end time bases sort...
            int maxAct =0;
            ArrayList<Integer> ans = new ArrayList<>();

            maxAct++;
            ans.add(activities[0][0]);
            int lastEnd = activities[0][2];

            for (int i = 0; i < end.length; i++) {
                  if (activities[i][1] >= lastEnd) {
                        maxAct++;
                        lastEnd= activities[i][2];
                        ans.add(activities[i][0]);
                  }
            }

            System.out.println("Maximum activities : "+maxAct);
            for (int i = 0; i < ans.size(); i++) {
                  System.out.print("A" + ans.get(i) + " ");
            }
            System.out.println();
      }

//-----------------------------------------------------------------------------------------------

      public static void frictionalKnapsack(){
            int val[] = {60, 100, 120};   // price of a value...
            int weight[] ={10, 20, 30};   // weight of each things
            int w= 50;                    // maximum weight of a knapsack ...(pocket)
            
            // sort things ...
            double ratio[][] = new double[val.length][2];
            //  0 th col => index   ... 1st col =>ratio

            for (int i = 0; i < ratio.length; i++) {
                  ratio[i][0] = i;  // 0sth col index...
                  ratio[i][1] = val[i] /(double)weight[i];   // 1st col ratio...
            }

            // sort 2-D array  ascending
            Arrays.sort(ratio, Comparator.comparingDouble(o ->o[1])); 

            int capacity = w;
            int maxProfit=0;
            for (int i= ratio.length-1 ; i>=0 ;i--  ) {
                  int idx =(int) ratio[i][0];
                  if (capacity >= weight[idx]) {
                        maxProfit += val[idx];   // include full item...
                        capacity -= weight[idx];
                        System.out.println("item of value "+val[idx] +" of weight "+ weight[idx]+" ");
                  }else{
                        // include fraction...
                        maxProfit += (ratio[i][1] * capacity);
                        System.out.println("And item of value "+val[idx] +" of weight "+ capacity+" ");
                        capacity = 0;
                        break;
                  }
            }
            System.out.println("Max profit of all item taken up to weight "+ w +" is : "+maxProfit);
      }
//-----------------------------------------------------------------------------------------------

      public static void minSumOfAbsoluteDiff(){  //O(n log n)
            int A [] ={ 1, 2, 3};
            int B[] = {2, 1, 3};

            Arrays.sort(A);
            Arrays.sort(B);

            int minDiffSum =0;
            for (int i = 0; i < A.length; i++) {
                  minDiffSum += Math.abs(A[i] - B[i]);
            }

            System.out.println("Minimum sum of absolute difference is "+minDiffSum);
      }

//-----------------------------------------------------------------------------------------------

      public static void maxLenChairPair(){ //O(n log n)
            int pair[][] ={ {5, 24} ,{39, 60} ,{5 ,28} ,{27 , 40} ,{50, 90}};

            Arrays.sort(pair, Comparator.comparingDouble(o ->o[1])); 

            int chainLen =1;
            int chainEnd = pair[0][1];

            System.out.print("pairs are in ...[ ");
            System.out.print("("+pair[0][0]+ " , "+pair[0][1]+ ")" +" " );
            for (int i = 1; i < pair.length; i++) {
                  if (pair[i][0] > chainEnd) {
                        chainLen++;
                        chainEnd =pair[i][1];
                        System.out.print("("+pair[i][0]+ " , "+pair[i][1]+ ")" +" " );
                  }
            }
            System.out.println("]");

            System.out.println("max number of chain can be form is : "+chainLen);
      }

//-----------------------------------------------------------------------------------------------

      public static void indianCoin(){  // canonical coin system...O( n log n)
            Integer coins [] ={1, 2, 5, 10, 20, 50, 100, 500, 2000};

            // first we sort it in reverse order...
            Arrays.sort(coins,Comparator.reverseOrder());

            int amount = 590;
            int countOfCoin =0;
            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < coins.length; i++) {
                  if (amount >= coins[i]) {
                        while (amount>= coins[i]) {
                              countOfCoin++;
                              arr.add(coins[i]);
                              amount -= coins[i];
                        }
                  }
            }
            System.out.println("number of coins are : "+countOfCoin);
            System.out.println("notes/coins used are : "+arr);
      }

//-----------------------------------------------------------------------------------------------

      static class Job{
            int deadLine;
            int profit;
            int id ; // 0 (A) ,1(B) ,2(C)

            public Job(int i ,int d ,int pr){
                  id = i;
                  deadLine =d;
                  profit = pr;
            }
      }


      public static void jobSequencing(){
            int jobInfos[][] = {{4, 20},{1, 10},{1, 40},{1, 30}};

            ArrayList<Job> jobs = new ArrayList<>();

            for (int i = 0; i < jobInfos.length; i++) {
                  jobs.add(new Job(i ,jobInfos[i][0] ,jobInfos[i][1] ));
            }

            // sorting of arrayList of objects
            Collections.sort(jobs ,(obj1 ,obj2) -> obj2.profit - obj1.profit);//descending order...
            // Collections.sort(jobs ,(obj1 ,obj2) -> obj1.profit - obj2.profit); // ascending order... 

            ArrayList<Integer> seq = new ArrayList<>();
            int time = 0;
            for (int i = 0; i < jobs.size(); i++) {
                  Job cur = jobs.get(i);
                  if(cur.deadLine > time){
                        seq.add(cur.id);
                        time++;
                  }
            }

            System.out.println("max works is : "+ seq.size() + " and the jobs are as order is "+seq);
            for (int i = 0; i < seq.size(); i++) {
                  System.out.println("{"+jobInfos[seq.get(i)][0]+","+jobInfos[seq.get(i)][1]+"}");
            }
      }

//-----------------------------------------------------------------------------------------------

      public static void chocolateCuttingProblem(){
            int horizontal =3 ,vertical =5 ;
            Integer verCost[] ={2, 1, 3, 1, 4};
            Integer horCost[] ={4, 1, 2};

            // sort the cost according to their cost on vertical and horizontal...
            Arrays.sort(verCost , Collections.reverseOrder());
            Arrays.sort(horCost , Collections.reverseOrder());

            int horCut =0 ,verCut =0;
            int horPiece = 1, verPiece =1;
            int cost =0;

            while (horCut < horizontal && verCut < vertical ) {
                  // hor cost > ver cost --> horCost first
                  if (horCost[horCut] >= verCost[verCut]) {  // horizontal cut...
                        cost += (horCost[horCut] * verPiece);
                        horPiece++;
                        horCut++;
                  }else{  // vertical cut...
                        cost += (verCost[verCut] * horPiece);
                        verPiece++;
                        verCut++;
                  }
            }

            // remaining part of horizontal 
            while (horCut < horizontal) {
                  cost += (horCost[horCut] * verPiece);
                  horPiece++;
                  horCut++;
            }

            // remaining part of vertical
            while (verCut < vertical) {
                  cost += (verCost[verCut] * horPiece);
                  verPiece++;
                  verCut++;
            }

            System.out.println("minimum cost to cut a piece of chocolate according to their verCost and horCost is : "+ cost);
      }

//-----------------------------------------------------------------------------------------------

      public static void main(String[] args) {
            // 1...activitySelector();
            // 2...activitySelectorNonSorted();
            // 3...frictionalKnapsack();
            // 4...minSumOfAbsoluteDiff();
            // 5...maxLenChairPair();
            // 6...indianCoin();
            // 7...jobSequencing();
            // 8...chocolateCuttingProblem();
      }
}
