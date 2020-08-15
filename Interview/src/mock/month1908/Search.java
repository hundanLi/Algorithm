package mock.month1908;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-03 18:45
 **/
public class Search {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        }
        int m = begin + (end - begin) / 2;
        if (nums[m] == target) {
            return m;
        } else {
            int l = search(nums, begin, m - 1, target);
            if (l != -1) {
                return l;
            }
            return search(nums, m + 1, end, target);
        }
    }
}
