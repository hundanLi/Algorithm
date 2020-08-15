package problems.tree;

import explore.datastructure.tree.TreeNode;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-24 12:39
 **/
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        TreeNode node;
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                node = queue.remove();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (size == 0) {
                    list.add(node.val);
                }
            }
        }
        return list;
    }
}
