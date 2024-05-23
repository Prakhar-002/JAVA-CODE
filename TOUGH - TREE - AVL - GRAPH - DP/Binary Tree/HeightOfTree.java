
public class HeightOfTree {
      
      public static int heightOfTree(BinaryTreeBuild.TreeNode root) { // O(n)
            if (root == null) {
                  return 0;
            }
            int lh = heightOfTree(root.left);
            int rh = heightOfTree(root.right);
            return Math.max(lh, rh) + 1;
      }

      //*----------------------------------------------------------------------------

      public static void main(String[] args) {
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTreeBuild tree = new BinaryTreeBuild();
            BinaryTreeBuild.TreeNode root = tree.binaryBuild(nodes);

            // preOrder traversal...
            System.out.println("Height of this tree is...");
            System.out.println(heightOfTree(root));
      }

      //? Output
      // 1. 
      //    Height of this tree is...
      //    3

}
