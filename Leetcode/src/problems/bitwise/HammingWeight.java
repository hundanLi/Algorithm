package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-10 12:07
 **/
public class HammingWeight {
    public int hammingWeight(int n) {
        int w = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                w++;
            }
            n = n >>> 1;
        }
        return w;
    }

    public static void main(String[] args) {
        int n = -3;
        System.out.println(new HammingWeight().hammingWeight(n));
    }
}
