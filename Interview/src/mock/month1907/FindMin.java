package mock.month1907;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-20 10:36
 **/
public class FindMin {
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid;
            } else {
                return linearSearch(nums);
            }
        }
        return nums[l] > nums[r] ? nums[r] : nums[l];
    }

    private static int linearSearch(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            min = min < n ? min : n;
        }
        return min;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,3};
        System.out.println(findMin(nums));
    }
}
