package problems.greedy;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-15 08:07
 **/
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] nums = new int[26];
        for (char c : tasks) {
            nums[c - 'A']++;
        }
        int max = 0;
        int count = 1;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (max < num) {
                max = num;
                count = 1;
            } else if (max == num) {
                count++;
            }
        }
        int space = (n + 1) * (max - 1) + count;
        return Math.max(space, tasks.length);
    }
}
