package problems.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-30 09:55
 **/
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int curNum = 0;
        for (int num : nums) {
            if (num != 0) {
                curNum++;
            } else {
                curNum = 0;
            }
            ans = Math.max(ans, curNum);
        }
        return ans;
    }
}
