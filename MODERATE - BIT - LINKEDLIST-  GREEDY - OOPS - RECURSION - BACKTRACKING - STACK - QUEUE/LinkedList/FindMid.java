public class FindMid {

      public static LinkedListCreation.Node head = null;

      // slow and fast approach to find mid node and mid value...
      public static LinkedListCreation.Node findMid(LinkedListCreation.Node head) {
            LinkedListCreation.Node slow = head;
            LinkedListCreation.Node fast = head;

            while (fast != null && fast.next != null) {
                  slow = slow.next; // +1
                  fast = fast.next.next; // +2
            }

            return slow; // our mid node
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            head = new LinkedListCreation.Node(10);
            head.next = new LinkedListCreation.Node(20);
            head.next.next = new LinkedListCreation.Node(30);
            head.next.next.next = new LinkedListCreation.Node(40);
            // head->10->20->30->Null
            LinkedListCreation.Node mid = findMid(head);
            System.out.println(mid.data);

      }

      //? Output 
      // 1. 
      //     30
      
}
