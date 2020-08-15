package explore.algorithm.senior.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-26 16:35
 **/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subsets(nums, 0, list, lists);
        return lists;
    }

    private void subsets(int[] nums, int idx, List<Integer> list, List<List<Integer>> lists) {
        List<Integer> arrayList = new ArrayList<>(list);
        lists.add(arrayList);
        for (int i = idx; i < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            subsets(nums, i + 1, newList, lists);
        }
    }
}
