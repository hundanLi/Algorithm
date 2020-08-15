package explore.algorithm.junior.array;

/**
 * @author li
 * @version 1.0
 * @date 18-8-11 上午10:37
 **/
public class SingleNumber {
    /**
     * 异或的性质：
     *
     *     1、交换律：a^b = b^a；
     *
     *     2、结合律：(a^b)^c = a^(b^c)；
     *
     *     3、对于任意的a：a^a=0，a^0=a，a^(-1)=~a。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
