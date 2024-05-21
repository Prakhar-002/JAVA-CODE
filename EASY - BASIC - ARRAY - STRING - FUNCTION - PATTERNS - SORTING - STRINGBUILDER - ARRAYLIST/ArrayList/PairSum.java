import java.util.ArrayList;

public class PairSum {


// ----------------------------------------------------------------------------------------

      // pair sum 1    arrayList is sorted...
      // pair sum brute force approach

      public static void pairSumBrute(ArrayList<Integer> pair, int sum) {
            for (int i = 0; i < pair.size(); i++) {
                  for (int j = i + 1; j < pair.size(); j++) {
                        if (pair.get(i) + pair.get(j) == sum) {
                              System.out.println("[" + pair.get(i) + "," + pair.get(j) + "]");
                              return;
                        }
                  }
            }
            System.out.println(sum + "Not Exist");
      }    
      //?output 
      //     [1,4]
      //     [2,3]

      // 2 pointer approach...O(n)
      public static void pairSumPointer(ArrayList<Integer> pair, int sum){
            int lp = 0;
            int rp = pair.size()-1;
            while(lp != rp){
                  // case one 
                  if(pair.get(lp) + pair.get(rp) == sum){
                        System.out.println("[" + pair.get(lp) + "," + pair.get(rp) + "]");
                        return;
                  }
                  // case two
                  if(pair.get(lp) + pair.get(rp) < sum){
                        lp++;
                  }// case 3 
                  else{
                        rp--;
                  }
            }
            System.out.println(sum + "Not Exist");
      }     
      //?     output 
      //     [1,4]
      //     [2,3]

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
            int pivot = -1;
            for (int i = 0; i < pair.size(); i++) {
                  if(pair.get(i) > pair.get(i+1)){
                        pivot = i;
                        break;
                  }
            }
            // we'll find sum pair now...
            int lp = pivot + 1;
            int rp = pivot;
            while(lp != rp){
                  // case one 
                  if(pair.get(lp) + pair.get(rp) == sum){
                        System.out.println("[" + pair.get(lp) + "," + pair.get(rp) + "]");
                        return;
                  }
                  // case two
                  if(pair.get(lp) + pair.get(rp) < sum){
                        lp = (lp + 1) % pair.size();  // lp = (lp+1)%n
                  }// case 3 
                  else{
                        rp = (pair.size() + rp -1) % pair.size();  // rp =(n +rp -1)%n
                  }
            }
            System.out.println("ERROR " + sum + " Not Found");
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

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            pairSumCall();
            pairSum2Call();
      }

}
