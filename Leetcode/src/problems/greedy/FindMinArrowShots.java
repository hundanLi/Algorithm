package problems.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-14 10:58
 **/
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        int count = 1;
        int end = points[0][1];
        for (int[] point : points) {
            if (point[0] > end) {
                count++;
                end = point[1];
            } else {
                end = Math.min(end, point[1]);
            }
        }
        return count;
    }
}
