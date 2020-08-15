package problems.tree;

import explore.datastructure.tree.TreeNode;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-14 15:20
 **/
public class FrequentTreeSum {
    private Map<Integer, Integer> sumCount = new HashMap<>();
    private List<Integer> list = new LinkedList<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        postOrder(root);
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : sumCount.entrySet()) {
            if (maxCount < entry.getValue()) {
                maxCount = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            } else if (maxCount == entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for (int n: list) {
            ans[i++] = n;
        }
        return ans;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + postOrder(root.left) + postOrder(root.right);
        sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
