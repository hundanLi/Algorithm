package problems.dynamic;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-18 19:45
 **/
public class CanCross {
    /**
     * dp
     */
    public static boolean canCross0(int[] num) {
        if (num == null || num.length == 0 || num.length == 1) {
            return true;
        }
        if (num[0] + 1 != num[1]) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : num) {
            set.add(n);
        }
        Map<Integer, Set<Integer>> nextStep = new HashMap<>(num.length);
        nextStep.put(num[1], new HashSet<>(Arrays.asList(1, 2)));
        Set<Integer> step;
        for (int i = 1; i < num.length; i++) {
            if (nextStep.containsKey(num[i])) {
                step = nextStep.get(num[i]);
                for (int s : step) {
                    if (s == 0) {
                        continue;
                    }
                    int next = num[i] + s;
                    if (set.contains(next)) {
                        Set<Integer> steps = nextStep.getOrDefault(next, new HashSet<>());
                        steps.addAll(Arrays.asList(s - 1, s, s+1));
                        nextStep.put(next, steps);
                    }
                }
            }
        }
        return nextStep.containsKey(num[num.length - 1]);
    }

    /**
     * dp + dfs
     */
    public static boolean canCross1(int[] num) {
        if (num == null || num.length == 0 || num.length == 1) {
            return true;
        }
        boolean[][] tried = new boolean[num.length][num.length];
        return dfs(num, 0, 0, tried);
    }

    private static boolean dfs(int[] num, int cur, int step, boolean[][] tried) {
        if (cur >= num.length) {
            return false;
        }
        if (cur == num.length - 1) {
            return true;
        }
        if (tried[cur][step]) {
            return false;
        }
        for (int i = cur + 1; i < num.length; i++) {
            int gap = num[i] - num[cur];
            if (gap < step - 1) {
                continue;
            }
            if (gap > step + 1) {
                break;
            }
            if (dfs(num, i, gap, tried)) {
                return true;
            }
        }
        tried[cur][step] = true;
        return false;
    }

    public static void main(String[] args) {
        int[] num = {0, 1, 3, 4, 5, 7, 9, 10, 12};
        boolean b = canCross1(num);
        System.out.println(b);
    }
}
