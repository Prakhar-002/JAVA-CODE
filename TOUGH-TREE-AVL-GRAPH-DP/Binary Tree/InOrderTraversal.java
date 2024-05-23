public class InOrderTraversal {

      public static void inOrderTraversal(BinaryTreeBuild.TreeNode root) {
            if (root == null) {
                  System.out.print("-1 ");
                  return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
      }

      //*----------------------------------------------------------------------------

      public static void main(String[] args) {
            int nodes[] = { 451, 102, 47, -1, -1, 15, -1, -1, 3, -1, 76, -1, -1 };
            BinaryTreeBuild tree = new BinaryTreeBuild();
            BinaryTreeBuild.TreeNode root = tree.binaryBuild(nodes);

            // preOrder traversal...
            System.out.println("InOrder Traversal...");
            inOrderTraversal(root);
      }

      //? Output
      // 1. 
      //    InOrder Traversal...
      //    -1 47 -1 102 -1 15 -1 451 -1 3 -1 76 -1
      
}
