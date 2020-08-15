package explore.datastructure.binarysearch;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-12 10:52
 **/
public class DistancePair {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        // l,r represent the diff
        int l = 0;
        int r = nums[n - 1] - nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int j = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= mid) {
                    j++;
                }
                count += j - i - 1;
            }
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        //l == r
        return l;
    }
}
