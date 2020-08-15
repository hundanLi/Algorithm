package explore.bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-17 09:30
 **/
public class MergeIntervel {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        List<int[]> list = new ArrayList<>(intervals.length);
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        list.add(intervals[0]);
        for (int[] interval : intervals) {
            if (list.get(list.size() - 1)[1] < interval[0]) {
                list.add(interval);
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], interval[1]);
            }
        }
        int[][] ans = new int[list.size()][2];
        int i = 0;
        for (int[] ints : list) {
            ans[i++] = ints;
        }
        return ans;
    }
}