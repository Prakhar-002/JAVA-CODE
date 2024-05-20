public class RecursiveSearch {

      public static LinkedListCreation.Node head = null;

      public static int helper(LinkedListCreation.Node head, int key) { // O(n) && O(n) space
            if (head == null) {
                  return -1;
            }

            if (head.data == key) {
                  return 0;
            }
            int idx = helper(head.next, key);
            if (idx == -1) {
                  return -1;
            }

            return idx + 1;
      }

      public static int recursiveSearch(LinkedListCreation.Node head, int key) {
            return helper(head, key);
      }

// ------------------------------------------------------------------------
      public static void main(String args[]) {
            head = new LinkedListCreation.Node(10);
            head.next = new LinkedListCreation.Node(20);
            head.next.next = new LinkedListCreation.Node(30);
            head.next.next.next = new LinkedListCreation.Node(40);
            // head->10->20->30->Null
            System.out.println(recursiveSearch(head, 30));
      }

      //? Output 
      // 1. 
      //     2
}
