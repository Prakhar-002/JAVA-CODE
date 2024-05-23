import java.util.ArrayList;

public class LowestCommonAncestor {

      public static boolean getPath(BinaryTreeBuild.TreeNode root, int n, ArrayList<BinaryTreeBuild.TreeNode> path) {
            if (root == null) {
                  return false;
            }

            path.add(root);

            if (root.data == n) {
                  return true;
            }

            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);

            if (foundRight || foundLeft) {
                  return true;
            }

            path.remove(path.size() - 1);
            return false;
      }

      public static BinaryTreeBuild.TreeNode lowestCommonAncestor(BinaryTreeBuild.TreeNode root, int n1, int n2) { // O(n)
            ArrayList<BinaryTreeBuild.TreeNode> path1 = new ArrayList<>();
            ArrayList<BinaryTreeBuild.TreeNode> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            // lCA
            int i = 0;
            for (; i < path1.size() && i < path2.size(); i++) {
                  if (path1.get(i) != path2.get(i)) {
                        break;
                  }
            }

            // last equal node -> i-1st
            BinaryTreeBuild.TreeNode lca = path1.get(i - 1);
            return lca;
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
            System.out.println("Common root between " + n1 + " & " + n2 + " is : " + lowestCommonAncestor(root, n1, n2).data);
      }

      // ? Output
      //  1.
      //     Common root between 4 & 7 is : 1
}
