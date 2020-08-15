package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-18 21:25
 *
 * https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation%3A-8ms-Binary-Search-Java
 **/
public class SplitArray {
    public int splitArray(int[] num, int m) {
        if (num == null || num.length == 0 || m > num.length) {
            return 0;
        }

        int max = num[0];
        long sum = 0;
        for (int n : num) {
            max = Math.max(max, n);
            sum += n;
        }
        if (m == 1) {
            return (int) sum;
        }
        if (m == num.length) {
            return max;
        }
        long l = max;
        long r = sum;
        while (l <= r) {
            long mid = (r + l) / 2;
            if (valid(mid, num, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private boolean valid(long target, int[] num, int m) {
        int count = 1;
        long sum = 0;
        for (int n : num) {
            sum += n;
            if (sum > target) {
                sum = n;
                count++;
                if (count > m) {
                    //需要分成多于m个子数组才能使各子数组的和<target,此时应该增大target
                    return false;
                }
            }
        }
        //需要分成不多于m个子数组能使各子数组的和<target,此时应该减小target
        return true;
    }

}
