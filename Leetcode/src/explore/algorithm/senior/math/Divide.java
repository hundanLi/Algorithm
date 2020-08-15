package explore.algorithm.senior.math;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-11 14:08
 **/
public class Divide {
    public int divide(int dividend, int divisor) {
        long divided = (long) dividend;
        long divider = (long) divisor;
        boolean isNegative = false;
        if (divided > 0 && divider < 0) {
            isNegative = true;
        } else if (divided < 0 && divider > 0) {
            isNegative = true;
        }
        divided = Math.abs(divided);
        divider = Math.abs(divider);
        long rs = 0;
        while (divided >= divider) {
            divided -= divider;
            rs++;
        }
        if (isNegative) {
            rs = -rs;
        }
        if (rs > Integer.MAX_VALUE || rs < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) rs;
    }
}
