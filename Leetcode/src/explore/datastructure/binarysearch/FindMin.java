package explore.datastructure.binarysearch;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-11 10:27
 **/
public class FindMin {
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] <= nums[r]) {
            return nums[l];
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 1};
        System.out.println(findMin(nums));
    }
}
