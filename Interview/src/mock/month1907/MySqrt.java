package mock.month1907;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-27 09:23
 **/
public class MySqrt {
    public int mySqrt(int x) {
        long l = 0;
        long r = (x) / 2 + 1;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long mm = m * m;
            if (mm == x) {
                return (int)m;
            } else if (mm > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int)r;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(2147395599));
    }
}
