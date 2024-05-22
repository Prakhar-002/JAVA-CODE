public class DoublyLinkedList {
      public class Node {
            int data;
            Node next;
            Node prev;

            // constructor
            public Node(int data) {
                  this.data = data;
                  next = null;
                  prev = null;
            }
      }

      // ----------------------------------------------------------------------------------------

      public static Node head = null;
      public static Node tail = null;
      public static int size = 0;

      public void addFirst(int data) {
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                  head = tail = newNode;
                  return;
            }

            newNode.next = head;
            head.prev = newNode;
            head = newNode;
      }

      // ----------------------------------------------------------------------------------------

      public void removeFirst() {
            if (head == null) {
                  System.out.println("Empty linked list...");
                  return;
            }

            if (size == 1) {
                  System.out.println("Removed data is :" + head.data);
                  head = tail = null;
                  size--;
                  return;
            }

            System.out.println("Removed data is : " + head.data);
            head = head.next;
            head.prev = null;
            size--;
      }

      // ----------------------------------------------------------------------------------------

      public void removeLast() {
            if (tail == null) {
                  System.out.println("doubly linked list is not available...");
                  return;
            }
            System.out.println("removed data is : " + tail.data);
            tail = tail.prev;
            tail.next = null;
            size--;
      }

      // ----------------------------------------------------------------------------------------

      public void print() {
            Node temp = head;
            System.out.print("null <-> ");
            while (temp != null) {
                  System.out.print(temp.data + " <-> ");
                  temp = temp.next;
            }
            System.out.println("null");
      }

      // ----------------------------------------------------------------------------------------

      public void reverseDl() {
            Node cur = head;
            Node prev = null;
            Node next;

            while (cur != null) {
                  next = cur.next;
                  cur.next = prev;
                  cur.prev = next;

                  prev = cur;
                  cur = next;
            }
            head = prev;
      }

      public static void main(String[] args) {
            DoublyLinkedList dualList = new DoublyLinkedList();
            dualList.addFirst(10);
            dualList.addFirst(20);
            dualList.addFirst(50);
            dualList.addFirst(420);

            dualList.print();

            dualList.removeLast();

            dualList.print();

            dualList.removeFirst();

            dualList.print();

            dualList.reverseDl();
            dualList.print();
      }

      // ? Output
      //  1.
      //      null <-> 420 <-> 50 <-> 20 <-> 10 <-> null
      //      removed data is : 10
      //      null <-> 420 <-> 50 <-> 20 <-> null
      //      Removed data is : 420
      //      null <-> 50 <-> 20 <-> null
      //      null <-> 20 <-> 50 <-> null
}
