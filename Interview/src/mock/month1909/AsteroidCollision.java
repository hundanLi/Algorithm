package mock.month1909;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-24 16:04
 **/
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return null;
        }
        int negIdx = 0;
        List<Integer> list = new ArrayList<>(asteroids.length);
        while (true) {
            int i = negIdx;
            for (; i < asteroids.length; i++) {
                if (asteroids[i] < 0) {
                    negIdx = i;
                    break;
                } else {
                    list.add(asteroids[i]);
                }
            }
            if (i == asteroids.length) {
                break;
            }
            int neg = asteroids[negIdx];
            while (true) {
                if (list.size() <= 0) {
                    list.add(neg);
                    break;
                }
                int val = list.get(list.size() - 1);
                if (val < 0) {
                    list.add(neg);
                    break;
                } else {
                    if (val < -neg) {
                        // 正行星被撞飞
                        list.remove(list.size() - 1);
                    } else if (val == -neg) {
                        // 两个行星都被撞飞
                        list.remove(list.size() - 1);
                        break;
                    } else {
                        // 负行星被撞飞
                        break;
                    }
                }
            }
            negIdx++;
        }

        int[] ans = new int[list.size()];
        int i = 0;
        for (int n : list) {
            ans[i++] = n;
        }
        return ans;
    }
}
