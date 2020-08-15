package problems.tree;

import explore.datastructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-16 13:16
 **/
public class LeafSimilar {
    public boolean leafSimilar(TreeNode t1, TreeNode t2) {
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        findLeaf(t1, l1);
        findLeaf(t2, l2);
        return l1.equals(l2);
    }

    private void findLeaf(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        findLeaf(root.left, list);
        findLeaf(root.right, list);
    }
}
