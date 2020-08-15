package problems.tree;

import explore.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-22 10:53
 **/
public class PathSum2 {
    private List<List<Integer>> lists = new LinkedList<>();
    private List<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return lists;
        }
        dfs(root, sum);
        return lists;
    }

    private void dfs(TreeNode root, int sum) {
        if (sum == root.val && root.left == null && root.right == null) {
            path.add(root.val);
            lists.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            dfs(root.left, sum - root.val);
        }
        if (root.right != null) {
            dfs(root.right, sum - root.val);
        }
        path.remove(path.size() - 1);
    }
}
