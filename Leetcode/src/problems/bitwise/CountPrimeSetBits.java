package problems.bitwise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-13 11:34
 **/
public class CountPrimeSetBits {
    public int countPrimeSetBits(int l, int r) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
        int mask = 0;
        for (int p : primes) {
            mask |= 1 << p;
        }
        int sum = 0;
        for (int i = l; i <= r; i++) {
            int num = i;
            int count = 0;
            while (num > 0) {
                count++;
                num = num & (num - 1);
            }
            if ((mask & (1 << count)) > 0) {
                sum++;
            }
        }
        return sum;
    }

    public int countPrimeSetBits2(int l, int r) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
        int mask = 0;
        Set<Integer> set = new HashSet<>();
        for (int p : primes) {
            set.add(p);
        }
        int sum = 0;
        for (int i = l; i <= r; i++) {
            int num = i;
            int count = 0;
            while (num > 0) {
                count++;
                num = num & (num - 1);
            }
            if (set.contains(count)) {
                sum++;
            }
        }
        return sum;
    }
}
