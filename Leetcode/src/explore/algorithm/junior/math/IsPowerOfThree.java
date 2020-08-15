package explore.algorithm.junior.math;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-22 10:37
 **/
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        return loop(n);
    }

    private boolean notLoop(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
    private boolean loop(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
