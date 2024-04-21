import java.util.*;

public class JavaStackLinkedList {
      static class Node{
            int data;
            Node next;
            Node(int data){
                  this.data = data;
                  this.next = null;
            }
      }
      static class StackBasic {
            static Node head = null;

            // isEmpty 
            static boolean isEmpty(){
                  return head == null;
            }

            // push 
            static void push(int data){
                  Node newNode = new Node(data);
                  if(isEmpty()){
                        head = newNode;
                        return;
                  }
                  newNode.next = head;
                  head = newNode;
            }

            // pop
            static int pop(){
                  if (isEmpty()) {
                        return -1;
                  }
                  int top = head.data;
                  head = head.next;
                  return top;
            }

            // peek
            static int peek(){
                  if (isEmpty()) {
                        return -1;
                  }
                  return head.data;
            }
      }

      public static void stackCall(){
            // StackBasic s = new StackBasic();  // -->trough basics
            Stack<Integer> s = new Stack<>();   // --> in build Stack

            s.push(10);
            s.push(50);
            s.push(40);

            while (!s.isEmpty()) {
                  System.out.println(s.peek());
                  s.pop();
            }
      }

      public static void pushBottom(Stack<Integer> s, int data){
            if(s.isEmpty()){
                  s.push(data);
                  return;
            }

            int top = s.pop();
            pushBottom(s, data);
            s.push(top);
      }

      public static void pushBottomCall(){
            Stack<Integer> s = new Stack<>();   // --> in build Stack
            s.push(10);
            s.push(20);
            s.push(30);

            pushBottom(s,50);

            printStack(s);
      }

      public static void printStack(Stack <Integer> s){
            while (!s.isEmpty()) {
                  System.out.println(s.pop());
            }
      }

//---------------------------------------------------------------------------------------

      public static String reverseString(String str){
            Stack <Character> s = new Stack<>();
            int idx = 0;
            // copy data into stack
            while (idx < str.length()) {
                  s.push(str.charAt(idx));
                  idx++;
            }

            // new stringBuilder
            StringBuilder result = new StringBuilder();
            // copying the data into the sb 
            while (!s.isEmpty()) {
                  result.append(s.pop());
            }

            return result.toString();
      }

      public static void reverseStringCall(){
            System.out.println(reverseString("abcde"));
      }

//-----------------------------------------------------------------------------------------
      public static void reverseStack(Stack<Integer> s){
            if(s.isEmpty()){
                  return;
            }

            int top = s.pop();
            reverseStack(s);
            pushBottom(s, top);
      }

      public static void reverseStackCall(){
            Stack<Integer> s = new Stack<>();   // --> in build Stack
            System.out.println("before");
            s.push(10);
            s.push(20);
            s.push(30);

            while (!s.isEmpty()) {
                  System.out.println(s.pop());
            }

            s.push(10);
            s.push(20);
            s.push(30);

            reverseStack(s);
            System.out.println("after");
            while (!s.isEmpty()) {
                  System.out.println(s.pop());
            }
      }

//---------------------------------------------------------------------------------------
      public static void stockStack(int stock[] , int span[]){
            Stack<Integer> s = new Stack<>();
            span[0] = 1;
            s.push(0);

            for(int i = 1; i<stock.length; i++){
                  int curPrice = stock[i];
                  while(!s.isEmpty() && curPrice > stock[s.peek()]){
                        s.pop();
                  }
                  if(s.isEmpty()){
                        span[i] = i+1;
                  }else{
                        int prevHeight = s.peek();
                        span[i] = i-prevHeight;
                  }

                  s.push(i);
            }
      }

      public static void stockStackCall(){
            int stock[] = {100, 80 ,60,70,80,85,100};
            int span[] = new int[stock.length];
            stockStack(stock , span);

            // print the span
            System.out.println("Span data...");
            for (int i = 0; i < span.length; i++) {
                  System.out.print(span[i] +" ");
            }
      }

//---------------------------------------------------------------------------------------
      public static void nextGreater(){
            int arr[] = {6 ,8, 0 ,1 , 3};
            Stack <Integer> s = new Stack<>();
            int nextGreater[] = new int[arr.length];

            for(int i = arr.length-1; i >= 0; i--){
                  // 1 while
                  while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                        s.pop();
                  }

                  //2 if-else 
                  if(s.isEmpty()){
                        nextGreater[i] = -1;
                  }else{
                        nextGreater[i] = arr[s.peek()];
                  }

                  // 3 push in stack
                  s.push(i);
            }

            // print nextGreater
            for (int i = 0; i < nextGreater.length; i++) {
                  System.out.print(nextGreater[i] + " ");
            }
            System.out.println();

            // more que
            // next greater right  int i = arr.length-1; i >=0 ; i--
            // next greater left  int i = 0; i <arr.length ; i++
            // next smaller left int i = 0; i <arr.length ; i++ && arr[s.peek()] >= arr[i]
            // next smaller right int i = arr.length-1; i >=0 ; i-- && arr[s.peek()] >= arr[i]
      }

//---------------------------------------------------------------------------------------
      public static boolean validParenthesis(String str){   //O(n)
            Stack <Character> s = new Stack<>();

            for(int i = 0; i< str.length(); i++){
                  char ch = str.charAt(i);

                  //opening 
                  if( ch == '(' ||  ch == '{' ||  ch == '[' ){
                        s.push(ch);
                  }else{
                        // closing 
                        if(s.isEmpty()){
                              return false;
                        }

                        if(   (s.peek() == '(' && ch == ')' ) || // ()
                              (s.peek() == '{' && ch == '}' ) || // {}
                              (s.peek() == '[' && ch == ']' )) { // []
                                    s.pop();
                              }else{
                                    return false;
                              }
                  }
            }

            if(s.isEmpty()){
                  return true;
            }else{
                  return false;
            }
      }

      public static void validParenthesisCall(){
            boolean ans = validParenthesis("({}(){})");
            if (ans) {
                  System.out.println("string is valid parenthesis...");
            }else{
                  System.out.println("string is not a valid parenthesis...");
            }
      }

//---------------------------------------------------------------------------------------
      public static void duplicateParentheses(String str){   // O(n)
            Stack<Character> s = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                  char ch = str.charAt(i);

                  // closing tag 
                  if(ch == ')'){
                        int count = 0 ;
                        while(s.peek() != '('){  // !str.isEmpty() -> not necessary
                              count++;
                              s.pop();
                        }

                        if(count < 1){  // duplicate condition
                              System.out.println(str + " -- It is a duplicate parentheses ");
                              return;
                        }else{
                              s.pop();  // opening pair remove
                        }
                  }else{
                        // opening condition
                        s.push(ch);
                  }
            }

            System.out.println(str+" -- It is a not duplicate parentheses ");
      }

      public static void duplicateParenthesesCall(){
            duplicateParentheses("((a+b)+(o-k)())");  // false
            duplicateParentheses("((a+b)+(o-k)+(l-k))");  // true
      }

//---------------------------------------------------------------------------------------
      public static void maxHistogram(int arr[]){  //...O(n)
            int nsr[] = new int[arr.length];
            int nsl[] = new int[arr.length];
            int maxArea =0;
            // next smaller right  ...O(n)
            Stack<Integer> s = new Stack<>();
            for (int i = arr.length-1; i >= 0; i--) {
                  if(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                        s.pop();
                  }
                  if(s.isEmpty()){
                        nsr[i] = arr.length;
                  }else{
                        nsr[i] = s.peek();
                  }
                  s.push(i);
            }
            // next smaller left ...O(n)
            s = new Stack<>();
            for (int i = 0; i <arr.length; i++) {
                  if(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                        s.pop();
                  }
                  if(s.isEmpty()){
                        nsl[i] = -1;
                  }else{
                        nsl[i] = s.peek();
                  }
                  s.push(i);
            }
            // current area  max area = j-i-1  ; nsr[i] - nsl[i] -1
            for (int i = 0; i < arr.length; i++) {   //...O(n)
                  int height = arr[i];
                  int width = nsr[i] - nsl[i] - 1;
                  int curArea = height*width;
                  maxArea = Math.max(maxArea, curArea);
            }
            // print 
            System.out.println("max histogram area is : "+maxArea);
      }

      public static void maxHistogramCall(){
            int arr[]= {2,1,5,6,2,3};
            maxHistogram(arr);
      }


//---------------------------------------------------------------------------------------

      public static void main(String[] args) {
            System.out.println("Welcome to the world of STACK...");
            //StackBasic s= new StackBasic();  // -->trough basics
            // 1 ...stackCall();
            // 2... pushBottomCall();
            // 3...reverseStringCall();
            // 4...reverseStackCall();
            // 5...stockStackCall();
            // 6...nextGreater();
            // 7...validParenthesisCall();
            // 8...duplicateParenthesesCall();
            // 9...maxHistogramCall();
      }
}
