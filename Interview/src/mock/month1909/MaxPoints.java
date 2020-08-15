package mock.month1909;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-01 09:59
 **/
public class MaxPoints {
    private static final String SAME = "Same";
    private static final String INFINITY = "Infinity";
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int[] p1;
        int[] p2;
        int ans = 0;
        Map<String, Integer> map = new HashMap<>(points.length);
        for (int i = 0; i < points.length; i++) {
            p1 = points[i];
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    p2 = points[j];
                    String slope = slope(p1, p2);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }
            int same = map.getOrDefault(SAME, 0);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (SAME.equals(entry.getKey())) {
                    ans = Math.max(ans, same + 1);
                    continue;
                }
                ans = Math.max(ans, entry.getValue() + same + 1);
            }
        }
        return ans;
    }

    private String slope(int[] p1, int[] p2) {
        if (p1[0] == p2[0] && p1[1] == p2[1]) {
            return SAME;
        }
        if (p1[0] == p2[0]) {
            return INFINITY;
        }
        int dy = p1[1] - p2[1];
        int dx = p1[0] - p2[0];
        int gcd = gcd(dy, dx);
        dx /= gcd;
        dy /= gcd;
        return dy + "/" + dx;
    }

    private int gcd(int a, int b) {
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {1, 1}, {2, 2}, {2, 2}};
        MaxPoints maxPoints = new MaxPoints();
        System.out.println(maxPoints.maxPoints(points));
    }
}
