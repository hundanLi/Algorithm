package mock.month1909;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-06 12:51
 **/
public class OverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int num = 0;
        int prev = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                continue;
            }
            if (intervals[i][1] < intervals[prev][1]) {
                prev = i;
                num++;
            } else if (intervals[i][0] < intervals[prev][1]) {
                num++;
            }
        }
        return num;
    }
}
