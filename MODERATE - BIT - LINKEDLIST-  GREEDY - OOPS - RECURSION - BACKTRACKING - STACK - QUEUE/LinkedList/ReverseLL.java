public class ReverseLL {

      public static LinkedListCreation.Node head = null;

      public static LinkedListCreation.Node reverseLinkedList(LinkedListCreation.Node head) {
            LinkedListCreation.Node prev = null;
            LinkedListCreation.Node cur = head;
            LinkedListCreation.Node next;

            while (cur != null) {
                  next = cur.next;
                  cur.next = prev;
                  prev = cur;
                  cur = next;
            }

            head = prev;

            return head;
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            head = new LinkedListCreation.Node(10);
            head.next = new LinkedListCreation.Node(20);
            head.next.next = new LinkedListCreation.Node(30);
            head.next.next.next = new LinkedListCreation.Node(40);
            // head->10->20->30->Null
            head = reverseLinkedList(head);
            LLPrint.print(head);
      }

      //? Output 
      // 1. 
      //     40->30->20->10->null
}
