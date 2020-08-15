package problems.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-08 10:18
 **/
public class MaxPoints {
    public int maxPoints(int[][] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int[] point1;
        int[] point2;
        int same;
        int ans = 0;
        Map<String, Integer> map = new HashMap<>(points.length);
        for (int i = 0; i < points.length; i++) {
            map.clear();
            point1 = points[i];
            same = 1;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    point2 = points[j];
                    String slope = getSlope(point1, point2);
                    if ("".equals(slope)) {
                        same++;
                    } else {
                        map.put(slope, map.getOrDefault(slope, 0) + 1);
                    }
                }
            }
            for (int n : map.values()) {
                ans = Math.max(ans, n + same);
            }
            ans = Math.max(ans, same);
        }
        return ans;
    }

    private String getSlope(int[] point1, int[] point2) {
        if (point1[0] == point2[0] && point1[1] == point2[1]) {
            return "";
        }
        if (point1[0] == point2[0]) {
            return "I";
        }
        int dx = point1[0] - point2[0];
        int dy = point1[1] - point2[1];
        int gcd = gcd(dx, dy);

        dx /= gcd;
        dy /= gcd;
        return dy + "/" + dx;
    }

    private int gcd(int a, int b) {
        int m = Math.max(a, b);
        int n = Math.min(a, b);
        while (n != 0) {
            int tmp = m % n;
            m = n;
            n = tmp;
        }
        return m;
    }

    public static void main(String[] args) {
        MaxPoints maxPoints = new MaxPoints();
        int[][] arrays = {{1, 1}, {1, 1}, {1, 1}};
        int points = maxPoints.maxPoints(arrays);
        System.out.println(points);

        System.out.println(maxPoints.gcd(4, -2));
        System.out.println(maxPoints.gcd(-4, 2));
    }
}
