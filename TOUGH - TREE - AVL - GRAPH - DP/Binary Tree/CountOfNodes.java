public class CountOfNodes {

      public static int countOfNodes(BinaryTreeBuild.TreeNode root) { // O(n)
            if (root == null) {
                  return 0;
            }
            int lc = countOfNodes(root.left);
            int rc = countOfNodes(root.right);
            return lc + rc + 1;
      }

      //*----------------------------------------------------------------------------

      public static void main(String[] args) {
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTreeBuild tree = new BinaryTreeBuild();
            BinaryTreeBuild.TreeNode root = tree.binaryBuild(nodes);

            // preOrder traversal...
            System.out.println("Count of node of this tree is...");
            System.out.println(countOfNodes(root));

      }

      //? Output
      // 1. 
      //    Count of node of this tree is...
      //    6

}
