package explore.algorithm.senior.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-26 13:17
 **/
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        permute(nums, 0, lists);
        return lists;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void permute(int[] nums, int idx, List<List<Integer>> lists) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            lists.add(list);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            permute(nums, idx + 1, lists);
            swap(nums, i, idx);
        }
    }
}
