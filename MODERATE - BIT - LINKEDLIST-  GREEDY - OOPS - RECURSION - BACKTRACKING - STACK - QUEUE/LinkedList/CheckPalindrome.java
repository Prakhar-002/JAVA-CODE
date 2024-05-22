public class CheckPalindrome {

      public static LinkedListCreation.Node head = null;

      public static boolean checkPalindrome(LinkedListCreation.Node head) {
            if (head == null || head.next == null) {
                  return true;
            }
            // step 1 - finding mid node
            LinkedListCreation.Node midNode = FindMid.findMid(head);

            // reverse the node
            LinkedListCreation.Node prev = null;
            LinkedListCreation.Node cur = midNode;
            LinkedListCreation.Node next;

            while (cur != null) {
                  next = cur.next;
                  cur.next = prev;
                  prev = cur;
                  cur = next;
            }

            LinkedListCreation.Node right = prev; // right half head
            LinkedListCreation.Node left = head;

            // step-3 check first and 2nd half linked list
            while (right != null) {
                  if (left.data != right.data) {
                        return false;
                  }
                  left = left.next;
                  right = right.next;
            }
            return true;
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            head = new LinkedListCreation.Node(10);
            head.next = new LinkedListCreation.Node(20);
            head.next.next = new LinkedListCreation.Node(30);
            head.next.next.next = new LinkedListCreation.Node(40);
            // head->10->20->30->Null
            System.out.println(checkPalindrome(head));
      }

      //? Output 
      // 1. 
      //     false
}
