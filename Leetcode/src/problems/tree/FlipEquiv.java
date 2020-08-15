package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-17 12:54
 **/
public class FlipEquiv {
    public boolean flipEquiv(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return (flipEquiv(t1.left, t2.left) && flipEquiv(t1.right, t2.right)) ||
                (flipEquiv(t1.left, t2.right) && flipEquiv(t1.right, t2.left));
    }
}
