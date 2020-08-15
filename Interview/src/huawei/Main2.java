package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-27 19:06
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pair[] pairs = new Pair[6];
        pairs[0] = new Pair(0, 0);
        for (int i = 1; i <= 5; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            pairs[i] = new Pair(x, y);
        }
        int[] num = new int[]{1, 2, 3, 4, 5};
        List<List<Integer>> permute = permute(num);
        double min = Double.MAX_VALUE;
        for (List<Integer> path : permute) {
            double sum = distance(pairs[0], pairs[path.get(0)]);
            for (int i = 1; i < 5; i++) {
                sum += distance(pairs[path.get(i - 1)], pairs[path.get(i)]);
            }
            sum += distance(pairs[0], pairs[path.get(4)]);
            if (sum < min) {
                min = sum;
            }
        }

        System.out.println((int) (min));
    }

    private static double distance(Pair p1, Pair p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }

    static class Pair{
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
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
