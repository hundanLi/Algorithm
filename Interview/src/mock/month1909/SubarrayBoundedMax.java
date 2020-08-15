package mock.month1909;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-21 10:16
 **/
public class SubarrayBoundedMax {
    public static int numSubarrayBoundedMax(int[] nums, int l, int r) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        int max;
        for (int i = 0; i < nums.length; i++) {
            max = 0;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                if (max < l) {
                    continue;
                }
                if (max > r) {
                    break;
                }
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {73, 55, 36, 5, 55, 14, 9, 7, 72, 52};
        int l = 32;
        int r = 69;
        System.out.println(numSubarrayBoundedMax(nums, l, r));
    }
}
