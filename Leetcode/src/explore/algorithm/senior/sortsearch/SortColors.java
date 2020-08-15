package explore.algorithm.senior.sortsearch;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-26 23:24
 **/
public class SortColors {
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int sIdx = 0;
        int bIdx = nums.length - 1;
        while (sIdx < nums.length && nums[sIdx] == 0) {
            sIdx++;
        }
        while (bIdx >= 0 && nums[bIdx] == 2) {
            bIdx--;
        }
        for (int i = sIdx; i <= bIdx; i++) {
            if (nums[i] == 2) {
                swap(nums, i, bIdx);
                while (bIdx >= 0 && nums[bIdx] == 2) {
                    bIdx--;
                }
                while (nums[sIdx] == 0 && i < nums.length && nums[i] == 0) {
                    i++;
                }
                i--;
            } else if (nums[i] == 0) {
                swap(nums, sIdx, i);
            }
            while (sIdx < nums.length && nums[sIdx] == 0) {
                sIdx++;
            }
            if (sIdx >= nums.length || bIdx < 0) {
                break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,2,1,1,2,1,1,1,0,2,1,0,1,2,1,0,1,1,1,2,2,1,2,0,0,1,0,2,1,2,2,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}
