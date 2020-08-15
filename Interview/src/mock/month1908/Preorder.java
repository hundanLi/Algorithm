package mock.month1908;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-03 12:20
 **/
public class Preorder {
    List<Integer> list = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return list;
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
