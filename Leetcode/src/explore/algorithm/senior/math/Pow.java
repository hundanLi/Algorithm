package explore.algorithm.senior.math;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-11 13:12
 **/
public class Pow {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long absExp = Math.abs((long) n);
        double prod = 1.0;
        while (absExp != 0) {
            if ((absExp & 1) == 1) {
                prod *= x;
            }
            //转化为(x * x) exp(n/2)
            x *= x;
            absExp  >>= 1;
        }

        if (n < 0) {
            prod = 1.0 / prod;
        }
        return prod;
    }

    public static void main(String[] args) {
        double x = 1.00000;
        int n = -2147483648;
        Pow pow = new Pow();
        System.out.println(pow.myPow(x, n));
    }
}