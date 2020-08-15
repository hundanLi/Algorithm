package mock.month1907;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-19 09:06
 **/
public class FindInt {
    public int findIntegers(int num) {
        if (num == 0) {
            return 1;
        }
        if (num == 1) {
            return 2;
        }
        int bits = 0;
        while ((num >> bits) > 0) {
            bits++;
        }

        if ((num >> (bits - 2)) == 3) {
            return fib(bits);
        } else {
            int mask = (1 << (bits - 1)) - 1;
            return fib(bits - 1) + findIntegers(num & mask);
        }
    }

    private int fib(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        // n=0
        int a = 1;
        // n=1
        int b = 2;
        int i = n - 1;
        while (i-- > 0) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        FindInt findInt = new FindInt();
        System.out.println(findInt.findIntegers(1000000000));
    }
}
