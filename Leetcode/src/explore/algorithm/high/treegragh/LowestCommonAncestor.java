package explore.algorithm.high.treegragh;

import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-23 18:36
 * 思路：分别找出从根节点到p和q的路径，然后按照寻找交叉链表第一个公共结点的方法找出最低公共祖先结点
 **/
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pathP = new LinkedList<>();
        LinkedList<TreeNode> pathQ = new LinkedList<>();
        findPath(root, p, pathP);
        findPath(root, q, pathQ);
        int d;
        if (pathP.size() > pathQ.size()) {
            d = pathP.size() - pathQ.size();
            while (d > 0) {
                pathP.removeLast();
                d--;
            }
        } else {
            d = pathQ.size() - pathP.size();
            while (d > 0) {
                pathQ.removeLast();
                d--;
            }
        }
        TreeNode pe;
        TreeNode qe;
        while (!pathP.isEmpty() && !pathQ.isEmpty()) {
            pe = pathP.removeLast();
            qe = pathQ.removeLast();
            if (pe == qe) {
                return pe;
            }
        }
        return root;
    }

    private boolean findPath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root == p) {
            return true;
        }
        if (findPath(root.left, p, path) || findPath(root.right, p, path)) {
            return true;
        } else {
            path.remove(root);
            return false;
        }
    }

    class Solution {
        // 牛逼解法

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || p == root || q == root) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left != null && right != null) {
                return root;
            } else if(left == null) {
                return right;
            } else {
                return left;
            }
        }
    }
}
