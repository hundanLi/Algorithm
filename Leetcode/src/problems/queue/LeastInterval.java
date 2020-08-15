package problems.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2020-01-16 00:28
 **/
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Comparator.reverseOrder());
        for (int count : counts) {
            if (count > 0) {
                queue.offer(count);
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>(queue.size());
            int i = 0;
            while (i <= n) {
                if (!queue.isEmpty()) {
                    temp.add(queue.remove() - 1);
                } else {
                    break;
                }
                time++;
                i++;
            }
            for (Integer t : temp) {
                if (t > 0) {
                    queue.offer(t);
                }
            }
            if (!queue.isEmpty()) {
                time += (n - i + 1);
            }
        }
        return time;
    }
}
