import java.util.*;

public class JavaQueueProblems {

      public static void printNonRepeating(String str){
            // frequency array 
            int freq[] = new int[26];  // 'a' - 'z'
            // one queue
            Queue<Character> q = new LinkedList<>();

            for (int i = 0; i < str.length(); i++) {
                  char ch = str.charAt(i);
                  q.add(ch);
                  freq[ch - 'a']++;

                  while (!q.isEmpty() && freq[q.peek() - 'a'] > 1 ) {
                        q.remove();
                  }

                  if(q.isEmpty()){
                        System.out.print(-1 + " ");
                  }else{
                        System.out.print(q.peek() + " ");
                  }
            }
            System.out.println();
      }

      // call...
      public static void printNonRepeatingCall(){
            printNonRepeating("aabccxb");
      }

//------------------------------------------------------------------------------------------
      public static void twoHalvesOfAQueue(Queue<Integer> q){  // only even ...
            Queue<Integer> firstHalf = new LinkedList<>();
            int size = q.size();
            // find our first half...
            for (int i = 0; i < size/2; i++) {
                  firstHalf.add(q.remove());
            }

            // we'll add now to our new queue to older queue
            while (!firstHalf.isEmpty()) {
                  q.add(firstHalf.remove());  // add first half to it's tail...
                  q.add(q.remove()); // add 2nd half to it's end...
            }
      }

      /// call...
      public static void twoHalvesOfAQueueCall(){
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < 11; i++) {
                  q.add(i);
            }
            System.out.println("Before call --> " + q);
            System.out.println();
            // call function
            twoHalvesOfAQueue(q);
            System.out.println("After call --> " + q);
      }

//------------------------------------------------------------------------------------------
      public static void queueReversal(Queue<Integer> q){
            Stack <Integer> s = new Stack<>();

            while (!q.isEmpty()) {
                  s.push(q.remove());
            }

            while (!s.isEmpty()) {
                  q.add(s.pop());
            }
      }

      // call...
      public static void queueReversalCall(){
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < 11; i++) {
                  q.add(i);
            }
            System.out.println("Before call --> " + q);
            queueReversal(q);
            System.out.println();
            System.out.println("After call --> " + q);
      }

      public static void main(String[] args) {
            System.out.println("Queue problems...");
            // 1...printNonRepeatingCall();
            // 2...twoHalvesOfAQueueCall();
            // 3...queueReversalCall();
      }
}
