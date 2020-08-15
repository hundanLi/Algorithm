package problems.math;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-25 10:09
 **/
public class ComputeArea {
    public int computeArea(int a, int b, int c, int d, int e, int f, int g, int h) {
        int area = (c - a) * (d - b) + (g - e) * (h - f);
        int left = Math.max(a, e);
        int right = Math.min(c, g);
        int up = Math.min(d, h);
        int down = Math.max(b, f);
        if (left >= right || down >= up) {
            return area;
        }
        return area - (right - left) * (up - down);
    }
}
