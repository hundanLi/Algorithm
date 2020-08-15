package mock.month1908;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-04 10:26
 **/
public class PathSum {
    private List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        searchSum(root, sum, path);
        return ans;
    }

    private void searchSum(TreeNode root, int sum, List<Integer> path) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            ans.add(new ArrayList<>(path));
        } else {
            searchSum(root.left, sum, path);
            searchSum(root.right, sum, path);
        }
        path.remove(path.size() - 1);
    }
}
