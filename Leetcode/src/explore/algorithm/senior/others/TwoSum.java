package explore.algorithm.senior.others;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-11 15:38
 **/
public class TwoSum {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }

        //使用异或操作，找出不同的二进制位，这些位在相加时不进位
        //使用与操作，找出1的位，这些位在相加时会进位，并翻转为零
        return getSum(a ^ b, (a & b) << 1);
    }
}
