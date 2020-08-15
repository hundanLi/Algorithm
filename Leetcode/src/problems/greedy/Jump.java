package problems.greedy;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-19 17:57
 **/
public class Jump {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int forward = 0;
        int[] steps = new int[nums.length];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;

        for (int head = 0; head < nums.length; head++) {
            int next = head + nums[head];
            if (next >= nums.length - 1) {
                return steps[head] + 1;
            }
            while (forward < next) {
                forward++;
                steps[forward] = Math.min(steps[forward], steps[head] + 1);
            }
        }
        return -1;
    }

    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 跳跃次数
        int step = 0;
        //下一跳能够达到的最远位置
        int farthest = 0;
        // 下一跳的最晚起跳点
        int jump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == jump) {
                step++;
                jump = farthest;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Jump().jump2(nums));

    }
}
