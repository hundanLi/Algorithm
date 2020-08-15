package problems.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-29 10:20
 **/
public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length < 2) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>(16);

        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];
            if (e > 0 && e != i + 1) {
                if (nums[e - 1] == e) {
                    ans.add(e);
                    nums[i] = -1;
                }else {
                    nums[i] = nums[e - 1];
                    nums[e - 1] = e;
                    i--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = findDuplicates(nums);
        duplicates.forEach(System.out::println);
    }
}
