public class IsIdentical {

      public static boolean isIdentical(BinaryTreeBuild.TreeNode node, BinaryTreeBuild.TreeNode subNode) {
            if (node == null && subNode == null) {
                  return true;
            } else if (node == null || subNode == null || node.data != subNode.data) {
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

      public static boolean isSubTree(BinaryTreeBuild.TreeNode root, BinaryTreeBuild.TreeNode subTree) {
            if (root == null) {
                  return false;
            }

            if (root.data == subTree.data) {
                  if (isIdentical(root, subTree)) {
                        return true;
                  }
            }

            return isSubTree(root.left, subTree) || isSubTree(root.right, subTree);
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

            // 2nd tree
            //     2
            //   /   \
            //  4     5

            BinaryTreeBuild.TreeNode subRoot = new BinaryTreeBuild.TreeNode(2);
            subRoot.left = new BinaryTreeBuild.TreeNode(4);
            subRoot.right = new BinaryTreeBuild.TreeNode(5);

            System.out.println(isSubTree(root, subRoot));
      }

      //? Output
      // 1. 
      //    true
}
