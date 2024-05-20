public class Zigzag {

      public static LinkedListCreation.Node head = null;

      public static void ZigZag(LinkedListCreation.Node head) {
            // find mid
            LinkedListCreation.Node slow = head;
            LinkedListCreation.Node fast = head.next;
            while (fast != null && fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;
            }

            LinkedListCreation.Node mid = slow;

            // reverse the 2nd half of list
            // current
            LinkedListCreation.Node cur = mid.next;
            // reverse
            mid.next = null;
            LinkedListCreation.Node prev = null;
            LinkedListCreation.Node next;
            while (cur != null) {
                  next = cur.next;
                  cur.next = prev;
                  prev = cur;
                  cur = next;
            }

            // divide into 2 parts
            LinkedListCreation.Node headL = head;
            LinkedListCreation.Node headR = prev;

            // taking two variable
            LinkedListCreation.Node nextL, nextR;

            // zig zag merge
            while (headL != null && headR != null) {
                  nextL = headL.next; // initializing nextL
                  nextR = headR.next; // initializing nextR

                  headL.next = headR;// zig zag
                  headR.next = nextL; // zig zag

                  // update
                  headL = nextL;
                  headR = nextR;
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            head = new LinkedListCreation.Node(10);
            head.next = new LinkedListCreation.Node(20);
            head.next.next = new LinkedListCreation.Node(30);
            head.next.next.next = new LinkedListCreation.Node(40);
            // head->10->20->30->Null
            ZigZag(head);
            LLPrint.print(head);
      }

      //? Output 
      // 1. 
      //     10->40->20->30->null

}
