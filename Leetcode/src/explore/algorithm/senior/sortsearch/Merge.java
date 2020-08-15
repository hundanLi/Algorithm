package explore.algorithm.senior.sortsearch;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-08 13:38
 **/
public class Merge {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> list = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) {
            return list;
        }
        intervals.sort(Comparator.comparingInt(o -> o.start));
        for (Interval i : intervals) {
            if (list.isEmpty() || list.getLast().end < i.start) {
                list.add(i);
            } else {
                list.getLast().end = Math.max(list.getLast().end, i.end);
            }
        }
        return list;
    }
}



