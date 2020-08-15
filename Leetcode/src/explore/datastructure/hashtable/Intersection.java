package explore.datastructure.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-09 09:13
 **/
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] ans = new int[set2.size()];
        int i = 0;
        for (int e : set2) {
            ans[i++] = e;
        }
        return ans;

    }
}
