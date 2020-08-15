package mock.month1907;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-21 11:17
 **/
public class IntervalIntersection {
    public static int[][] intervalIntersection(int[][] intervalArr, int[][] intervalBrr) {

        if (intervalArr == null || intervalArr.length == 0 ||
                intervalBrr == null || intervalBrr.length == 0) {
            return new int[0][0];
        }

        List<int[]> list = new ArrayList<>(intervalArr.length);

        int i = 0;
        int j = 0;
        int[] inA;
        int[] inB;
        while (i < intervalArr.length && j < intervalBrr.length) {
            inA = intervalArr[i];
            inB = intervalBrr[j];
            if (inA[1] < inB[0]) {
                i++;
            } else if (inB[1] < inA[0]) {
                j++;
            } else {
                int[] inS = new int[2];
                inS[0] = inA[0] > inB[0] ? inA[0] : inB[0];
                inS[1] = inA[1] < inB[1] ? inA[1] : inB[1];
                list.add(inS);
                if (inA[1] >= inB[1]) {
                    j++;
                } else {
                    i++;
                }
            }

        }
        int[][] ans = new int[list.size()][2];
        int idx = 0;
        for (int[] ints : list) {
            ans[idx++] = ints;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(Arrays.deepToString(intervalIntersection(A, B)));

    }

}
