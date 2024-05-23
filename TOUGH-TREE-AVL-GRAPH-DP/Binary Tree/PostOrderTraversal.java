public class PostOrderTraversal {

      public static void postOrderTraversal(BinaryTreeBuild.TreeNode root) {
            if (root == null) {
                  System.out.print("-1 ");
                  return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
      }

      //*----------------------------------------------------------------------------

      public static void main(String[] args) {
            int nodes[] = { 51, 29, 40, -1, -1, 71, -1, -1, 3, -1, 206, -1, -1 };
            BinaryTreeBuild tree = new BinaryTreeBuild();
            BinaryTreeBuild.TreeNode root = tree.binaryBuild(nodes);

            // preOrder traversal...
            System.out.println("PreOrder Traversal...");
            postOrderTraversal(root);
      }

      //? Output
      // 1. 
      //    PostOrder Traversal...
      //    -1 -1 40 -1 -1 71 29 -1 -1 -1 206 3 51
}