public class MergeSort {

      public static class Node {
            int data; // data
            Node next; // next pointer

            // constructor
            public Node(int data) {
                  this.data = data;
                  this.next = null;
            }
      }

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
}
