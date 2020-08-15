package problems.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-19 17:00
 **/
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations1(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int n : nums) {
            priorityQueue.offer(n);
        }
        while (k-- > 0) {
            priorityQueue.offer(-priorityQueue.remove());
        }
        int sum = 0;
        for (int n : priorityQueue) {
            sum += n;
        }
        return sum;
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; k > 0 && i < nums.length && nums[i] < 0; i++, k--) {
            nums[i] = -nums[i];
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            sum += n;
            min = Math.min(min, n);
        }
        sum -= (k % 2) * min * 2;
        return sum;
    }
}
