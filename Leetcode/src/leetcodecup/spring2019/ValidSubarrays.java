package leetcodecup.spring2019;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-21 19:40
 **/
public class ValidSubarrays {
    /**
     * 遍历检测以num[i]开头的满足要求的子数组个数
     */
    public int validSubarrays(int[] num) {
        int sum = 0;
        int n = num.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (num[j] < num[i]) {
                    break;
                } else {
                    sum += 1;
                }
            }
        }
        return sum;
    }
}
