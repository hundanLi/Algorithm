package problems.array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-27 11:12
 **/
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<String> ans = new LinkedList<>();
        int begin = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                end = nums[i];
            } else {
                if (begin != end) {
                    ans.add(begin + "->" + end);
                } else {
                    ans.add(begin + "");
                }
                begin = nums[i];
                end = nums[i];
            }
        }
        if (begin != end) {
            ans.add(begin + "->" + end);
        } else {
            ans.add(begin + "");
        }
        return ans;
    }
}
