package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-10 17:07
 **/
public class CountBits {
    public int[] countBits1(int num) {
        // 常规方法，逐个数字单独计算
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = count(i);
        }
        return ans;
    }

    private int count(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }


    public int[] countBits2(int num) {
        // 动态规划 + 最后设置位
        // 状态转移函数： P(x) = P(x&(x-1)) + 1
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
}