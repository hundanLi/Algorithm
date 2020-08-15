package explore.datastructure.stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-06 10:52
 **/
public class TargetSumWays {
    private int num;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target);
        return num;
    }

    private void dfs(int[] nums, int index, int target) {
        if (index == nums.length) {
            if (target == 0) {
                num++;
            }
            return;
        }
        dfs(nums, index + 1, target + nums[index]);
        dfs(nums, index + 1, target - nums[index]);
    }
}
