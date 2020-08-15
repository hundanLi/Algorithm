package explore.algorithm.junior.others;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-23 19:19
 **/
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        return hammingWeight(z);
    }

    private int hammingWeight(int n) {
        int numOfOne = 0;
        int test = 1;
        for (int i = 0; i < 32; i++) {
            if ((test & n) != 0) {
                numOfOne++;
            }
            test <<= 1;
        }
        return numOfOne;
    }

    public static void main(String[] args) {

    }
}
