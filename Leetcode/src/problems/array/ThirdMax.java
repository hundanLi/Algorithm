package problems.array;


/**
 * @author li
 * @version 1.0
 * @date 2019-05-28 11:19
 **/
public class ThirdMax {
    public static int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("数组不能为空！");
        }
        if (nums.length < 3) {
            if (nums.length == 1) {
                return nums[0];
            } else {
                return Math.max(nums[0], nums[1]);
            }
        }
        int firstMax = nums[0];
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                int temp = firstMax;
                firstMax = nums[i];
                thirdMax = secondMax;
                secondMax = temp;
            } else if (nums[i] > secondMax && nums[i] < firstMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
            }
        }
        if (thirdMax != Long.MIN_VALUE) {
            return (int) thirdMax;
        }
        return firstMax;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 5, 3, 5};
        System.out.println(thirdMax(nums));
    }
}
