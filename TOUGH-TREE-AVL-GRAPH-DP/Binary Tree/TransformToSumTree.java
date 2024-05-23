public class TransformToSumTree {

      public static int transformToSumTree(BinaryTreeBuild.TreeNode root) {
            if (root == null) {
                  return 0;
            }

            int lefSum = transformToSumTree(root.left);
            int rightSum = transformToSumTree(root.right);

            int newLeft = root.left == null ? 0 : root.left.data;
            int newRight = root.right == null ? 0 : root.right.data;

            int data = root.data;
            root.data = newLeft + lefSum + newRight + rightSum;

            return data;
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

            transformToSumTree(root);
            System.out.println("After Transforming into sum Array --> ");
            PreOrderTraversal.preOrderTraversal(root);
      }

      //? Output
      //  1. 
      //     After Transforming into sum Array --> 
      //     27 9 0 -1 -1 0 -1 -1 13 0 -1 -1 0 -1 -1 
}
