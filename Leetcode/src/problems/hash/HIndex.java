package problems.hash;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-26 09:43
 **/
public class HIndex {
    public int hIndex(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        while (i < n && nums[n - i - 1] > i) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3};
        System.out.println(new HIndex().hIndex(nums));

    }

    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] papers = new int[n + 1];
            // 计数
            for (int c: citations) {
                papers[Math.min(n, c)]++;
            }
            // 找出最大的 k
            int k = n;
            for (int s = papers[n]; k > s; s += papers[k]) {
                k--;
            }
            return k;
        }
    }

}
