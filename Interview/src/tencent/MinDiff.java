package tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-20 20:44
 **/
public class MinDiff {
    private static int[] minDiff(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 2) {
            return nums;
        }
        int part1 = 0;
        int part2 = 0;
        int l = 0;
        int r = n - 1;
        boolean odd = true;
        while (l <= r) {
            if (l == r) {
                if (part1 > part2) {
                    part2 += nums[l];
                } else {
                    part1 += nums[l];
                }
                break;
            }
            if (odd) {
                odd = false;
                part1 += (nums[l++] + nums[r--]);
            } else {
                odd = true;
                part2 += (nums[l++] + nums[r--]);
            }
        }
        int[] res = new int[]{part1, part2};
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
            }
            int[] ints = minDiff(nums);
            System.out.print(ints[0] + " " + ints[1]);

        }
    }

}
