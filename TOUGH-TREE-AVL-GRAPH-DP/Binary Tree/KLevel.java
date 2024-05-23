public class KLevel {

      public static void kLevel(BinaryTreeBuild.TreeNode root, int level, int k) {
            if (root == null) {
                  System.out.println("No K level found...");
                  return;
            }

            if (level == k) {
                  System.out.print(root.data + " ");
                  return;
            }

            kLevel(root.left, level + 1, k);
            kLevel(root.right, level + 1, k);
      }

      //*----------------------------------------------------------------------------

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

            System.out.println("Kth level of a Tree -->");
            kLevel(root, 1, 3);
      }

      //? Output
      // 1. 
      //     Kth level of a Tree --> 
      //     4 5 6 7

}
