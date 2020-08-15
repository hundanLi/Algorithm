package vip;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-15 18:54
 **/
public class TreeDiameter {
    private int diameter;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /** 求二叉树的直径
     * @param root  树的根节点
     * @return 直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root, 0);
        return diameter;
    }

    private int getDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = depth;
        int right = depth;
        // 分别求出左右子树的深度
        if (root.left != null) {
            left = getDepth(root.left, depth + 1);
        }
        if (root.right != null) {
            right = getDepth(root.right, depth + 1);
        }
        // 求出以root为根节点的子树的直径大小并更新最大直径的值
        diameter = Math.max(diameter, left + right - depth * 2);
        // 返回以root为根节点的子树的深度
        return Math.max(left, right);
    }


}
