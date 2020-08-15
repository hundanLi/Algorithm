package mock.month1909;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-04 09:41
 **/
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int nextIdx = nums[i];
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int len = 1;
            while (nextIdx != i) {
                visited[nextIdx] = true;
                nextIdx = nums[nextIdx];
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
