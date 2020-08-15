package problems.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-18 10:47
 **/
public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1];
            }
        });
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[][] ans = new int[pq.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.remove();
        }
        return ans;
    }
}
