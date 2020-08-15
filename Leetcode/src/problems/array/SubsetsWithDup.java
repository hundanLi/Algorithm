package problems.array;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-24 10:08
 **/
public class SubsetsWithDup {
    private List<Integer> subSet = new LinkedList<>();
    private Set<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        ans.add(Collections.emptyList());
        Arrays.sort(nums);
        dfs(nums, 0);
        return new ArrayList<>(ans);
    }

    private void dfs(int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            subSet.add(nums[i]);
            ans.add(new ArrayList<>(subSet));
            dfs(nums, i + 1);
            subSet.remove(subSet.size() - 1);
        }
    }

    class Solution{
        private List<Integer> subSet = new LinkedList<>();
        private List<List<Integer>> ans = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums == null || nums.length == 0) {
                return Collections.emptyList();
            }
            Arrays.sort(nums);
            dfs(nums, 0);
            return ans;
        }

        private void dfs(int[] nums, int index) {
            ans.add(new ArrayList<>(subSet));
            for (int i = index; i < nums.length; i++) {
                if (i != index && nums[i] == nums[i - 1]) {
                    continue;
                }
                subSet.add(nums[i]);
                dfs(nums, i + 1);
                subSet.remove(subSet.size() - 1);
            }
        }
    }
}
