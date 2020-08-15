package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-18 14:26
 **/
public class BstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null) {
            return null;
        }
        return construct(preorder, 0, preorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int s, int e) {
        if (s > e) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[s]);
        int j = s + 1;
        for (; j <= e; j++) {
            if (preorder[j] > preorder[s]) {
                break;
            }
        }
        root.left = construct(preorder, s + 1, j - 1);
        root.right = construct(preorder, j, e);
        return root;
    }
}
