package explore.datastructure.binarysearch;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-12 10:05
 **/
public class FindMin2 {
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] < nums[r]) {
            return nums[l];
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else if (nums[mid] < nums[0]) {
                r = mid;
            } else {
                //nums[mid] == nums[0]
                for (int i = 0; i < nums.length - 1; i++) {
                    if (nums[i] > nums[i + 1]) {
                        return nums[i + 1];
                    }
                }
                return nums[0];
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 2, 2};
        System.out.println(findMin(nums));

    }
}
