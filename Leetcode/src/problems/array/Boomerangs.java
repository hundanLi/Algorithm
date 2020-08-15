package problems.array;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-07 10:10
 **/
public class Boomerangs {

    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }
        Map<Key, Integer> map = new HashMap<>(16);
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] p = points[j];
                long dx = (long) (point[0] - p[0]);
                long dy = (long) (point[1] - p[1]);
                long distance = dx * dx + dy * dy;
                Key key = new Key(i, distance);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

        }
        int ans = 0;
        for (int n : map.values()) {
            if (n > 1) {
                ans += n * (n - 1);
            }
        }
        return ans;
    }

    static class Key {
        int index;
        long distance;

        Key(int index, long distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;

            Key key = (Key) o;

            if (index != key.index) return false;
            return distance == key.distance;
        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + (int) (distance ^ (distance >>> 32));
            return result;
        }
    }


    public int numberOfBoomerangs2(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Map<Long, Integer> map = new HashMap<>(16);
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                long dx = (long) (points[i][0] - points[j][0]);
                long dy = (long) (points[i][1] - points[j][1]);
                long d = dx * dx + dy * dy;
                int v = map.getOrDefault(d, 0);
                if (v > 0) {
                    ans += v * 2;
                }
                map.put(d, v + 1);
            }
        }
        return ans;
    }
}