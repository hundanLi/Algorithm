package mock.month1909;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-21 10:53
 **/
public class KSmallestPairs {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i : nums1) {
            for (int j : nums2) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                lists.add(list);
            }
        }
        lists.sort((o1, o2) -> (o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1)));
        List<List<Integer>> ans = new ArrayList<>(k);
        for (int l = 0; l < k && l < lists.size(); l++) {
            ans.add(lists.get(l));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }
}
