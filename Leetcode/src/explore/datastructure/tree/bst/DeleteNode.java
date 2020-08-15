package explore.datastructure.tree.bst;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-17 16:32
 **/
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode prev = null;
        int flag = 0;
        TreeNode cur = root;
        while (cur != null) {

            if (cur.val == key) {
                if (cur.right != null) {
                    // 有右子树
                    cur.val = findMin(cur);
                    break;
                } else {
                    if (cur == root) {
                        root = root.left;
                    } else if (flag == 0) {
                        prev.left = cur.left;
                    } else {
                        prev.right = cur.left;
                    }
                    break;
                }
            } else if (cur.val > key) {
                prev = cur;
                cur = cur.left;
                flag = 0;
            } else {
                prev = cur;
                cur = cur.right;
                flag = 1;
            }
        }
        return root;
    }

    /**
     * 寻找root的右子树的最小结点，并删除
     */
    private int findMin(TreeNode root) {
        TreeNode cur = root.right;
        TreeNode left = cur.left;
        // cur没有子树
        if (left == null) {
            root.right = cur.right;
            return cur.val;
        }
        // cur有左子树
        while (left.left != null) {
            cur = left;
            left = left.left;
        }
        cur.left = left.right;
        return left.val;
    }

    class Solution {
        public TreeNode findMin(TreeNode node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, root.val);
            }
            return root;
        }
    }
}
