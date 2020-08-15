package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-10 10:03
 **/
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int num = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                num++;
            }
        }
        return num == 1;
    }


    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
