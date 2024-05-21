public class QueueLinkedListImplementation {

      static class Node {
            int data;
            Node next;

            Node(int data) {
                  this.data = data;
                  this.next = null;
            }
      }

//---------------------------------------------------------------------------------------
      static class QueueLL {
            public static Node head = null;
            public static Node tail = null;

            // is empty...
            public boolean isEmpty() {
                  return head == null && tail == null;
            }

            //add...
            public void add(int data){
                  Node newNode = new Node(data);
                  // base condition
                  if( head == null){
                        head = tail = newNode;
                        return;
                  }

                  tail.next = newNode;
                  tail = newNode;
            }

            // remove...
            public int remove(){
                  if(isEmpty()){
                        System.out.println("Queue is empty please enter some node data first");
                        return -1;
                  }

                  int front = head.data;
                  if (tail == head) {
                        tail = head = null;
                  }else{
                        head = head.next;
                  }
                  return front;
            }

            // peek...
            public int peek(){
                  if(isEmpty()){
                        System.out.println("Queue is empty");
                        return -1;
                  }

                  return head.data;
            }
      }

      // queue ll call...
      public static void queueCall(){
            QueueLL ql = new QueueLL();
            ql.add(10);
            ql.add(20);
            ql.add(75);

            while (!ql.isEmpty()) {
                  System.out.println(ql.peek());
                  ql.remove();
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            queueCall();
      }

      // ? Output
      //  1.
      //     10
      //     20
      //     75
}
