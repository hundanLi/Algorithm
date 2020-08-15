package explore.datastructure.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-11 10:55
 **/
public class ClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                l = mid;
                r = mid + 1;
            } else if (arr[mid] > x) {
                r = mid;
            } else {
                l = mid;
            }
        }
        while (k-- > 0) {
            if (l < 0) {
                r++;
            } else if (r >= arr.length) {
                l--;
            } else {
                if (arr[r] - x >= x - arr[l]) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        List<Integer> ans = new ArrayList<>(r - l);
        for (int i = l + 1; i < r; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
