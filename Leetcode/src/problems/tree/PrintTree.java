package problems.tree;

import explore.datastructure.tree.TreeNode;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-15 15:06
 **/
public class PrintTree {
    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        int depth = getDepth(root);
        int cap = (int) (Math.pow(2, depth) - 1);
        List<List<String>> ans = new ArrayList<>(depth);
        for (int i = 0; i < depth; i++) {
            List<String> list = new ArrayList<>(cap);
            for (int j = 0; j < cap; j++) {
                list.add("");
            }
            ans.add(list);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        List<String> list;
        int l = depth;
        for (int i = 0; i < depth; i++) {
            list = ans.get(i);
            int size = queue.size();
            for (int j = 1; j <= size; j++) {
                node = queue.remove();
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                    int idx = j * l * 2 - 1;
                    idx = idx > 0 ? idx : 0;
                    list.set(idx, node.val + "");
                } else {
                    queue.offer(null);
                    queue.offer(null);
                }
            }
            l--;
        }
        return ans;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(new PrintTree().printTree(root));
    }

}
