public class LinkedListCreation {

      public static class Node {
            int data; // data
            Node next; // next pointer

            // constructor
            public Node(int data) {
                  this.data = data;
                  this.next = null;
            }
      }

// ------------------------------------------------------------------------------------

      // head and tail node
      public static Node head = null;
      public static Node tail = null;
      public static int size = 0;

      public void addFirst(int data) { // O(1)
            // step 1
            Node newNode = new Node(data); // create a node
            size++;

            // base condition
            if (head == null) {
                  head = tail = newNode;
                  return;
            }

            // step 2 // link next
            newNode.next = head;

            // step 3
            head = newNode;
      }

// ------------------------------------------------------------------------------------

      public void addLast(int data) {
            // step 1
            Node newNode = new Node(data); // create a node
            size++;

            // base condition
            if (head == null) {
                  head = tail = newNode;
                  return;
            }

            // step 2 // link next
            tail.next = newNode;

            // step 3
            tail = newNode;
      }

// ------------------------------------------------------------------------------------

      public void add(int idx, int data) {
            // base case
            if (idx == 0) {
                  addFirst(data);
                  return;
            }
            Node newNode = new Node(data);
            size++;
            int i = 0;
            Node temp = head;

            while (i < idx - 1) {
                  i++;
                  temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
      }

// ------------------------------------------------------------------------------------

      public int removeFirst() {
            if (size == 0) {
                  System.out.println("linked list is empty...");
                  return Integer.MIN_VALUE;
            } else if (size == 1) {
                  int val = head.data;
                  head = tail = null;
                  size = 0;
                  return val;
            }
            int val = head.data;
            head = head.next;
            size--;
            return val;
      }

// ------------------------------------------------------------------------------------

      public int removeLast() {
            if (size == 0) {
                  System.out.println("linked list is empty...");
                  return Integer.MIN_VALUE;
            } else if (size == 1) {
                  int val = head.data;
                  head = tail = null;
                  size = 0;
                  return val;
            }
            Node prev = head;
            for (int i = 0; i < size - 2; i++) {
                  prev = prev.next;
            }
            int val = prev.next.data;
            prev.next = null;
            tail = prev;
            size--;
            return val;
      }

}
