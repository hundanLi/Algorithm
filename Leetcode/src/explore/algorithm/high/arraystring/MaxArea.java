package explore.algorithm.high.arraystring;

import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-13 21:44
 **/
public class MaxArea {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int small = Math.min(height[i], height[j]);
                int cur = small * (j - i);
                if (cur > max) {
                    max = cur;
                }
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int cur = Math.min(height[l], height[r]) * (r - l);
            if (cur > max) {
                max = cur;
            }
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
