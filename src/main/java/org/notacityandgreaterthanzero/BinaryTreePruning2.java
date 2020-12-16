public class BinaryTreePruning2 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        return pruneTree(root, root.val);
    }

    public TreeNode pruneTree(TreeNode root, int val) {

        if(root == null) {
            return root;
        }

        root.left = pruneTree(root.left, root.val);
        root.right = pruneTree(root.right, root.val);

        if(root.left == null && root.right == null && val == 0) {
            return null;
        }


        return root;
    }

    public static void main(String[] args) {
        BinaryTreePruning2 test = new BinaryTreePruning2();

        TreeNode root1 = new TreeNode(1, null, new TreeNode(0, new TreeNode(0), new TreeNode(1)));
        test.pruneTree(root1);
    }
}
