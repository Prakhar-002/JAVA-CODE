import java.util.LinkedList;
import java.util.Queue;

public class PrintNonRepeating {

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

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            printNonRepeatingCall();
      }

      // ? Output
      //  1.
      //     a -1 b b b b x 
}
