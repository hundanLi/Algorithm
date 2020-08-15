package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-11 23:09
 **/
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int mask = x ^ y;
        int count = 0;
        while (mask > 0) {
            mask = mask & (mask - 1);
            count++;
        }
        return count;
    }
}
