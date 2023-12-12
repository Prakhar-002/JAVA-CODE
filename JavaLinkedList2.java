public class JavaLinkedList2 {

      public static class Node{
            int data;
            Node next;

            public Node(int data){
                  this.data =data;
            }
      }

      public static Node head = null;
      public static Node tail = null;
      public static int size = 0;
// -----------------------------------------------------------------------------------------

      public static boolean isCycle(){  // Floyd's cycle finder...
            Node slow =head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                  slow = slow.next;  // +1
                  fast = fast.next.next; // +2

                  if (fast == slow) { 
                        return true; // cycle exist...
                  }
            }

            return false;  // cycle doesn't exist... 
      }

      public static void isCycleCall(){
            head = new Node(10);
            head.next =new Node(20);
            head.next.next = new Node(30);
            head.next.next.next = new Node(40);
            head.next.next.next.next =head.next;
            // head->10->20->30->head
            System.out.println(isCycle());
      }

// -----------------------------------------------------------------------------------------
      public static void removeCycleInLL(){
            // detect loop
            Node slow =head;
            Node fast= head;
            Node prev =null;

            while (fast !=null && fast.next != null) {
                  slow =slow.next;
                  fast =fast.next.next;

                  if(slow == fast ){ // we detect node 
                        slow =head;
                        while( slow != fast){
                              slow =slow.next;
                              prev= fast;
                              fast =fast.next;
                        }
                        prev.next =null;
                        break;
                  }
            }

            
      }

      public static void removeCycleInLL1(){
            // detect loop
            Node slow =head;
            Node fast= head;
            boolean cycle =false;

            while (fast !=null && fast.next != null) {
                  slow =slow.next;
                  fast =fast.next.next;
                  if(fast == slow ){ // we detect node 
                        cycle =true;
                        break;
                  }
            }

            if (cycle == false ) {
                  return;
            }

            // finding meeting point 
            slow =head ;
            Node prev =null ;// last node
            while (slow !=fast) {
                  slow = slow.next;
                  prev =fast ;
                  fast =fast.next;
            }

            // set last node null
            prev.next =null;
      }

      public static void llCall(){
            isCycleCall();
            removeCycleInLL1();
            System.out.println(isCycle());
      }

// -----------------------------------------------------------------------------------------



// -----------------------------------------------------------------------------------------

      public static void main(String[] args) {
            
      }
}
