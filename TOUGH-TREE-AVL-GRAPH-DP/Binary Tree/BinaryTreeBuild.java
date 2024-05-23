public class BinaryTreeBuild {

      public static class TreeNode{
            int data;
            TreeNode left;
            TreeNode right;

            TreeNode(int data) {
                  this.data = data;
                  this.left = null;
                  this.right = null;
            }
      }

      static int idx = -1;

      public TreeNode binaryBuild(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                  return null;
            }

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = binaryBuild(nodes);
            newNode.right = binaryBuild(nodes);

            return newNode;
      }


      public static void main(String[] args) {
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTreeBuild tree = new BinaryTreeBuild();
            TreeNode root = tree.binaryBuild(nodes);
            System.out.println("First root is --> " + root.data);
      }

      //? Output
      // 1. 
      //    First root is --> 1

}