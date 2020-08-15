package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-16 16:59
 **/
public class MinFlips {
    public int minFlips(int a, int b, int c) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            int am = a & (1 << i);
            int bm = b & (1 << i);
            int cm = c & (1 << i);
            if ((am | bm) != cm) {
                if (cm > 0) {
                    num++;
                } else {
                    num += am > 0 ? 1 : 0;
                    num += bm > 0 ? 1 : 0;
                }
            }
        }
        return num;
    }
}
