public class BinaryTreePruning {
    //boolean containsOne = false;

    public TreeNode pruneTree2(TreeNode root) {
        if (root == null) return null;

        root.left = pruneTree2(root.left);
        root.right = pruneTree2(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            root = null;
        }

        return new TreeNode(55);
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        containsOne(root);
        return root;
    }

    public boolean containsOne(TreeNode root) {
        if (root == null) return false;

        boolean left_contains = containsOne(root.left);
        boolean right_contains = containsOne(root.right);

        if (!left_contains) {
            root.left = null;
        }
        if (!right_contains) {
            root.right = null;
        }

        return root.val == 1 || left_contains || right_contains;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(0, new TreeNode(0), new TreeNode(1)));
        TreeNode root3 = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(0)), new TreeNode(1, new TreeNode(0), new TreeNode(1)));

        TreeNode root2 = new TreeNode(14,
                new TreeNode(17, new TreeNode(9, null, new TreeNode(13)), new TreeNode(53)),
                new TreeNode(11));

        BinaryTreePruning test = new BinaryTreePruning();

//        test.pruneTree(root2);
        test.pruneTree2(root);
//        test.pruneTree(root3);

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

