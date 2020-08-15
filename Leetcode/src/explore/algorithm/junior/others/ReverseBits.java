package explore.algorithm.junior.others;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-23 19:28
 **/
public class ReverseBits {
    public int reverseBits(int n) {
        int rs = 0;
        for (int i = 0; i < 32; i++) {
            rs |= ((n & 1) << (31 - i));
            n >>= 1;
        }
        return rs;
    }
}
