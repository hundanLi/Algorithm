package problems.array;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-22 10:53
 **/
public class CombinationSum2 {
    private List<List<Integer>> set = new LinkedList<>();
    private List<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return set;
    }

    private void dfs(int[] nums, int index, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            set.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, i + 1, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }

}
