package problems.greedy;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-19 16:21
 **/
public class BrokenCalc {
    public int brokenCalc(int x, int y) {
        int cnt = 0;
        while (y > x) {
            cnt++;
            if ((y & 1) == 1) {
                y++;
            } else {
                y = y >> 1;
            }
        }
        return cnt + x - y;
    }
}
