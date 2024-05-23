import java.util.*;

public class AllBinaryTree {

      static class TreeNode {
            int data;
            TreeNode left;
            TreeNode right;

            TreeNode(int data) {
                  this.data = data;
                  this.left = null;
                  this.right = null;
            }
      }

      public static class BinaryTree {
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

            public void preOrderTraversal(TreeNode root) { // O(n)
                  if (root == null) {
                        System.out.print("-1 ");
                        return;
                  }
                  System.out.print(root.data + " ");
                  preOrderTraversal(root.left);
                  preOrderTraversal(root.right);
            }

            public void inOrderTraversal(TreeNode root) {
                  if (root == null) {
                        System.out.print("-1 ");
                        return;
                  }
                  inOrderTraversal(root.left);
                  System.out.print(root.data + " ");
                  inOrderTraversal(root.right);
            }

            public void postOrderTraversal(TreeNode root) {
                  if (root == null) {
                        System.out.print("-1 ");
                        return;
                  }
                  postOrderTraversal(root.left);
                  postOrderTraversal(root.right);
                  System.out.print(root.data + " ");
            }

            public void levelOrderTraversal(TreeNode root) { // O(n)
                  if (root == null) {
                        return;
                  }

                  Queue<TreeNode> q = new LinkedList<>();
                  q.add(root);
                  q.add(null);

                  while (!q.isEmpty()) {
                        TreeNode curNode = q.remove();
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

            public int heightOfTree(TreeNode root) { // O(n)
                  if (root == null) {
                        return 0;
                  }
                  int lh = heightOfTree(root.left);
                  int rh = heightOfTree(root.right);
                  return Math.max(lh, rh) + 1;
            }

            public int countOfNodes(TreeNode root) { // O(n)
                  if (root == null) {
                        return 0;
                  }
                  int lc = countOfNodes(root.left);
                  int rc = countOfNodes(root.right);
                  return lc + rc + 1;
            }

            public int sumOfNodes(TreeNode root) { // O(n)
                  if (root == null) {
                        return 0;
                  }

                  int ls = sumOfNodes(root.left);
                  int rs = sumOfNodes(root.right);
                  return ls + rs + root.data;
            }

            // 1st approach...
            public int diameterOfTree(TreeNode root) { // O(n^2)
                  if (root == null) {
                        return 0;
                  }

                  int leftDia = diameterOfTree(root.left);
                  int rightDia = diameterOfTree(root.right);
                  int leftHt = heightOfTree(root.left);
                  int rightHt = heightOfTree(root.right);

                  int selfDia = leftHt + rightHt + 1;

                  return Math.max(selfDia, Math.max(rightDia, leftDia));
            }

            // 2nd approach of diameter...
            public class Info {
                  int diameter;
                  int height;

                  public Info(int diameter, int height) {
                        this.diameter = diameter;
                        this.height = height;
                  }
            }

            public Info diameterInfoTree(TreeNode root) { // O(n)
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
      }

      public static void preOrderTree() { // O(n)
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTree tree = new BinaryTree();
            TreeNode root = tree.binaryBuild(nodes);
            System.out.println("First root is --> " + root.data);

            // preOrder traversal...
            System.out.println("preOrder traversal...");
            tree.preOrderTraversal(root);

            // inOrder traversal ...
            System.out.println("\nInOrder traversal ...");
            tree.inOrderTraversal(root);

            // postOrder traversal...
            System.out.println("\npostOrder traversal...");
            tree.postOrderTraversal(root);

            // levelOrder traversal...
            System.out.println("\nlevelOrder traversal...");
            tree.levelOrderTraversal(root);

            System.out.println("Height of this tree is...");
            System.out.println(tree.heightOfTree(root));

            System.out.println("Count of node of this tree is...");
            System.out.println(tree.countOfNodes(root));

            System.out.println("sum of node of this tree is...");
            System.out.println(tree.sumOfNodes(root));

            // Diameter of a tree...
            System.out.println("Diameter of this tree is...");
            System.out.println(tree.diameterOfTree(root));

            // Diameter of a tree by 2nd approach...
            System.out.println("Diameter of this tree by Info class is...");
            System.out.println("Diameter is : --> " + tree.diameterInfoTree(root).diameter);
            System.out.println("Max Height is : --> " + tree.diameterInfoTree(root).height);

      }

      public static void main(String[] args) {
            preOrderTree();
      }

      //? Output
      //  1. 
      //*    First root is --> 1

      //*    preOrder traversal...
      //     1 2 4 -1 -1 5 -1 -1 3 -1 6 -1 -1

      // *   InOrder traversal ...
      //     -1 4 -1 2 -1 5 -1 1 -1 3 -1 6 -1

      //*    postOrder traversal...
      //     -1 -1 4 -1 -1 5 2 -1 -1 -1 6 3 1

      //*    levelOrder traversal...
      //     1
      //     2 3
      //     4 5 6

      // *   Height of this tree is...
      //     3

      //*    Count of node of this tree is...
      //     6

      //*    sum of node of this tree is...
      //     21

      //*    Diameter of this tree is...
      //     5

      // *   Diameter of this tree by Info class is...
      //     Diameter is : --> 5
      //     Max Height is : --> 3
}