public class BinaryTreePruning {

//    public TreeNode pruneTree(TreeNode root) {
public void printTree(TreeNode root) {
    // 1. Figure out subtree traversal
    // 2. Figure out how to delete nodes

     //  Preorder Traversal
        System.out.println(root.val);
        if( root.left != null) {
            printTree(root.left);
        }
       if(root.right != null) {
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(0, new TreeNode(0), new TreeNode(1)));

        TreeNode root2 = new TreeNode(14,
                new TreeNode(17, new TreeNode(9, null, new TreeNode(13)), new TreeNode(53)),
                new TreeNode(11));

        BinaryTreePruning test  = new BinaryTreePruning();
        test.printTree(root2);
    }
}


  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
          this.right = right;
      }
  }

