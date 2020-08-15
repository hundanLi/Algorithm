package problems.tree;

import explore.datastructure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-14 10:24
 **/
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            minDepth++;
            int size = queue.size();
            TreeNode node;
            boolean flag = false;
            while (size-- > 0) {
                node = queue.remove();
                if (node.left == null && node.right == null) {
                    flag = true;
                    break;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (flag) {
                break;
            }
        }
        return minDepth;
    }

    public int minDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0 || right == 0) {
            return 1 + left + right;
        }
        return 1 + Math.min(left, right);
    }
}
