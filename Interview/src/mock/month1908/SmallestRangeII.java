package mock.month1908;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-29 11:35
 **/
public class SmallestRangeII {
    public int smallestRangeII(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int res = arr[n - 1] - arr[0];
        for (int i = 1; i < n; i++) {
            int min = Math.min(arr[0] + k, arr[i] - k);
            int max = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            res = Math.min(max - min, res);
        }
        return res;
    }
}
