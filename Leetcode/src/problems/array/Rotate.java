package problems.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-26 11:27
 **/
public class Rotate {
    public static void rotate(int[] nums, int k) {
        int n = nums.length - 1;
        while (k-- > 0) {
            int temp = nums[n];
            System.arraycopy(nums, 0, nums, 1, n);
            nums[0] = temp;
        }
    }
    
    class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            // 移动了多少个元素
            int count = 0;

            for (int start = 0; count < nums.length; start++) {
                int curIndex = start;
                int prevElem = nums[start];
                do {
                    int nextIndex = (curIndex + k) % nums.length;
                    int temp = nums[nextIndex];
                    nums[nextIndex] = prevElem;
                    prevElem = temp;
                    curIndex = nextIndex;
                    count++;
                } while (start != curIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
