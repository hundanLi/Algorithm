package mock.month1909;


import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-23 19:24
 **/
public class TreePaths {
    private List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        preorder(root, new StringBuilder());
        return list;
    }

    private void preorder(TreeNode root, StringBuilder path) {
        if (root == null) {
            return;
        }
        path.append("->").append(root.val);
        if (root.left == null && root.right == null) {
            list.add(path.substring(2, path.length()));
        } else {
            preorder(root.left, path);
            preorder(root.right, path);
        }
        path.delete(path.lastIndexOf("->"), path.length());
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(37);
        tree.left = new TreeNode(-34);
        tree.right = new TreeNode(-48);
        tree.left.right = new TreeNode(-100);
        tree.right.left = new TreeNode(-100);
        System.out.println(new TreePaths().binaryTreePaths(tree));
    }
}
