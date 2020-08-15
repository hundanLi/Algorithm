package problems.greedy;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-18 17:41
 **/
public class CanJump {
    public boolean canJump(int[] nums) {
        boolean[] can = new boolean[nums.length];
        can[0] = true;
        for (int i = 0; i < can.length; i++) {
            if (can[i]) {
                for (int j = i + 1; j < can.length && j <= i + nums[i]; j++) {
                    can[j] = true;
                }
            }
        }
        return can[can.length - 1];
    }

    public boolean canJump2(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new CanJump().canJump2(nums));
    }
}
