import java.util.ArrayList;

class J_40BinaryTreePart2 {
      

      static class Node {
            int data ;
            Node left ;
            Node right;

            public Node(int data){
                  this.data = data;
            }
      }

      public static void preOrder(Node root){
            if (root == null) {
                  return;
            }

            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
      }

//--------------------------------------------------------------------------------------------------------

      public static Node createBST(int arr[] , int st, int end){
            if (st > end) {
                  return null;
            }

            int mid = (st + end) /2;
            Node root = new Node(arr[mid]);
            root.left = createBST(arr, st, mid-1);
            root.right = createBST(arr, mid+1, end);
            return root;
      }

      public static Node arrayToBalanceBST(){
            int arr[] ={3, 5, 6, 8, 10, 11, 13};
            Node root =createBST(arr, 0, arr.length-1);
            return root;
      }

//--------------------------------------------------------------------------------------------------------

      public static Node unBalanceBST(){
            Node root = new Node(8);
            root.left = new Node(6);
            root.left.left = new Node(5);
            root.left.left.left = new Node(3);

            root.right = new Node(10);
            root.right.right = new Node(11);
            root.right.right.right = new Node(13);

            return root;

            //           8
            //         /   \ 
            //        6    10 
            //       /      \
            //      5        11
            //     /          \
            //    3            12
            // given BST...
      }

      public static void getInOrder(Node root , ArrayList<Integer> inOrder){
            if (root == null) {
                  return;
            }

            getInOrder(root.left, inOrder);
            inOrder.add(root.data);
            getInOrder(root.right, inOrder);
      }

      public static Node createArraylistBST(ArrayList<Integer> arr, int st , int end){
            if (st > end) {
                  return null;
            }

            int mid = (st + end)/2;
            Node root = new Node(arr.get(mid));
            root.left = createArraylistBST(arr, st, mid-1);
            root.right = createArraylistBST(arr, mid+1, end);
            return root;
      }

      public static Node balanceBST(Node root){  //O(n)...
            // inOrder Seq...
            ArrayList<Integer> inOrder = new ArrayList<>();
            getInOrder(root, inOrder);

            //sorted inOrder -> balance BST
            root = createArraylistBST(inOrder, 0, inOrder.size()-1);
            return root;
      }

//--------------------------------------------------------------------------------------------------------

      public static Node maxValidBST(){
            Node root = new Node(50);
            root.left = new Node(30);
            root.left.left = new Node(5);
            root.left.right = new Node(20);

            root.right = new Node(60);
            root.right.left = new Node(45);
            root.right.right = new Node(70);
            root.right.right.left = new Node(65);
            root.right.right.right = new Node(80);

            return root;

            //                 50
            //             /        \
            //           30          60
            //         /   \       /    \
            //        5     20   45     70
            //                         /  \
            //                        65  80
      }

      static class Info{
            boolean isBST;
            int size;
            int min;
            int max;

            public Info(boolean isBST , int size , int min , int max){
                  this.isBST = isBST;
                  this.size = size ;
                  this.min = min;
                  this.max = max;
            }
      }

      public static int maxSize =0;
      public static Info maxInfo = new Info(true , maxSize , 0 , 0);
      public static Node maxDataRoot = new Node(0);

      public static Info largestBST(Node root){
            if (root == null) {
                  return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }

            Info leftInfo = largestBST(root.left);
            Info rightInfo = largestBST(root.right);

            //my details...
            int size = leftInfo.size + rightInfo.size +1;
            int min = Math.min(root.data , Math.min(leftInfo.min , rightInfo.min));
            int max = Math.max(root.data , Math.max(leftInfo.max , rightInfo.max));

            if (root.data <=leftInfo.max || root.data >= rightInfo.min ) {
                  return new Info(false , size , min , max);
            }

            if (leftInfo.isBST && rightInfo.isBST) {
                  maxSize = Math.max(maxSize, size);
                  maxInfo.size = maxSize;
                  maxInfo.min = min;
                  maxInfo.max = max;
                  maxDataRoot.data = root.data;
                  return new Info(true, size, min, max);
            }

            return new Info(false, size, min, max);
      }

//--------------------------------------------------------------------------------------------------------
      public static Node tree1(){
            Node root = new Node(2);
            root.left = new Node(1);
            root.right = new Node(4);

            //     2
            //   /  \
            //  1    4

            return root;
      }

      public static Node tree2(){
            Node root = new Node(9);
            root.left = new Node(3);
            root.right = new Node(12);

            //     9
            //   /  \
            //  3    12

            return root;
      }

      public static Node mergeBST(Node root1 , Node root2){   //O(n)
            // first array
            ArrayList<Integer> arr1 = new ArrayList<>();
            getInOrder(root1, arr1);    // function is created before

            // 2nd array
            ArrayList<Integer> arr2 = new ArrayList<>();
            getInOrder(root2, arr2);   // function is created before

            // final array
            int i =0 ,j =0;
            ArrayList<Integer> finalArr = new ArrayList<>();
            while (i <arr1.size() && j <arr2.size() ) {
                  if (arr1.get(i)<= arr2.get(j)) {
                        finalArr.add(arr1.get(i++));
                  }else{
                        finalArr.add(arr2.get(j++));
                  }
            }

            while (i <arr1.size() ) {
                  finalArr.add(arr1.get(i++));
            }

            while (j <arr2.size() ) {
                  finalArr.add(arr2.get(j++));
            }

            return createArraylistBST(finalArr, 0, finalArr.size()-1); // function is created before
      }

//--------------------------------------------------------------------------------------------------------

      public static void main(String[] args) {

            // 1...creating balance BST from a sorted array...
            // Node root = arrayToBalanceBST();
            // preOrder(root);

            // 2...
            // Node root = unBalanceBST();
            // System.out.println("Before...");
            // preOrder(root);
            // System.out.println("\nAfter...");
            // root = balanceBST(root);
            // preOrder(root);

            // 3...
            // Node root = maxValidBST();
            // Info info = largestBST(root);
            // System.out.println("Biggest size BST valid in given tree is "+maxSize);
            // System.out.println("Details of max info..."+maxInfo.isBST+" " + maxInfo.size+" "  + maxInfo.min+" "  + maxInfo.max);  // will give last node...
            // System.out.println("Data of Biggest size BST node is "+maxDataRoot.data);

            // 4...
            // Node root1 = tree1();
            // System.out.println("root 1 preOrder...");
            // preOrder(root1);
            // Node root2 = tree2();
            // System.out.println("\nroot 1 preOrder...");
            // preOrder(root2);
            // Node finalRoot = mergeBST(root1, root2);
            // System.out.println("\final root preOrder...");
            // preOrder(finalRoot);
      }
}