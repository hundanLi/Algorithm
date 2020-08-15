package explore.algorithm.high.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-03 08:03
 * 思路：访问到每个点的时候，以该点为子序列的末尾的乘积，要么是该点本身，要么是该点乘以以前一点为末尾的序列，注意乘积负负得正，故需要记录前面的最大最小值。
 **/
public class MaxProduct {
    public int maxProduct(int[] num) {
        if (num == null || num.length == 0) {
            throw new RuntimeException("输入有误！");
        }
        int maxPos = num[0];
        int minPos = num[0];
        int max = num[0];
        for (int i = 1; i < num.length; i++) {
            int prevMax = maxPos;
            int prevMin = minPos;
            maxPos = Math.max(num[i], Math.max(num[i] * prevMax, num[i] * prevMin));
            minPos = Math.min(num[i], Math.min(num[i] * prevMax, num[i] * prevMin));
            max = Math.max(max , maxPos);
        }
        return max;
    }
}
