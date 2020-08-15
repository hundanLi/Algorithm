package problems.tree;

import explore.datastructure.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-15 14:03
 **/
public class FindTarget {
    private Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        int diff = target - root.val;
        if (set.contains(diff)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, target) || findTarget(root.right, target);
    }

}
