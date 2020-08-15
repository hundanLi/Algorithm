package problems.bitwise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-14 10:55
 **/
public class SubarrayBitwiseORs {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> last = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        last.add(0);
        for (int or : arr) {
            for (int l : last) {
                cur.add(l | or);
            }
            cur.add(or);
            set.addAll(cur);
            last = cur;
            cur = new HashSet<>();
        }
        return set.size();
    }

    public int subarrayBitwiseORs1(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                if ((arr[i] | arr[j]) == arr[j]) {
                    // arr[j]的置位位置包含了arr[i]的置位位置，
                    // 那么已经无需考虑arr[i]的加入与否
                    break;
                }
                // 求值的同时保留积累状态
                arr[j] |= arr[i];
                set.add(arr[j]);
            }
        }
        return set.size();
    }

}
