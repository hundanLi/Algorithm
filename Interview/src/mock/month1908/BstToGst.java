package mock.month1908;

import datastructure.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-04 10:39
 **/
public class BstToGst {
    public TreeNode bstToGst(TreeNode root) {
        int sum = getSum(root, 0);
        updateVal(root, sum);
        return root;
    }

    private int getSum(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        sum += root.val;
        sum = getSum(root.left, sum);
        sum = getSum(root.right, sum);
        return sum;
    }

    private int updateVal(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        sum = updateVal(root.left, sum);
        sum -= root.val;
        root.val += sum;
        return updateVal(root.right, sum);

    }
}
