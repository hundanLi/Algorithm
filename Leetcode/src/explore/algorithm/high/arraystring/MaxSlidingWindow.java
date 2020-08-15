package explore.algorithm.high.arraystring;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-16 20:27
 **/
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] maxK = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            maxK[index++] = max;
        }
        return maxK;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] rs = new int[nums.length - k + 1];
        int rsIdx = 0;
        Deque<Integer> index = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //删除超出窗口范围的索引
            while (!index.isEmpty() && index.peekFirst() < i - k + 1) {
                index.pollFirst();
            }
            //删除窗口中小于最右端值的索引
            while (!index.isEmpty() && nums[index.peekLast()] < nums[i]) {
                index.pollLast();
            }
            //将当前索引值添加到窗口（队尾）
            index.offerLast(i);
            if (i >= k - 1) {
                //队首索引的元素最大
                rs[rsIdx++] = nums[index.getFirst()];
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] ints = {3, 1, -1, -3, 5, 3, 6, 7};
        int[] rs = maxSlidingWindow2(ints, 3);
        System.out.println(Arrays.toString(rs));
    }
}
