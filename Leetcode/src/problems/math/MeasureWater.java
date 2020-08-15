package problems.math;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-20 10:15
 **/
public class MeasureWater {
    public boolean canMeasureWater(int x, int y, int z) {
        return x == 0 || x + y >= z && z % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }
}
