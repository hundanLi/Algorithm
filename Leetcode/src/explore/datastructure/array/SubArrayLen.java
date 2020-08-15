package explore.datastructure.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-15 10:08
 **/
public class SubArrayLen {
    public static int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= s) {
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i++];
            }
            j++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int s = 11;
        System.out.println(minSubArrayLen(s, nums));
    }

}
