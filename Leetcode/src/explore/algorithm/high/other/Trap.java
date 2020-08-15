package explore.algorithm.high.other;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-03 19:38
 * <p>
 * 思路：对于每个点，其中的雨水等于 min(其左边(包含本身)的最大值, 其右边(包含本身)的最大值) - 其本身
 **/
public class Trap {

    //暴力搜索
    public int trap1(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int maxLeft;
        int maxRight;
        int volume = 0;
        for (int i = 1; i < num.length - 1; i++) {
            maxLeft = 0;
            maxRight = 0;
            //寻找左边最大值
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, num[j]);
            }
            for (int j = i; j < num.length; j++) {
                maxRight = Math.max(maxRight, num[j]);
            }
            volume += Math.min(maxLeft, maxRight) - num[i];
        }
        return volume;
    }

    //动态规划
    public int trap(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] maxLeft = new int[heights.length];
        maxLeft[0] = heights[0];
        int[] maxRight = new int[heights.length];
        maxRight[heights.length - 1] = heights[heights.length - 1];
        for (int i = 1; i < heights.length - 1; i++) {
            maxLeft[i] = Math.max(heights[i], maxLeft[i - 1]);
        }
        for (int i = heights.length - 2; i > 0; i--) {
            maxRight[i] = Math.max(heights[i], maxRight[i + 1]);
        }
        int volume = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            volume += Math.min(maxLeft[i], maxRight[i]) - heights[i];
        }
        return volume;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2, 0, 2};
        int trap = new Trap().trap(num);
        System.out.println(trap);
    }
}
