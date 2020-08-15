package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-24 13:08
 **/
public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while (n > m) {
            n = n & (n - 1);
        }
        return n;
    }
}
