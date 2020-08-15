package mock.month1908;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-06 09:20
 **/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        List<int[]> list = new ArrayList<>(intervals.length);
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= list.get(list.size() - 1)[1]) {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }
        int[][] ans = new int[list.size()][2];
        int i = 0;
        for (int[] tup : list) {
            ans[i++] = tup;
        }
        return ans;
    }
}
