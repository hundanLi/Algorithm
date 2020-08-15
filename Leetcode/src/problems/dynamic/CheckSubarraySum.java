package problems.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-22 19:02
 **/
public class CheckSubarraySum {

    /**
     * 遍历i <- 0 to n-1,检查每个以num[i]开头的子数组是否满足要求
     * 时间复杂度O(N^2)
     */
    public boolean checkSubarraySum0(int[] num, int k) {
        if (num == null || num.length < 2) {
            return false;
        }
        for (int i = 0; i < num.length; i++) {
            int sum = num[i];
            for (int j = i + 1; j < num.length; j++) {
                sum += num[j];
                if (k == 0) {
                    if (sum == 0) {
                        return true;
                    }
                } else if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    /** O(n)时间复杂度：
     *
     *   在每个索引位置i, 计算当前和对k的mod值, 假设在索引x处, sum[0~x] = m*k + mod_x;
     *      在索引y处, sum[0~y] = n*k + mod_y; 如果mod_x == mod_y且y-x > 1说明sum[x~y]
     *      即为一个符合要求的连续子数组, 用map来保存每个mod值对应的索引, 一旦出现新的mod值出现
     *      在map中, 判断索引差是否大于1.
     *      注意特殊情况:
     *      1) 当nums中有连续0, 无论k为何值都是正确的;
     *      2) 除情况1之外出现k为0都是错误的;
     *      3) k为负数也是可能的, 但是要将其变为对应正数来求mod.
     *      此外需要在map中初始化<0,-1>, 其原因在于解决到达某个i时sum恰好可以整除k的情况, 选择-1
     *      的原因是要求连续子数组长度大于等于2, 这样可以避免第一个数字为0的情况
     */
    public boolean checkSubarraySum1(int[] num, int k) {
        if (num == null || num.length == 0) {
            return false;
        }
        // 对于连续0,0=0×k，满足要求
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] == 0 && num[i + 1] == 0) {
                return true;
            }
        }
        if (k == 0) {
            return false;
        }
        if (k < 0) {
            k = -k;
        }
        Map<Integer, Integer> mods = new HashMap<>(16);
        mods.put(0, -1);
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
            int mod = sum % k;
            if (mods.containsKey(mod)) {
                if (i - mods.get(mod) > 1) {
                    return true;
                }
            } else {
                mods.put(mod, i);
            }
        }
        return false;
    }

}