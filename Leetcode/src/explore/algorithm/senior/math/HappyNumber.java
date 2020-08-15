package explore.algorithm.senior.math;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-10 22:27
 **/
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        int rs = forSum(n);
        while (!set.contains(rs)) {
            set.add(rs);
            if (rs == 1) {
                return true;
            }
            rs = forSum(rs);
        }
        return false;
    }

    private int forSum(int n) {
        int sum = 0;
        while (n != 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        System.out.println(sum);
        return sum;

    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        boolean happy = happyNumber.isHappy(21);
        System.out.println(happy);

    }
}
