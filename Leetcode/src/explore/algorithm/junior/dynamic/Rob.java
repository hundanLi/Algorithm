package explore.algorithm.junior.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-20 23:58
 **/
public class Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return robOfHelper(nums);
    }

    private int robOfHelper(int[] nums) {
        int pre = nums[0];
        int post = Math.max(nums[0], nums[1]);
        int len = nums.length;
        for (int i = 2; i < len; i++) {
            int cur = Math.max(pre + nums[i], post);
            pre = post;
            post = cur;
        }
        return Math.max(pre, post);
    }
    private int robHelperOfLinear(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
        }
        return res[res.length - 1];
    }
    private int robHelperOfRecursive(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        }
        if (i == 1) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHelperOfRecursive(nums, i - 1), robHelperOfRecursive(nums, i - 2) + nums[i]);
    }
}
