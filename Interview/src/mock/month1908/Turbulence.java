package mock.month1908;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-31 10:47
 **/
public class Turbulence {
    public int maxTurbulenceSize(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return nums[0] != nums[1] ? 2 : 1;
        }
        int begin = 0;
        int flag = 0;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            boolean check = check(diff, flag);
            if (flag == 0) {
                flag = Integer.compare(diff, 0);
                if (flag != 0) {
                    max = Math.max(max, i - begin + 1);
                }
            } else if (check) {
                max = Math.max(max, i - begin + 1);
                flag = -flag;
            } else {
                if (diff != 0) {
                    begin = i - 1;
                } else {
                    begin = i;
                }
            }
        }
        return max;
    }

    private boolean check(int diff, int flag) {
        int temp = 0;
        if (diff > 0) {
            temp = 1;
        } else if (diff < 0) {
            temp = -1;
        }
        return Math.abs(flag - temp) > 1;
    }
}
