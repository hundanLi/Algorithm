package explore.algorithm.senior.tree;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-25 18:40
 **/
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                    list.add(node.val);
                }
                lists.add(list);
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    if (node.right != null) {
                        stack1.add(node.right);
                    }
                    if (node.left != null) {
                        stack1.add(node.left);
                    }
                    list.add(node.val);
                }
                lists.add(list);
            }
        }
        return lists;
    }
}
