package mock.month1908;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-10 13:01
 * 将0转化为-1，
 * 使用map保存 前缀和->索引
 * 遍历数组求前缀和，若该和出现过（map中有相应的key），那么这之间就包含相同的0和1
 **/
public class MaxLength {
    public int findMaxLength(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }
            if (sum == 0) {
                max = i + 1;
            } else {
                if (!map.containsKey(sum)) {
                    map.put(sum, i + 1);
                } else {
                    max = Math.max(max, i - map.get(sum) + 1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        MaxLength maxLength = new MaxLength();
        System.out.println(maxLength.findMaxLength(nums));
    }
}
