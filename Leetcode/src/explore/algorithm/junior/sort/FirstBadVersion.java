package explore.algorithm.junior.sort;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-20 16:12
 **/
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean isBadVersion(int i) {
        return false;
    }
}
