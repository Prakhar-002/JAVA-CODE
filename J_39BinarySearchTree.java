import java.util.ArrayList;

public class J_39BinarySearchTree {
      // BST searching time is O(H)  height of the tree...(O(n) ... of binary tree)
      // a. Left Subtree Nodes < Root
      // b. Right Subtree Nodes > Root
      // c. Left & Right Subtrees are also BST with no duplicates.

      static class Node{
            int data ;
            Node left;
            Node right;

            Node(int data){
                  this.data = data;
            }
      }

//--------------------------------------------------------------------------------------------

      public static Node insertBST(Node root, int val){
            if (root == null) {
                  root = new Node(val);
                  return root;
            }

            if (root.data > val) {
                  // left sub tree...
                  root.left = insertBST(root.left, val);
            }else{
                  // right sub tree...
                  root.right = insertBST(root.right, val);
            }

            return root;
      }

//--------------------------------------------------------------------------------------------

      public static void inOrderTraversal(Node root){
            if (root == null) {
                  return;
            }
            inOrderTraversal(root.left );
            System.out.print(root.data+" ");
            inOrderTraversal(root.right);
      }

//--------------------------------------------------------------------------------------------

      public static Node BST(){
            int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
            // int values[] = { 1, 1, 1};
            // int values[] = {8, 5, 10, 3, 6, 11};
            Node root = null;

            for (int i = 0; i < values.length; i++) {
                  root = insertBST(root , values[i]);
            }

            return root;
      }

//--------------------------------------------------------------------------------------------

      public static boolean binarySearch(Node root , int key){
            if (root == null) {
                  return false;
            }

            if (root.data == key) {
                  return true;
            }

            if (root.data > key) {
                  return binarySearch(root.left, key);
            }else {
                  return binarySearch(root.right, key);
            }
      }

//--------------------------------------------------------------------------------------------

      public static Node delete(Node root , int val){
            if (root.data < val) {
                  root.right = delete(root.right, val);
            }

            else if (root.data > val) {
                  root.left = delete(root.left, val);
            } 

            else {// voila
                  // case 1 - leaf node
                  if (root.left == null && root.right == null) {
                        return null;
                  }

                  // case 2 - single child
                  if(root.left ==null){
                        return root.right;
                  }

                  else if( root.right == null){
                        return root.left;
                  }

                  // case 3 - two child node ...
                  Node IS = findInOrderSuccessor(root.right);
                  root.data = IS.data;
                  root.right = delete(root.right, IS.data);
            }

            return root;
      }

      public static Node findInOrderSuccessor(Node root){
            while (root.left != null) {
                  root = root.left;
            }

            return root;
      }

//--------------------------------------------------------------------------------------------

      public static void printInRange(Node root , int k1 , int k2){
            if (root == null) {
                  return;
            }

            if (root.data >= k1 && root.data <= k2) {
                  printInRange(root.left, k1, k2);
                  System.err.print(root.data +" ");
                  printInRange(root.right, k1, k2);
            }

            else if(root.data < k1){
                  printInRange(root.left, k1, k2);
            }

            else{
                  printInRange(root.right, k1, k2);
            }
      }

//--------------------------------------------------------------------------------------------

      public static void printRoot2Leaf(Node root , ArrayList<Integer> path){
            if (root == null) {
                  return;
            }

            path.add(root.data);  // add first node
            if (root.right == null && root.left == null) {
                  System.out.println(path + " -->NULL");
            }

            printRoot2Leaf(root.left , path);
            printRoot2Leaf(root.right , path);
            path.remove(path.size()-1);  // delete last node before backtracking...
      }

//--------------------------------------------------------------------------------------------

      public static boolean isValidateBST(Node root ,Node min , Node max){
            if (root == null) {
                  return true;
            }

            if (min != null && root.data <= min.data) {
                  return false;
            }

            else if(max != null && root.data >= max.data){
                  return false;
            }

            return isValidateBST(root.left, min, root) && isValidateBST(root.right, root, max);
      }

//--------------------------------------------------------------------------------------------

      public static Node mirrorTree(Node root){
            if (root == null) {
                  return null;
            }

            Node leftMirror = mirrorTree(root.left);
            Node rightMirror = mirrorTree(root.right);

            root.left = rightMirror;
            root.right = leftMirror;

            return root;
      }

      public static void preOrder(Node root){
            if (root == null) {
                  return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
      }

//--------------------------------------------------------------------------------------------

      public static void main(String[] args) {
            Node root =BST();

            // 1...
            // inOrder traversing...
            System.out.println("inOrderTraversal --->");
            inOrderTraversal(root);
            System.out.println();

            // 2...
            // search in a BST...
            // System.out.println("searching --->");
            // System.out.println(binarySearch(root, 4));

            // 3...
            // System.out.println("deleting --->");
            // delete(root, 10);
            // System.out.println("after inOrderTraversal --->");
            // inOrderTraversal(root);
            // System.out.println();

            // 4...
            // System.out.println("Print in Range --->");
            // printInRange(root, 4, 11);

            // 5...
            // printRoot2Leaf(root, new ArrayList<>());

            // 6...
            // if (isValidateBST(root, null, null)) {
            //       System.out.println("Valid...");
            // }else{
            //       System.out.println("Not Valid...");
            // }

            // 7... mirror image...
            // System.out.println("Mirror of a tree is ...");
            // mirrorTree(root);
            // preOrder(root);
            // System.out.println();

      }
}
