import java.util.*;
public class JavaPriorityQueue {

      public static void priorityQueueJCF(){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            pq.add(10);  //O( log n)
            pq.add(20);
            pq.add(30);
            while(!pq.isEmpty()){
                  System.out.print(pq.peek()+" "); //O(1)
                  pq.remove();   // O(log n)
            }
      }

//-----------------------------------------------------------------------------------------------

      static class Student implements Comparable<Student> { // overRiding
            String name;
            int rank;

            public Student(String name , int rank){
                  this.name = name;
                  this.rank = rank;
            }

            @Override
            public int compareTo(Student s2){
                  return this.rank - s2.rank;
            }
      }

      // They'll sort by their rank...
      public static void priorityQueueObject(){
            // PriorityQueue<Student> pq = new PriorityQueue<>();
            PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

            pq.add(new Student("A", 7));
            pq.add(new Student("B", 71));
            pq.add(new Student("C", 8));
            pq.add(new Student("D", 1));

            while (!pq.isEmpty()) {
                  System.out.println(pq.peek().name +" -> "+ pq.peek().rank);
                  pq.remove();
            }
      }


      public static void main(String[] args) {
            // 1...priorityQueueJCF();
            priorityQueueObject();
      }
}
