import java.util.*;

public class TopView {

      static class Info {
            BinaryTreeBuild.TreeNode node;
            int hd; // Horizontal height...

            public Info(BinaryTreeBuild.TreeNode node, int hd) {
                  this.node = node;
                  this.hd = hd;
            }
      }

      public static void topView(BinaryTreeBuild.TreeNode root) {
            // Level order...
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer, BinaryTreeBuild.TreeNode> map = new HashMap<>();

            int min = 0, max = 0;
            q.add(new Info(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                  Info cur = q.remove();

                  if (cur == null) {
                        if (q.isEmpty()) {
                              break;
                        } else {
                              q.add(null);
                        }
                  } else {

                        if (!map.containsKey(cur.hd)) { // first time occurring ...
                              map.put(cur.hd, cur.node);
                        }

                        if (cur.node.left != null) {
                              q.add(new Info(cur.node.left, cur.hd - 1));
                              min = Math.min(min, cur.hd - 1);
                        }

                        if (cur.node.right != null) {
                              q.add(new Info(cur.node.right, cur.hd + 1));
                              max = Math.max(max, cur.hd + 1);
                        }
                  }
            }

            // printing...
            for (int i = min; i <= max; i++) {
                  System.out.print(map.get(i).data + " ");
            }
            System.out.println();
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

            System.out.println("Top view of Given tree --> ");
            topView(root);
      }

      //? Output
      // 1. 
      //     Top view of Given tree --> 
      //     4 2 1 3 7 
}
