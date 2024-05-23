public class DiameterOfTree {

      // 1st approach...
      public static int diameterOfTree(BinaryTreeBuild.TreeNode root) { // O(n^2)
            if (root == null) {
                  return 0;
            }

            int leftDia = diameterOfTree(root.left);
            int rightDia = diameterOfTree(root.right);
            int leftHt = HeightOfTree.heightOfTree(root.left);
            int rightHt = HeightOfTree.heightOfTree(root.right);

            int selfDia = leftHt + rightHt + 1;

            return Math.max(selfDia, Math.max(rightDia, leftDia));
      }

      // 2nd approach of diameter...
      public static class Info {
            int diameter;
            int height;

            public Info(int diameter, int height) {
                  this.diameter = diameter;
                  this.height = height;
            }
      }

      public static Info diameterInfoTree(BinaryTreeBuild.TreeNode root) { // O(n)
            if (root == null) {
                  return new Info(0, 0);
            }
            Info leftInfo = diameterInfoTree(root.left);
            Info rightInfo = diameterInfoTree(root.right);

            int selfDiameter = Math.max(
                        Math.max(leftInfo.diameter, rightInfo.diameter),
                        leftInfo.height + rightInfo.height + 1);
            int selfHeight = Math.max(leftInfo.height, rightInfo.height) + 1;

            return new Info(selfDiameter, selfHeight);
      }

      //*----------------------------------------------------------------------------

      public static void main(String[] args) {
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTreeBuild tree = new BinaryTreeBuild();
            BinaryTreeBuild.TreeNode root = tree.binaryBuild(nodes);

            // Diameter of a tree...
            System.out.println("Diameter of this tree is...");
            System.out.println(diameterOfTree(root));

            // Diameter of a tree by 2nd approach...
            System.out.println("Diameter of this tree by Info class is...");
            System.out.println("Diameter is : --> " + diameterInfoTree(root).diameter);
            System.out.println("Max Height is : --> " + diameterInfoTree(root).height);

      }

      //? Output
      // 1. 
      //     Diameter of this tree is...
      //     5
      //     Diameter of this tree by Info class is...
      //     Diameter is : --> 5
      //     Max Height is : --> 3

}
