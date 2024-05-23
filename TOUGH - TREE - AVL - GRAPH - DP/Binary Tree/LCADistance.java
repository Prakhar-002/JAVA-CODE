public class LCADistance {
      // minimum distance btw two nodes---->
      public static int lcaDistance(BinaryTreeBuild.TreeNode root, int n) {
            if (root == null) {
                  return -1;
            }

            if (root.data == n) {
                  return 0;
            }

            int leftDist = lcaDistance(root.left, n);
            int rightDist = lcaDistance(root.right, n);

            if (leftDist == -1 && rightDist == -1) {
                  return -1;
            } else if (leftDist == -1) {
                  return rightDist + 1;
            } else {
                  return leftDist + 1;
            }
      }

      public static int minDist(BinaryTreeBuild.TreeNode root, int n1, int n2) {
            BinaryTreeBuild.TreeNode lca = LCA.lca(root, n1, n2);
            int dist1 = lcaDistance(lca, n1);
            int dist2 = lcaDistance(lca, n2);

            return dist1 + dist2;
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
            System.out.println("Distance between two node in a tree of " + n1 + " & " + n2 + " is : " + minDist(root, n1, n2));

      }

      // ? Output
      // 1.
      //    Distance between two node in a tree of 4 & 7 is : 4
}
