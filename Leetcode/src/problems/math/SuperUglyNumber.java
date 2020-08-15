package problems.math;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-29 10:10
 **/
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        int[] uglyNums = new int[n];
        Arrays.fill(uglyNums, Integer.MAX_VALUE);
        uglyNums[0] = 1;
        int[] indexes = new int[primes.length];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < primes.length; j++) {
                int next = uglyNums[indexes[j]] * primes[j];
                uglyNums[i] = Math.min(uglyNums[i], next);
            }
            for (int j = 0; j < primes.length; j++) {
                if (uglyNums[i] >= uglyNums[indexes[j]] * primes[j]) {
                    indexes[j]++;
                }
            }
        }
        return uglyNums[n - 1];
    }

    public static void main(String[] args) {
        int n = 15;
        int[] primes = {3, 5, 7, 11, 19, 23, 29, 41, 43, 47};
        System.out.println(new SuperUglyNumber().nthSuperUglyNumber(n, primes));
    }
}
