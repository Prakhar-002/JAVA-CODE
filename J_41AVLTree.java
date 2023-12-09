public class J_41AVLTree {
      static class Node {
            int data , height;
            Node left , right;

            Node(int data){
                  this.data = data;
                  height =1;
            }
      }

      public static Node root;

      public static int height(Node root){
            if (root == null) {
                  return 0;
            }

            return root.height;
      }

      public static int balanceAVL(Node root){
            if (root == null) {
                  return 0;
            }

            return height(root.left) - height(root.right);
      }

      // Left rotate subtree rooted with x...
      public static Node leftRotate(Node x){
            Node y = x.right;
            Node T2 = y.left;

            // Perform rotation...
            y.left = x;
            x.right = T2;

            // update heights...
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            // Return newNode
            return y; 
      }

      // Right rotate subtree rooted with y...
      public static Node rightRotate(Node y){
            Node x = y.left;
            Node T2 = x.right;

            // Perform rotation...
            x.right = y;
            y.left = T2;

            // update heights...
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            // Return newNode
            return x; 
      }

      public static Node insert(Node root , int key){
            if (root == null) {
                  return new Node(key);
            }

            if (key < root.data) {
                  root.left = insert(root.left, key);
            }else if (key > root.data){
                  root.right = insert(root.right, key);
            }else{
                  return root; // Duplicate keys not allowed... 
            }

            // Update root height...
            root.height = Math.max(height(root.left), height(root.right)) + 1;

            // Get root balance factor...
            int bf = balanceAVL(root);

            // left left case ...
            if (bf > 1 && key < root.left.data) {
                  return rightRotate(root);
            }

            // Right Right case...
            if (bf < -1 && key > root.right.data) {
                  return leftRotate(root);
            }

            // left Right case...
            if (bf > 1 && key > root.left.data) {
                  root.left = leftRotate(root.left);
                  return rightRotate(root);
            }

            // Right left case...
            if (bf < -1 && key < root.right.data) {
                  root.right = rightRotate(root.right);
                  return leftRotate(root);
            }

            return root;  // returned if AVL balanced... 
      }

      public static void preOrder(Node root){
            if (root == null) {
                  return;
            }

            System.out.print(root.data +" ");
            preOrder(root.left);
            preOrder(root.right);
      }


//---------------------------------------------------------------------------------------------------------

      // delete functions...

      // For non-empty BST , return the node with min data
      public static Node getMinNode(Node root){
            Node cur = root;
            // min data Node will be in left most node
            while (cur.left != null) {
                  cur = cur.left;
            }

            return cur;
      }

      public static Node deleteAVLNode(Node root ,int key){
            // perform using BST delete...
            if (root == null) {
                  return root;
            }

            // key < root'data => then it lies in left subTree... 
            if (key < root.data) {
                  root.left = deleteAVLNode(root.left, key);
            }
            // key > root'data => then it lies in right subTree...
            else if(key > root.data){
                  root.right = deleteAVLNode(root.right, key);
            }
            // key == root.data then it's the node to be deleted...
            else{
                  // Node with only one child or no child...
                  if ((root.left == null) || (root.left == null)) {
                        Node temp = null;
                        if (temp == root.left ) {
                              temp = root.right;
                        }else{
                              temp = root.left;
                        }

                        // no child case;
                        if (temp == null) {
                              temp = root;
                              root = null;
                        }

                        // one child case...
                        else{
                              temp = root; // copy the content of non empty child...
                        }
                  }
                  // root with 2 children...
                  else{
                        // successor (smallest is in right sub tree)
                        Node temp =getMinNode(root.right);
                        // copy the inOrder successor'data to this node...
                        temp.data = root.data;
                        // delete the inOrder successor data...
                        root.right = deleteAVLNode(root.right, temp.data);
                  }
            }

            // if tree had only one node then return root...
            if (root == null) {
                  return root;
            }

            // update the height of root node...
            root.height = Math.max(height(root.left) , height(root.right)) +1 ;

            // if the tree become unbalance then there are four cases...
            // Get root balance factor...
            int bf = balanceAVL(root);

            // left left case ...
            if (bf > 1 && balanceAVL(root) >=0 ) {
                  return rightRotate(root);
            }

            // Right Right case...
            if (bf < -1 && balanceAVL(root) <= 0) {
                  return leftRotate(root);
            }

            // left Right case...
            if (bf > 1 && balanceAVL(root) < 0) {
                  root.left = leftRotate(root.left);
                  return rightRotate(root);
            }

            // Right left case...
            if (bf < -1 && balanceAVL(root) >0) {
                  root.right = rightRotate(root.right);
                  return leftRotate(root);
            }

            return root;  // returned if AVL balanced... 
      }






      public static void main(String[] args) {
            root = insert(root , 10);
            root = insert(root , 20);
            root = insert(root , 30);
            root = insert(root , 40);
            root = insert(root , 50);
            root = insert(root , 25);

            preOrder(root);
            deleteAVLNode(root, 10);
            System.out.println();
            preOrder(root);
      }
}
