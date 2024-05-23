
public class PreOrderTraversal {

      public static void preOrderTraversal(BinaryTreeBuild.TreeNode root) { // O(n)
            if (root == null) {
                  System.out.print("-1 ");
                  return;
            }
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
      }

      //*----------------------------------------------------------------------------

      public static void main(String[] args) {
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTreeBuild tree = new BinaryTreeBuild();
            BinaryTreeBuild.TreeNode root = tree.binaryBuild(nodes);

            // preOrder traversal...
            System.out.println("PreOrder Traversal...");
            preOrderTraversal(root);
      }

      //? Output
      // 1. 
      //    PreOrder Traversal..
      //    1 2 4 -1 -1 5 -1 -1 3 -1 6 -1 -1
}
