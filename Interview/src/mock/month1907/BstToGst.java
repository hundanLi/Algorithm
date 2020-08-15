package mock.month1907;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-22 00:08
 **/
public class BstToGst {
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        int sum = getSum(root);
        inorder(root, sum);
        return root;
    }

    private int getSum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return root.val + getSum(root.left) + getSum(root.right);

    }

    private int inorder(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        sum = inorder(root.left, sum);
        int val = root.val;
        root.val = sum;
        sum -= val;
        return inorder(root.right, sum);
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
