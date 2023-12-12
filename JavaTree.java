import java.util.*;

public class JavaTree {
      static class Node{
            int data;
            Node left;
            Node right;

            Node(int data){
                  this.data =data ;
                  this.left =null;
                  this.right =null;
            }
      }

      public static boolean isIdentical(Node node , Node subNode){
            if (node == null && subNode == null) {
                  return true ;
            }else if (node == null || subNode == null || node.data != subNode.data) {
                  return false;
            }

            if (!isIdentical(node.left, subNode.left)) {
                  return false;
            }

            if (!isIdentical(node.right, subNode.right)) {
                  return false;
            }

            return true;

      }

      public static boolean isSubTree(Node root , Node subTree){
            if (root == null) {
                  return false;
            }

            if (root.data == subTree.data) {
                  if (isIdentical(root , subTree)) {
                        return true;
                  }
            }

            return isSubTree(root.left, subTree) || isSubTree(root.right, subTree);
      }

//---------------------------------------------------------------------------------------------

      static class Info {
            Node node;
            int hd ;  // Horizontal height...
            public Info(Node node , int hd){
                  this.node = node ;
                  this.hd = hd ;
            }
      }

      public static void topView(Node root){
            // Level order...
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer , Node> map = new HashMap<>();

            int min = 0,max = 0;
            q.add(new Info(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                  Info cur = q.remove();

                  if (cur == null) {
                        if (q.isEmpty()) {
                              break;
                        }else{
                              q.add(null);
                        }
                  }else{

                        if (!map.containsKey(cur.hd)) {  // first time occurring ...
                              map.put(cur.hd, cur.node);
                        }

                        if (cur.node.left != null) {
                              q.add(new Info(cur.node.left, cur.hd-1));
                              min = Math.min(min, cur.hd-1);
                        }

                        if (cur.node.right != null) {
                              q.add(new Info(cur.node.right, cur.hd+1));
                              max = Math.max(max, cur.hd+1);
                        }
                  }
            }

            // printing...
            for(int i = min ; i<=max ; i++){
                  System.out.print(map.get(i).data +" ");
            }
            System.out.println();
      }

//---------------------------------------------------------------------------------------------

      public static void kLevel(Node root ,int level ,int k){
            if (root == null) {
                  System.out.println("no K level found...");
                  return;
            }

            if(level == k){
                  System.out.print(root.data +" ");
                  return;
            }

            kLevel(root.left, level+1, k);
            kLevel(root.right, level+1, k);
      }

//---------------------------------------------------------------------------------------------

      public static boolean getPath(Node root ,int n ,ArrayList<Node> path){
            if (root == null) {
                  return false;
            }

            path.add(root);

            if (root.data == n) {
                  return true;
            }

            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);

            if (foundRight || foundLeft) {
                  return true;
            }

            path.remove(path.size()-1);
            return false;
      }

      public static Node lowestCommonAncestor(Node root , int n1 , int n2){  //O(n)
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            // lCA
            int i = 0;
            for (;i< path1.size() && i<path2.size(); i++) {
                  if (path1.get(i) != path2.get(i)) {
                        break;
                  }
            }

            // last equal node -> i-1st
            Node lca = path1.get(i-1);
            return lca;
      }

//---------------------------------------------------------------------------------------------

      public static Node lca(Node root , int n1 , int n2){
            if (root == null || root.data == n1 || root.data == n2) {
                  return root;
            }

            Node leftLCA = lca(root.left, n1, n2);
            Node rightLCA = lca(root.right, n1, n2);

            if (rightLCA == null) {
                  return leftLCA;
            }

            if (leftLCA == null) {
                  return rightLCA;
            }

            return root;
      }

//---------------------------------------------------------------------------------------------
      // minimum distance btw two nodes---->
      public static int lcaDistance(Node root,int n){
            if (root == null) {
                  return -1;
            }

            if (root.data == n) {
                  return 0;
            }

            int leftDist = lcaDistance(root.left, n);
            int rightDist = lcaDistance(root.right, n);

            if (leftDist == -1 && rightDist == -1) {
                  return -1 ;
            }else if(leftDist == -1){
                  return rightDist+1;
            }else{
                  return leftDist+1;
            }
      }

      public static int minDist(Node root , int n1 , int n2){
            Node lca = lca(root, n1, n2);
            int dist1 = lcaDistance(lca, n1);
            int dist2 = lcaDistance(lca, n2);

            return dist1 + dist2;
      }

//---------------------------------------------------------------------------------------------
      // Kth ancestor program...
      public static int KthAncestor(Node root , int n , int k){
            if (root == null) {
                  return -1;
            }

            if (root.data == n) {
                  return 0;
            }

            int leftDist = KthAncestor(root.left, n, k);
            int rightDist = KthAncestor(root.right, n, k);

            if (leftDist == -1 && rightDist == -1) {
                  return -1;
            }

            int max = Math.max(leftDist, rightDist);

            if (max+1 == k) {
                  System.out.println(k+"th Ancestor of "+n+" is : "+root.data);
            }

            return max+1;
      }

//---------------------------------------------------------------------------------------------

      public static int transformToSumTree(Node root){
            if (root == null) {
                  return 0;
            }

            int lefSum = transformToSumTree(root.left);
            int rightSum = transformToSumTree(root.right);

            int newLeft = root.left ==null ? 0 :root.left.data;
            int newRight =root.right == null ? 0 : root.right.data;

            int data = root.data;
            root.data = newLeft + lefSum + newRight + rightSum;

            return data;
      }

      public static void preOrder(Node root){
            if (root == null) {
                  return;
            }

            System.out.print(root.data +" ");
            preOrder(root.left);
            preOrder(root.right);
      }

      public static void main(String[] args) {
            // 1st tree...

            //        1
            //      /   \
            //     2     3
            //    / \   / \
            //   4  5  6  7

            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
            // root.left.left.left = new Node(8);

            // 2nd tree
            //     2
            //   /   \
            //  4     5

            Node subTree = new Node(2);
            subTree.left = new Node(4);
            subTree.right = new Node(5);

            // 1...System.out.println(isSubTree(root, subTree));
            // 2...topView(root);
            // int k = 4;
            // 3...kLevel(root, 1, 3);
            // int n1 = 4 , n2 =7 ;
            // 4...System.out.println("Common root between "+n1+" & "+n2+" is : "+lowestCommonAncestor(root , n1 , n2).data);
            // 5...System.out.println("Common root between "+n1+" & "+n2+" is : "+lca(root , n1 , n2).data);
            // 6...System.out.println("Distance between two node in a tree of "+n1+" & "+n2+" is : "+minDist(root , n1 , n2));4
            // int n=4 , k=2;
            // 7...KthAncestor(root, n, k);
            transformToSumTree(root);
            preOrder(root);
      }
}
