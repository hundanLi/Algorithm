package mock.month1909;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-18 09:38
 **/
public class StoneWeight {
    public int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone : stones) {
            priorityQueue.offer(stone);
        }
        while (priorityQueue.size() > 1) {
            int y = priorityQueue.remove();
            int x = priorityQueue.remove();
            int diff = y - x;
            if (diff > 0) {
                priorityQueue.offer(diff);
            }
        }
        if (priorityQueue.size() == 1) {
            return priorityQueue.remove();
        }
        return 0;
    }
}
