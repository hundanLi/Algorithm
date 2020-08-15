package explore.algorithm.senior.tree;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-25 19:18
 **/
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rebuild(preorder, 0, inorder, 0, preorder.length - 1);
    }

    private TreeNode rebuild(int[] preorder, int rootIdx, int[] inorder, int start, int end) {
        if (rootIdx > preorder.length - 1) {
            return null;
        }
        int divide;
        for (divide = start; divide <= end; divide++) {
            if (preorder[rootIdx] == inorder[divide]) {
                break;
            }
        }
        if (divide > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootIdx]);
        root.left = rebuild(preorder, rootIdx + 1, inorder, start, divide - 1);
        root.right = rebuild(preorder, rootIdx + 1 + divide - start, inorder, divide + 1, end);
        return root;
    }
}
