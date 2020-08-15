package tencent;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-20 21:40
 **/
public class SumNot {
    private static int not(int[] nums1, int[] nums2) {
        int ans = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                ans = ans ^ (i + j);
            }
        }
        return ans;
    }

    private static int not2(int[] nums1, int[] nums2) {
        int ans = 0;
        for (int i : nums1) {
            ans = ans ^ i;
        }
        for (int i : nums2) {
            ans = ans ^ i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = in.nextInt();
        }
        System.out.println(not(nums1, nums2));

    }
}
