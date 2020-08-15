package problems.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-15 09:25
 **/
public class IsPossible {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        //维护数字剩余个数
        Map<Integer, Integer> numCount = new HashMap<>();
        //维护以i结尾且长度大于等于3的子序列个数
        Map<Integer, Integer> numEndCount = new HashMap<>();

        //统计词频
        for (int n : nums) {
            numCount.put(n, numCount.getOrDefault(n, 0) + 1);
        }

        //遍历
        for (int n : nums) {
            if (numCount.get(n) == 0) {
                continue;
            }
            //剩余个数-1
            numCount.put(n, numCount.get(n) - 1);
            if (numEndCount.getOrDefault(n - 1, 0) > 0) {
                //以n-1结尾的子序列数量-1
                numEndCount.put(n - 1, numEndCount.get(n - 1) - 1);
                //以n结尾的子序列数量+1
                numEndCount.put(n, numEndCount.getOrDefault(n, 0) + 1);
            } else if (numCount.getOrDefault(n + 1, 0) > 0
                    //查找后面两个元素
                    && numCount.getOrDefault(n + 2, 0) > 0) {
                numCount.put(n + 1, numCount.get(n + 1) - 1);
                numCount.put(n + 2, numCount.get(n + 2) - 1);
                numEndCount.put(n + 2, numEndCount.getOrDefault(n + 2, 0) + 1);
            } else {
                //两种方法都凑不出长度大于等于3的子序列
                return false;
            }
        }
        return true;
    }

}
