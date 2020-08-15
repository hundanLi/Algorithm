package problems.tree;

import explore.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-18 10:10
 **/
public class MatchVoyage {
    private List<Integer> list;
    private int i;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root == null) {
            return Collections.emptyList();
        }
        list = new ArrayList<>();
        if (dfs(root, voyage)) {
            return list;
        }
        return Collections.singletonList(-1);
    }

    private boolean dfs(TreeNode root, int[] voyage) {
        if (root == null) {
            return true;
        }
        if (root.val == voyage[i]) {
            i++;
            int temp = i;
            if (dfs(root.left, voyage) && dfs(root.right, voyage)) {
                return true;
            } else {
                i = temp;
                if (dfs(root.right, voyage) && dfs(root.left, voyage)) {
                    list.add(root.val);
                    return true;
                }
            }
        }
        return false;
    }
}
