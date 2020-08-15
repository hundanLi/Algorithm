package problems.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-14 09:40
 **/
public class EraseOverlapIntervals {

    /**
     * 计算重叠区间
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int n = intervals.length;
        int pre = 0;
        int pos;
        int count = 0;
        for (pos = 1; pos < n; pos++) {
            if (intervals[pre][1] > intervals[pos][0]) {
                count++;
                //sample：[[1,4],[2,3],[3,4]]
                if (intervals[pre][1] > intervals[pos][1]) {
                    pre = pos;
                }
            } else {
                pre = pos;
            }
        }
        return count;
    }


    public int eraseOverlapIntervals1(int[][] intervals){
        if (intervals == null || intervals.length < 2) {
            return 0;
        }
        //根据区间上限排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int end = Integer.MIN_VALUE;
        int noOverlapNum = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                noOverlapNum++;
                end = interval[1];
            }
        }
        return intervals.length - noOverlapNum;
    }
}
