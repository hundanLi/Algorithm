package problems.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-26 11:19
 **/
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l+1, r+1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }
}
