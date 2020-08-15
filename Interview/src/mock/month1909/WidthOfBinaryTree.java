package mock.month1909;


import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-08 10:21
 **/
public class WidthOfBinaryTree {

    public int widthOfBinaryTree1(TreeNode root) {
        return levelOrder(root);
    }

    private int levelOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            maxWidth = Math.max(maxWidth, size);
            TreeNode node;
            for (int i = 1; i <= size; i++) {
                node = queue.pollFirst();
                if (node == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            while (queue.size() > 0 && queue.peekLast() == null) {
                queue.pollLast();
            }
            while (queue.size() > 0 && queue.peekFirst() == null) {
                queue.pollFirst();
            }
        }
        return maxWidth;
    }


    public int widthOfBinaryTree2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            int left = Integer.MAX_VALUE;
            int right = 0;
            int diff = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.remove();
                if (i == 0) {
                    diff = node.val;
                }
                node.val -= diff;
                left = Math.min(left, node.val);
                right = Math.max(right, node.val);
                if (node.left != null) {
                    node.left.val = 2 * node.val;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = 2 * node.val + 1;
                    queue.offer(node.right);
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }

    private int max = 0;

    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(1, 1, root, list);
        return max;
    }

    private void dfs(int level, int index, TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (level > list.size()) {
            list.add(index);
        }
        max = Math.max(max, index - list.get(level - 1) + 1);
        if (root.left != null) {
            dfs(level + 1, index * 2, root.left, list);
        }
        if (root.right != null) {
            dfs(level + 1, index * 2 + 1, root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        System.out.println(new WidthOfBinaryTree().widthOfBinaryTree(root));

    }
}
