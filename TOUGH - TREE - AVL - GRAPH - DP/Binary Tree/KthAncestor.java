public class KthAncestor {

      // Kth ancestor program...
      public static int KthAncestorInTree(BinaryTreeBuild.TreeNode root, int n, int k) {
            if (root == null) {
                  return -1;
            }

            if (root.data == n) {
                  return 0;
            }

            int leftDist = KthAncestorInTree(root.left, n, k);
            int rightDist = KthAncestorInTree(root.right, n, k);

            if (leftDist == -1 && rightDist == -1) {
                  return -1;
            }

            int max = Math.max(leftDist, rightDist);

            if (max + 1 == k) {
                  System.out.println(k + " th Ancestor of " + n + " is : " + root.data);
            }

            return max + 1;
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

            int n = 4, k = 2;
            KthAncestorInTree(root, n, k);
      }

      // ? Output
      // 1.
      //    2 th Ancestor of 4 is : 1
}
