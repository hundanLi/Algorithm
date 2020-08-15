package problems.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-21 15:58
 **/
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 0;
        int rightIndex = nums.length - 1;
        for (int i = 0; i <= rightIndex; i++) {
            if (nums[i] == val) {
                cnt++;
                swap(nums, i--, rightIndex--);
            }
        }

        return nums.length - cnt;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int i = removeElement(nums, val);
        System.out.println(i);
    }

    class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums == null) {
                return 0;
            }
            int i = 0;
            int j = 0;
            while (i < nums.length) {
                if (nums[i] == val) {
                    i++;
                    continue;
                }
                nums[j] = nums[i];
                j++;
                i++;
            }
            return j;
        }
    }
}
