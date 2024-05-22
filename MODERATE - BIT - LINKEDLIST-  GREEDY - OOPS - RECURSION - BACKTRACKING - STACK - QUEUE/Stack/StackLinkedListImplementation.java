import java.util.*;

public class StackLinkedListImplementation {
      static class Node {
            int data;
            Node next;

            Node(int data) {
                  this.data = data;
                  this.next = null;
            }
      }

      static class StackBasic {
            static Node head = null;

            // isEmpty
            static boolean isEmpty() {
                  return head == null;
            }

            // push
            static void push(int data) {
                  Node newNode = new Node(data);
                  if (isEmpty()) {
                        head = newNode;
                        return;
                  }
                  newNode.next = head;
                  head = newNode;
            }

            // pop
            static int pop() {
                  if (isEmpty()) {
                        return -1;
                  }
                  int top = head.data;
                  head = head.next;
                  return top;
            }

            // peek
            static int peek() {
                  if (isEmpty()) {
                        return -1;
                  }
                  return head.data;
            }
      }

      public static void stackCall() {
            // StackBasic s = new StackBasic(); // -->trough basics
            Stack<Integer> s = new Stack<>(); // --> in build Stack

            s.push(10);
            s.push(50);
            s.push(40);

            while (!s.isEmpty()) {
                  System.out.println(s.peek());
                  s.pop();
            }
      }


      public static void printStack(Stack<Integer> s) {
            while (!s.isEmpty()) {
                  System.out.println(s.pop());
            }
      }

      public static void main(String[] args) {
            System.out.println("Welcome to the world of STACK...");
            // StackBasic s= new StackBasic(); // -->Trough basics
            stackCall();
      }

      // ? Output
      //  1.
      //     Welcome to the world of STACK...
      //     40
      //     50
      //     10
}
