package explore.algorithm.junior.math;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-21 23:40
 **/
public class CountPrimes {
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int i = countPrimes(2);
        System.out.println(i);
    }
}
