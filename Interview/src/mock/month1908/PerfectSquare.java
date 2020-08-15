package mock.month1908;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-28 09:48
 **/
public class PerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        long l = 0;
        long r = num;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long midSq = mid * mid;
            if (midSq == num) {
                return true;
            } else if (midSq > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
