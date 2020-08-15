package explore.algorithm.senior.sortsearch;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-08 13:18
 **/
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] rs = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return rs;
        }
        rs[0] = nums.length;
        binarySearch(nums, 0, nums.length - 1, rs, target);
        if (rs[0] == nums.length) {
            rs[0] = -1;
        }
        return rs;
    }

    private void binarySearch(int[] nums, int left, int right, int[] rs, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                rs[0] = Math.min(rs[0], mid);
                rs[1] = Math.max(rs[1], mid);
                binarySearch(nums, left, mid-1, rs, target);
                binarySearch(nums, mid + 1, right, rs, target);
            } else if (nums[mid] > target) {
                right = mid - 1;
                binarySearch(nums, left, right, rs, target);
            } else {
                left = mid + 1;
                binarySearch(nums, left, right, rs, target);
            }
        }
    }
}
