package mock.month1907;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-18 09:17
 **/
public class CompleteTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean preNull = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.remove();
                if (node != null) {
                    if (preNull) {
                        return false;
                    } else {
                        queue.offer(node.left);
                        queue.offer(node.right);
                        preNull = false;
                    }
                } else {
                    preNull = true;
                }
            }

        }
        return true;
    }

}
