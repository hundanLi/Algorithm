package leetcodecup.spring2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-18 16:18
 **/
public class MinJump {
    public int minJump(int[] jump) {
        int n = jump.length;
        int[] steps = new int[n];
        Arrays.fill(steps, -1);
        steps[0] = 0;
        int forward = -1;
        Queue<Integer> queue = new ArrayDeque<>(n);
        queue.offer(0);
        while (!queue.isEmpty()) {
            int head = queue.remove();
            while (forward + 1 <= head) {
                forward++;
                if (steps[forward] == -1) {
                    steps[forward] = steps[head] + 1;
                    queue.offer(forward);
                }
            }

            int next = head + jump[head];
            if (next >= n) {
                return steps[head] + 1;
            }
            if (steps[next] == -1) {
                steps[next] = steps[head] + 1;
                queue.offer(next);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] jump = new int[]{2, 5, 1, 1, 1, 1};
        long start = System.currentTimeMillis();
        System.out.println(new MinJump().minJump(jump));
        System.out.println(System.currentTimeMillis() - start);
    }
}
