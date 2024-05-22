public class RemoveFromEnd {

      public static LinkedListCreation.Node head = null;

      public static void removeDataNthFromEnd(LinkedListCreation.Node head, int n, int size ) {
            if (n == size) { // if head is removing
                  head = head.next;
                  return;
            }

            LinkedListCreation.Node prev = head;
            for (int i = 1; i < size - n; i++) {
                  prev = prev.next;
            }

            // changing the next position
            prev.next = prev.next.next;
            return;
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            head = new LinkedListCreation.Node(10);
            head.next = new LinkedListCreation.Node(20);
            head.next.next = new LinkedListCreation.Node(30);
            head.next.next.next = new LinkedListCreation.Node(40);
            // head->10->20->30->Null
            removeDataNthFromEnd(head, 2, 3);
            LLPrint.print(head);
      }

      //? Output 
      // 1. 
      //     10->30->40->null
}
