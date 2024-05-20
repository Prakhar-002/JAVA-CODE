public class LinearSearch {

      public static LinkedListCreation.Node head = null;

      public static int linearSearch(LinkedListCreation.Node head, int key) {
            LinkedListCreation.Node temp = head;
            int i = 0;

            while (temp != null) {
                  if (temp.data == key) {
                        return i;
                  }
                  temp = temp.next;
                  i++;
            }

            // value not found
            return -1;
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            head = new LinkedListCreation.Node(10);
            head.next = new LinkedListCreation.Node(20);
            head.next.next = new LinkedListCreation.Node(30);
            head.next.next.next = new LinkedListCreation.Node(40);
            // head->10->20->30->Null
            System.out.println(linearSearch(head, 30));

      }

      //? Output 
      // 1. 
      //     2
}
