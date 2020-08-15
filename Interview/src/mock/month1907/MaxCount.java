package mock.month1907;


/**
 * @author li
 * @version 1.0
 * @date 2019-07-28 10:15
 **/
public class MaxCount {

    public int maxCount(int m, int n, int[][] ops) {
        int minx = m;
        int miny = n;
        for (int[] op : ops) {
            minx = Math.min(minx, op[0]);
            miny = Math.min(miny, op[1]);
        }
        return minx * miny;
    }

    public static void main(String[] args) {
        int m = 2, n = 3;
        int[][] ops = {{2, 2}, {3, 3}};
        MaxCount maxCount = new MaxCount();
        System.out.println(maxCount.maxCount(2, 3, ops));
    }
}
