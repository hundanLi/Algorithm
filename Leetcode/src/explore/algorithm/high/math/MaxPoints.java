package explore.algorithm.high.math;


import java.util.Collection;
import java.util.HashMap;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-01 19:59
 **/
public class MaxPoints {
    static class Point {
        int x;
        int y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>(points.length);
        Collection<Integer> values;
        int max = 1;
        for (Point point : points) {
            int same = 0;
            for (Point point1 : points) {
                if (isSamePoint(point, point1)) {
                    same++;
                    continue;
                }
                String slope = getSlope(point, point1);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }
            values = map.values();
            if (values.size() == 0) {
                max = Math.max(same, max);
            } else {
                for (int n : values) {
                    n += same;
                    max = Math.max(n, max);
                }
            }
            map.clear();
        }
        return max;
    }

    private String getSlope(Point point1, Point point2) {

        if (point1.x != point2.x) {
            int dx = point1.x - point2.x;
            int dy = point1.y - point2.y;
            int gcd = gcd(dx, dy);
            dx /= gcd;
            dy /= gcd;
            return dy + "/" + dx;
        } else {
            return "Infinity";
        }
    }

    private boolean isSamePoint(Point point1, Point point2) {
        return point1.x == point2.x && point1.y == point2.y;
    }

    private int gcd(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        while (min != 0) {
            int tmp = max % min;
            max = min;
            min = tmp;
        }
        return max;
    }

    public static void main(String[] args) {
        //[[0,0],[94911151,94911150],[94911152,94911151]]
        Point point1 = new Point(0, 0);
        Point point2 = new Point(94911151,94911150);
        Point point3 = new Point(94911152,94911151);
        Point[] points = new Point[]{point1, point2, point3};
        int maxPoints = new MaxPoints().maxPoints(points);
        System.out.println(maxPoints);

    }
}
