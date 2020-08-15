package problems.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author li
 * @version 1.0
 * @date 2020-01-16 15:52
 **/
public class ShortestSubarray {
    public int shortestSubarray(int[] arr, int k) {
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < prefixSum.length; i++) {
            while (!deque.isEmpty() && prefixSum[deque.getLast()] >= prefixSum[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            int diff = prefixSum[i] - k;
            while (deque.size() > 1 && diff >= prefixSum[deque.getFirst()]) {
                ans = Math.min(ans, i - deque.getFirst());
                deque.removeFirst();
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
