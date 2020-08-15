package explore.datastructure.binarysearch;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-11 11:42
 **/
public class PerfectSquare {
    public static boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num / 2 + 1;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < 0 || square > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 2147395600;
        System.out.println(isPerfectSquare(num));
    }

    class Solution {
        public boolean isPerfectSquare(int num) {
            int i = 1;
            while (num > 0) {
                num -= i;
                i += 2;
            }
            return num == 0;
        }
    }

}
