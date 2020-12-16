public class SymmetricTree3 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

       return checkSymmetry(root.left, root.right);
        //return checkSymmetry(root);


    }

    // check root.left && root.right
    // check root.right && root.left
   public boolean checkSymmetry(TreeNode left,TreeNode right) {
   // public boolean checkSymmetry(TreeNode root) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }

        //return checkSymmetry(root.left) && checkSymmetry(root.right);
        return left.val == right.val && checkSymmetry(left.left, right.right) && checkSymmetry(left.right, right.left);


    }

    public static void main(String[] args) {
        SymmetricTree3 test = new SymmetricTree3();
        TreeNode tree1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        TreeNode tree2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        test.isSymmetric(tree1);
       // test.isSymmetric(tree2);
    }
}
