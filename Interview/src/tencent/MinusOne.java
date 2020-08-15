package tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-20 21:25
 **/
public class MinusOne {
    private static void minusOne(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            int j = 0;
            int x = 0;
            for (; j < nums.length; j++) {
                if (nums[j] > 0) {
                    System.out.println(nums[j]);
                    x = nums[j];
                    break;
                }
            }
            if (j == nums.length) {
                while (i < k) {
                    System.out.println(0);
                    i++;
                }
            }
            for (; j < nums.length; j++) {
                nums[j]-=x;
            }
        }
    }
    private static void minus(int[] nums, int k) {
        Arrays.sort(nums);
        int x = 0;
        int start = 0;
        for (int i = 0; i < k; i++) {
            int j = start;
            for (; j < nums.length; j++) {
                if (nums[j] - x > 0) {
                    System.out.println(nums[j] - x);
                    x = nums[j];
                    start = j + 1;
                    break;
                }
            }
            if (j == nums.length) {
                while (i < k) {
                    System.out.println(0);
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] clone = nums.clone();
        minusOne(clone, k);
        minus(nums, k);
    }
}
