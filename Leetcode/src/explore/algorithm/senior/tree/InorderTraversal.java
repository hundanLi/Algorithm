package explore.algorithm.senior.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-25 17:14
 **/
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        inorder(root, list);
//        return list;
        return inorder(root);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }


}
