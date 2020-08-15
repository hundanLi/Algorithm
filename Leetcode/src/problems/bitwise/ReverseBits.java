package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-10 11:56
 **/
public class ReverseBits {
    public int reverseBits(int num) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 0;
            if ((num & (1 << 31 - i)) != 0) {
                bit = 1;
            }
            result += (bit << i);
        }
        return result;
    }
}
