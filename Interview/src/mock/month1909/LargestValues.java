package mock.month1909;


import datastructure.TreeNode;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-17 10:26
 **/
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> maxVals = new ArrayList<>(16);
        TreeNode node;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                node = queue.remove();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            maxVals.add(max);
        }
        return maxVals;
    }
}
