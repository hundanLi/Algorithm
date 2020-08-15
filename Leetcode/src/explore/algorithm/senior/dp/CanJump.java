package explore.algorithm.senior.dp;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-08 16:21
 **/
public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] canJump = new boolean[nums.length];
        canJump[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (!canJump[i]) {
                continue;
            }
            for (int j = 0; j <= nums[i] && i + j < nums.length; j++) {
                canJump[i + j] = true;
            }
        }
        return canJump[nums.length - 1];
    }

    public boolean canJump1(int[] nums) {
        int index = nums.length - 2,min = nums.length - 1;
        while(index >= 0){
            if(index + nums[index] >= min) min = index;
            index--;
        }
        return min == 0;
    }

}
