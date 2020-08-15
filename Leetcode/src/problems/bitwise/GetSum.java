package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-11 12:40
 **/
public class GetSum {
    public int getSum(int a, int b) {
        // and保存进位， xor保存忽略进位的二进制加法结果
        int and = (a & b) << 1;
        int xor = a ^ b;
        while (and != 0) {
            a = and;
            b = xor;
            and = (a & b) << 1;
            xor = a ^ b;
        }
        return xor;
    }
}
