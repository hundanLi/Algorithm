package problems.array;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-22 10:34
 **/
public class CombinationSum {
    private List<List<Integer>> res = new LinkedList<>();
    private List<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;
    }

    private void dfs(int[] nums, int index, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }

}
