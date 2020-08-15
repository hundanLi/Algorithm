package problems.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-22 11:20
 **/
public class Insert {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int len = intervals.length;
        int smallIndex = -2;
        for (int i = 0; i < len; i++) {
            if (intervals[i][0] > newInterval[0]) {
                smallIndex = i - 1;
                break;
            }
        }
        if (smallIndex == -2) {
            smallIndex = len - 1;
        }
        boolean[] merged = new boolean[intervals.length];
        int cnt = 0;
        int mergeBegin = newInterval[0];
        int mergeEnd = newInterval[1];
        if (smallIndex >= 0 && intervals[smallIndex][1] >= mergeBegin) {
            mergeBegin = intervals[smallIndex][0];
            merged[smallIndex] = true;
            cnt++;
            if (intervals[smallIndex][1] >= mergeEnd) {
                return intervals;
            }
        }
        for (int i = smallIndex + 1; i < len; i++) {
            if (intervals[i][0] <= mergeEnd) {
                mergeEnd = Math.max(mergeEnd, intervals[i][1]);
                merged[i] = true;
                cnt++;
            } else {
                break;
            }
        }
        int[][] res = new int[len - cnt + 1][2];
        boolean flag = false;
        int index = 0;
        if (mergeEnd < intervals[0][0]) {
            res[index++] = new int[]{mergeBegin, mergeEnd};
            flag = true;
        }
        for (int i = 0; i < len; i++) {
            if (!merged[i] && intervals[i][1] < mergeBegin) {
                res[index++] = intervals[i];
            } else{
                if (flag && !merged[i]) {
                    res[index++] = intervals[i];
                } else if (!flag){
                    i--;
                    res[index++] = new int[]{mergeBegin, mergeEnd};
                    flag = true;
                }
            }
        }
        if (!flag) {
            res[index] = new int[]{mergeBegin, mergeEnd};
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,7},{8,10},{12,16}};
//        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 5};
        int[][] insert = insert(intervals, newInterval);
        for (int[] ints : insert) {
            System.out.print("[" + ints[0] + "," + ints[1] + "],");
        }
    }
}
