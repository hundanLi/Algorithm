package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-11 17:40
 **/
public class IntegerReplacement {
    public int integerReplacement(int num) {
        long n = num;
        int count = 0;
        while (n > 1) {
            count++;
            if ((n & 1) == 0) {
                n >>= 1;
            } else {
                if (n == 3) {
                    n -= 1;
                } else if (n % 4 == 1) {
                    n -= 1;
                } else {
                    n += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerReplacement().integerReplacement(Integer.MAX_VALUE));
    }
}
