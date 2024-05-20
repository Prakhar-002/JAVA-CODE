public class LLPrint {

      public static void print(LinkedListCreation.Node head) { // O(n)
            // base condition
            if (head == null) {
                  System.out.println("Linked list is not available...");
                  return;
            }
            LinkedListCreation.Node temp = head;
            while (temp != null) {
                  System.out.print(temp.data + "->");
                  temp = temp.next;
            }
            System.out.println("null");
      }

}
