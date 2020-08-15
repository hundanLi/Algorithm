package leetcodecup.spring2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-18 15:08
 **/
public class NumWays {
    public int numWays(int n, int[][] relation, int k) {
        List<List<Integer>> nextPersons = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nextPersons.add(new ArrayList<>());
        }
        for (int[] re : relation) {
            nextPersons.get(re[0]).add(re[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (queue.size() > 0 && k > 0) {
            int size = queue.size();
            k--;
            for (int i = 0; i < size; i++) {
                int person = queue.remove();
                for (Integer next : nextPersons.get(person)) {
                    queue.offer(next);
                }
            }
        }
        int count = 0;
        for (int dest : queue) {
            if (dest == n - 1) {
                count++;
            }
        }
        return count;
    }
}
