package explore.datastructure.binarysearch;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-10 10:55
 **/
public class Sqrt {
    public static int mySqrt(int x) {
        int l = 0;
        int r = x / 2 + 1;
        int mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            long midS = mid * mid;
            if (midS == x) {
                return mid;
            } else if (midS > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));

    }
}
