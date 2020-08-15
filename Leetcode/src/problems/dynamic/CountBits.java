package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-16 21:44
 * 思路： i & (i-1) 相当于将i最右边的1变成0
 **/
public class CountBits {
    public static int[] countBits0(int n) {
        int[] res = new int[n + 1];
        if (n < 0) {
            return null;
        }
        int k;
        for (int i = 0; i <= n; i++) {
            int j = 0;
            while (j <= 31) {
                k = 1 << j;
                if ((k & i) != 0) {
                    res[i]++;
                }
                j++;
            }
        }
        return res;
    }

    public static int[] countBits1(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }


    /**
     * i >> 1会把最低位去掉，因此i >> 1 也是比i小的，同样也是在前面的数组里算过。
     * 当 i 的最低位是0，则 i 中1的个数和i >> 1中1的个数相同；
     * 当i的最低位是1，i 中1的个数是 i >> 1中1的个数再加1
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 0;i<= num;i++){
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] bits = countBits0(4);
        for (int bit : bits) {
            System.out.println(bit);
        }
    }
}
