package explore.algorithm.high.other;


/**
 * @author li
 * @version 1.0
 * @date 2019-04-03 17:01
 * 递增栈
 **/
public class LargestRectangleArea {
    public int largestRectangleArea(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int min;
        for (int i = 0; i < num.length; i++) {
            min = num[i];
            for (int j = i; j < num.length; j++) {
                min = Math.min(min, num[j]);
                int currArea = min * (j - i + 1);
                maxArea = Math.max(maxArea, currArea);
            }
        }
        return maxArea;
    }
}
