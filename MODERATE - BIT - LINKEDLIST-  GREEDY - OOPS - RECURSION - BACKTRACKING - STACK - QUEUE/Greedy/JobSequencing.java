import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
      
      static class Job {
            int deadLine;
            int profit;
            int id; // 0 (A) ,1(B) ,2(C)

            public Job(int i, int d, int pr) {
                  id = i;
                  deadLine = d;
                  profit = pr;
            }
      }

      public static void jobSequencing() {
            int jobInfos[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

            ArrayList<Job> jobs = new ArrayList<>();

            for (int i = 0; i < jobInfos.length; i++) {
                  jobs.add(new Job(i, jobInfos[i][0], jobInfos[i][1]));
            }

            // sorting of arrayList of objects
            Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);// descending order...
            // Collections.sort(jobs ,(obj1 ,obj2) -> obj1.profit - obj2.profit); //
            // ascending order...

            ArrayList<Integer> seq = new ArrayList<>();
            int time = 0;
            for (int i = 0; i < jobs.size(); i++) {
                  Job cur = jobs.get(i);
                  if (cur.deadLine > time) {
                        seq.add(cur.id);
                        time++;
                  }
            }

            System.out.println("max works is : " + seq.size() + " and the jobs are as order is " + seq);
            for (int i = 0; i < seq.size(); i++) {
                  System.out.println("{" + jobInfos[seq.get(i)][0] + "," + jobInfos[seq.get(i)][1] + "}");
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            jobSequencing();
      }

      // ? Output
      //  1.
      //     max works is : 2 and the jobs are as order is [2, 0]
      //     {1,40}
      //     {4,20}
}
