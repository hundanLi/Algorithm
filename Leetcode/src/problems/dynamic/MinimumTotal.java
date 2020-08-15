package problems.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-11 00:02
 * 思路：
 *      设curRow[i-1]记录了从顶部到达当前行第i个位置的最小和值，
 *      preRow[i-1]记录了从顶部到达上一行第i个位置的最小和值，则
 *      curRow[i-1] = min(preRow[i-2], preRow[i-1]) + list.get(i-1)
 **/
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.get(triangle.size() - 1).size();
        int[] preRowTotal = new int[n];
        int[] curRowTotal = new int[n];
        for (List<Integer> row : triangle) {
            int size = row.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    curRowTotal[i] = preRowTotal[0] + row.get(i);
                } else if (i < size - 1) {
                    curRowTotal[i] = Math.min(preRowTotal[i - 1], preRowTotal[i]) + row.get(i);
                } else {
                    curRowTotal[i] = preRowTotal[i - 1] + row.get(i);
                }
            }
            System.arraycopy(curRowTotal, 0, preRowTotal, 0, curRowTotal.length);
        }
        int min = preRowTotal[0];
        for (int num : preRowTotal) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(2));
        lists.add(Arrays.asList(3,4));
        lists.add(Arrays.asList(6,5,7));
        lists.add(Arrays.asList(4,1,8,3));
        int total = new MinimumTotal().minimumTotal(lists);
        System.out.println(total);
    }
}
