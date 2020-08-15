package explore.algorithm.senior.tree;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-25 21:38
 **/
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        int cnt = countLeft(root.left);
        if (cnt == k - 1) {
            return root.val;
        } else if (cnt < k - 1) {
            return kthSmallest(root.right, k - cnt - 1);
        } else {
           return kthSmallest(root.left, k);
        }
    }

    private int countLeft(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countLeft(root.left) + countLeft(root.right) + 1;
    }
}
