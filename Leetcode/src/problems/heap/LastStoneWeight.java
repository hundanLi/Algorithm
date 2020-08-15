package problems.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-18 11:26
 **/
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int s : stones) {
            pq.offer(s);
        }
        while (pq.size() > 1) {
            int big = pq.remove();
            int small = pq.remove();
            if (big > small) {
                pq.offer(big - small);
            }
        }
        if (pq.size() > 0) {
            return pq.remove();
        }
        return 0;
    }
}
