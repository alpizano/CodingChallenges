import java.util.*;

public class SymmetricTree {
    List<String> treeList = new ArrayList();

    public boolean isSymmetric(TreeNode root) {
        boolean isSymmetric = true;
        int depth = 0;
        populateArray(root, depth);

        System.out.println(treeList);

//        int[] intArray = treeList.stream().mapToInt(i -> i).toArray();
        String[] strArray = treeList.toArray(new String[treeList.size()]);

        for (int i = 0, j = strArray.length - 1; i < strArray.length / 2; i++, j--) {
            if (!strArray[i].equals(strArray[j])) {
                isSymmetric = false;
            }
        }

        return isSymmetric;
    }

    public void populateArray(TreeNode root, int depth) {
        if (root == null) {
            treeList.add(depth + "-" + "null");
            return;
        }

        populateArray(root.left, depth + 1);
        treeList.add(depth + "-" + root.val);
        populateArray(root.right, depth + 1);
    }

    public static void main(String[] args) {
        SymmetricTree test = new SymmetricTree();

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        test.isSymmetric(root);


    }
}


