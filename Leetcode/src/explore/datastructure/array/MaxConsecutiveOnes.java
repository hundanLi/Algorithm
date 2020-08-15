package explore.datastructure.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-15 09:58
 **/
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = -1;
        int end = 0;
        int ans = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                ans = Math.max(end - start - 1, ans);
                start = end;
            }
            end++;
        }
        ans = Math.max(ans, end - start - 1);
        return ans;
    }
}
