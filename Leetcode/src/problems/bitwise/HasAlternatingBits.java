package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-12 15:32
 **/
public class HasAlternatingBits {
    public boolean hasAlternatingBits(int num) {
        int mask = num >> 1;
        while (num > 0) {
            if (((mask ^ num) & 1) == 0) {
                return false;
            }
            num >>= 1;
            mask >>= 1;
        }
        return true;
    }
}
