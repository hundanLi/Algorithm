package mock.month1908;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-06 09:11
 **/
public class ConstructRectangle {
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        if (sqrt * sqrt == area) {
            return new int[]{sqrt, sqrt};
        }
        for (int i = sqrt + 1; i < area; i++) {
            if (i * (area / i) == area) {
                return new int[]{i, area / i};
            }
        }
        return new int[]{area, 1};
    }
}
