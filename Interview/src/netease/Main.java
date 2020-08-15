package netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-02 20:21
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n <= 0) {
            return;
        }
        int maxWeight = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        int max = 0;
        List<List<Integer>> lists = permute(num);
        for (List<Integer> list : lists) {
            int i = helper(list, maxWeight);
            max = Math.max(i, max);
        }
        System.out.println(max);

    }

    private static int helper(List<Integer> num, int weight) {
        int count = 0;
        int i;
        for (i = 0; i < num.size() - 1; i++) {
            count++;
            if (num.get(i) + num.get(i + 1) <= weight) {
                i++;
            }
        }
        if (i == num.size() - 1) {
            count++;
        }
        return count;
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        permute(nums, 0, lists);
        return lists;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void permute(int[] nums, int idx, List<List<Integer>> lists) {
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
