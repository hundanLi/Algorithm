package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-11 00:22
 **/
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }
}
