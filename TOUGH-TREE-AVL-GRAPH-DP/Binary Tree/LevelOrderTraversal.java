import java.util.*;

public class LevelOrderTraversal {

      public static void levelOrderTraversal(BinaryTreeBuild.TreeNode root) { // O(n)
            if (root == null) {
                  return;
            }

            Queue<BinaryTreeBuild.TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                  BinaryTreeBuild.TreeNode curNode = q.remove();
                  if (curNode == null) {
                        System.out.println();
                        if (q.isEmpty()) {
                              break;
                        } else {
                              q.add(null);
                        }
                  } else {
                        System.out.print(curNode.data + " ");
                        if (curNode.left != null) {
                              q.add(curNode.left);
                        }
                        if (curNode.right != null) {
                              q.add(curNode.right);
                        }
                  }
            }
      }

      // *----------------------------------------------------------------------------

      public static void main(String[] args) {
            // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
            int nodes[] = { 2, 4, -1, -1, 5, -1, -1 };
            BinaryTreeBuild tree = new BinaryTreeBuild();
            BinaryTreeBuild.TreeNode root = tree.binaryBuild(nodes);

            // preOrder traversal...
            System.out.println("LevelOrder Traversal...");
            levelOrderTraversal(root);
      }

      // ? Output
      // 1.
      //    LevelOrder Traversal...
      //    1
      //    2 3
      //    4 5 6

}
