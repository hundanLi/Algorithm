package explore.algorithm.senior.math;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-10 23:19
 **/
public class TrailingZeroes {

    /**
     * @param n n!
     * @return tailing zeros
     *
     * 2*5=10, 10*1=10,找出5的倍数的个数
     */
    public int trailingZeroes(int n) {
        if (n/5 >= 5) {
            return n/5 + trailingZeroes(n/5);
        } else {
            return n/5;
        }
    }

    private int helper(int n) {
        int mod = n % 5;
        if (mod != 0) {
            n -= mod;
        }
        int sum = 0;
        while (n > 0) {
            int tmp = n;
            while (tmp >= 5 && tmp % 5 == 0) {
                sum++;
                tmp /= 5;
            }
            n -= 5;
        }
        return sum;
    }

    public static void main(String[] args) {
        TrailingZeroes zeroes = new TrailingZeroes();
        int i = zeroes.trailingZeroes(25);
        int j = zeroes.helper(6);
        System.out.println(i + ": " + j);
    }
}
