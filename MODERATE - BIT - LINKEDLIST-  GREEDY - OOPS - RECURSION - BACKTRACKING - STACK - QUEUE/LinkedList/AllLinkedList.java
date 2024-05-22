public class AllLinkedList {

      public class Node {
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

// ------------------------------------------------------------------------------------
      // linear search ...
      public int linearSearch(int key) {
            Node temp = head;
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

// ------------------------------------------------------------------------------------

      public int helper(Node head, int key) { // O(n) && O(n) space
            if (head == null) {
                  return -1;
            }

            if (head.data == key) {
                  return 0;
            }
            int idx = helper(head.next, key);
            if (idx == -1) {
                  return -1;
            }

            return idx + 1;
      }

      public int recursiveSearch(int key) {
            return helper(head, key);
      }

// ------------------------------------------------------------------------------------

      public void print() { // O(n)
            // base condition
            if (head == null) {
                  System.out.println("Linked list is not available...");
                  return;
            }
            Node temp = head;
            while (temp != null) {
                  System.out.print(temp.data + "->");
                  temp = temp.next;
            }
            System.out.println("null");
      }

// ------------------------------------------------------------------------------------

      public void reverseLinkedList() {
            Node prev = null;
            Node cur = tail = head;
            Node next;

            while (cur != null) {
                  next = cur.next;
                  cur.next = prev;
                  prev = cur;
                  cur = next;
            }

            head = prev;

      }
// ------------------------------------------------------------------------------------

      public void removeDataNthFromEnd(int n) {
            if (n == size) { // if head is removing
                  head = head.next;
                  return;
            }

            Node prev = head;
            for (int i = 1; i < size - n; i++) {
                  prev = prev.next;
            }

            // changing the next position
            prev.next = prev.next.next;
            return;
      }

// -----------------------------------------------------------------------------------------
      // slow and fast approach to find mid node and mid value...
      public Node findMid(Node head) {
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                  slow = slow.next; // +1
                  fast = fast.next.next; // +2
            }

            return slow; // our mid node
      }

      public boolean checkPalindrome() {
            if (head == null || head.next == null) {
                  return true;
            }
            // step 1 - finding mid node
            Node midNode = findMid(head);

            // reverse the node
            Node prev = null;
            Node cur = midNode;
            Node next;

            while (cur != null) {
                  next = cur.next;
                  cur.next = prev;
                  prev = cur;
                  cur = next;
            }

            Node right = prev; // right half head
            Node left = head;

            // step-3 check first and 2nd half linked list
            while (right != null) {
                  if (left.data != right.data) {
                        return false;
                  }
                  left = left.next;
                  right = right.next;
            }
            return true;
      }

// -----------------------------------------------------------------------------------------
      public void ZigZag(){
            // find mid 
            Node slow = head ;
            Node fast = head.next ;
            while(fast != null && fast.next != null){
                  slow = slow.next ;
                  fast = fast.next.next;
            }

            Node mid = slow;

            // reverse the 2nd half of list 
            // current
            Node cur = mid.next;
            // reverse
            mid.next = null;
            Node prev = null;
            Node next ;
            while(cur != null ){
                  next = cur.next;
                  cur.next = prev;
                  prev = cur;
                  cur = next;
            }

            // divide into 2 parts 
            Node headL = head ;
            Node headR = prev ;

            // taking two variable 
            Node nextL, nextR;

            // zig zag merge 
            while(headL != null && headR != null ){
                  nextL = headL.next ; // initializing nextL
                  nextR = headR.next ; //initializing nextR

                  headL.next = headR ;// zig zag
                  headR.next = nextL; // zig zag 

                  // update
                  headL = nextL;
                  headR = nextR;
            }
      }

// -----------------------------------------------------------------------------------------

      public static void LinkedList1Call() {
            AllLinkedList list = new AllLinkedList(); // we'll access from this
            list.addFirst(10); // add first data
            // list.print();
            list.addFirst(20); // add 2nd data
            // list.print();
            list.addLast(30); // last add 3rd data
            // list.print();
            list.addLast(40); // last add 4th data
            // adding at an index
            list.add(0, 75);
            list.print(); // printing
            System.out.println("size of linked list is :" + size);
            System.out.println("node is deleted of value :" + list.removeLast());
            list.print();
            System.out.println("value found at position (index) :" + list.recursiveSearch(30));
            list.reverseLinkedList();
            list.print();
            list.removeDataNthFromEnd(2);
            list.print();
            boolean palindrome = list.checkPalindrome();
            System.out.println(palindrome);
      }

// -----------------------------------------------------------------------------------------
      // merge sort in linked list...
      private Node getMid(Node head){
            Node slow = head;
            Node fast = head.next; // for getting left part last node as a mid value

            while (fast !=null && fast.next!=null) {
                  slow = slow.next;   //+1
                  fast = fast.next.next; // +2
            }

            return slow;  // mid value
      }

      private Node merge(Node headL, Node headR){
            // this will merge all the sorted linked list 
            Node mergedList = new Node(-1); // creating a temp list 
            Node temp = mergedList; // taking a variable 

            while (headL != null && headR != null) { // WE'll merge the data after the sort 
                  if(headL.data <= headR.data){
                        temp.next = headL;
                        headL = headL.next;
                        temp = temp.next;
                  }else{
                        temp.next = headR;
                        headR = headR.next;
                        temp = temp.next;
                  }
            }

            while (headL != null) { // remaining part of first linked list...
                  temp.next = headL;
                  headL = headL.next;
                  temp = temp.next;
            }

            while (headR !=null) {  // remaining part of second linked list...
                  temp.next = headR;
                  headR = headR.next;
                  temp = temp.next;
            }

            return mergedList.next;
      }

      public Node mergeSort(Node head){
            // base condition
            if(head == null || head.next == null){
                  return head;
            }
            // find mid
            Node midNode = getMid(head);
            Node rightHead = midNode.next; // store right head part in a variable
            midNode.next = null; // dividing ll in two parts 

            // merge fun call for left part
            Node newLeft = mergeSort(head);
            // merge fun call for right part
            Node newRight = mergeSort(rightHead); 

            // calling merge function for sorted list to merge all these...
            return merge(newLeft, newRight);
      }
// -----------------------------------------------------------------------------------------

      public static void main(String[] args) {
            // LinkedList1Call();
            AllLinkedList list = new AllLinkedList(); // we'll access from this
            list.addFirst(40); // add first data
            list.addFirst(20); // add 2nd data
            list.addLast(50); // last add 3rd data
            list.addLast(40); // last add 4th data
            // adding at an index
            list.add(0, 75);
            list.print();
            // list.head = list.mergeSort(list.head);
            list.print();
            list.ZigZag();
            list.print();
      }
}