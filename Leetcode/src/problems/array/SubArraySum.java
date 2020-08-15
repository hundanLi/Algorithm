package problems.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-22 16:04
 **/
public class SubArraySum {
    /**
     * 思路：
     * sum[i]表示num[0:i]的子数组和，那么num[i:j]的和等于sum[j] - sum[i]
     * 两层循环遍历sum数组检查 sum[j] - sum[i] == k
     *
     * @param nums 数组
     * @param k    目标和
     * @return 子数组个数
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length];
        int s = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i] = s;
            if (s == k) {
                ans++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (sum[j] - sum[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 优化：
     *  使用哈希表保存num[0:i]的和的频率
     */
    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        // k - k == 0
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            // 检查是否存在 sum[j] + k == sum[i]
            int pSum = sum - k;
            if (map.containsKey(pSum)) {
                ans += map.get(pSum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}