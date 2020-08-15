package problems.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-24 11:11
 **/
public class BuildTree {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if (pend < pstart || iend < istart) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pend]);
        int rootIndex = findRootIndex(inorder, istart, iend, postorder[pend]);
        int leftLen = rootIndex - istart;
        root.left = buildTree(inorder, istart, rootIndex - 1, postorder, pstart, pstart + leftLen - 1);
        root.right = buildTree(inorder, rootIndex + 1, iend, postorder, pstart + leftLen, pend - 1);
        return root;
    }

    private static int findRootIndex(int[] inorder, int istart, int iend, int rootVal) {
        for (int i = istart; i <= iend; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        buildTree(inorder, postorder);
    }
}
