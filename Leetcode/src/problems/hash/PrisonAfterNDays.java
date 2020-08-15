package problems.hash;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-21 15:32
 **/
public class PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cur, int days) {
        int n = cur.length;
        Map<Integer, Integer> map = new HashMap<>(16);
        int state = 0;
        for (int i = 0; i < n; i++) {
            if (cur[i] > 0) {
                state ^= (1 << i);
            }
        }
        while (days > 0) {
            if (map.containsKey(state)) {
                days %= (days - map.get(state));
            }
            map.put(state, days);
            if (days > 0) {
                state = getNext(state, n);
                days--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 1) {
                cur[i] = 1;
            } else {
                cur[i] = 0;
            }
        }
        return cur;
    }

    private int getNext(int state, int n) {
        int next = 0;
        for (int i = 1; i < n - 1; i++) {
            if (((state >> (i - 1) & 1)) == ((state >> (i + 1)) & 1)) {
                next ^= (1 << i);
            }
        }
        return next;
    }
}
