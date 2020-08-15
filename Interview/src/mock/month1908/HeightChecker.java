package mock.month1908;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-29 12:54
 **/
public class HeightChecker {
    public int heightChecker(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int num = 0;
        for (int i = 0; i < heights.length; i++) {
            if (copy[i] != heights[i]) {
                num++;
            }
        }
        return num;
    }

    public int heightChecker2(int[] heights) {
        int[] count = new int[101];
        for (int height : heights) {
            count[height]++;
        }
        int num = 0;
        for (int i = 1, j = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                if (heights[j++] != i) {
                    num++;
                }
            }
        }
        return num;
    }
}
