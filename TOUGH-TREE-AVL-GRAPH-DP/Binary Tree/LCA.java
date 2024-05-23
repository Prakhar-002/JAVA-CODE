public class LCA {

      public static BinaryTreeBuild.TreeNode lca(BinaryTreeBuild.TreeNode root, int n1, int n2) {
            if (root == null || root.data == n1 || root.data == n2) {
                  return root;
            }

            BinaryTreeBuild.TreeNode leftLCA = lca(root.left, n1, n2);
            BinaryTreeBuild.TreeNode rightLCA = lca(root.right, n1, n2);

            if (rightLCA == null) {
                  return leftLCA;
            }

            if (leftLCA == null) {
                  return rightLCA;
            }

            return root;
      }

      // *----------------------------------------------------------------------------

      public static void main(String[] args) {
            // 1st tree...

            //        1
            //      /   \
            //     2     3
            //    / \   / \
            //   4  5  6  7

            int treeNodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
            BinaryTreeBuild tree = new BinaryTreeBuild();
            BinaryTreeBuild.TreeNode root = tree.binaryBuild(treeNodes);

            int n1 = 4, n2 = 7;
            System.out.println("Common root between " + n1 + " & " + n2 + " is : " + lca(root, n1, n2).data);

      }

      // ? Output
      // 1.
      //    Common root between 4 & 7 is : 1
}
