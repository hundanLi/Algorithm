package mock.month1909;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-20 10:30
 **/
public class KnightDialer {
    private static List<List<Integer>> nextNum = new ArrayList<>(10);
    private int ans;

    static {
        for (int i = 0; i < 10; i++) {
            nextNum.add(new ArrayList<>());
        }
        nextNum.get(0).addAll(Arrays.asList(4, 6));
        nextNum.get(1).addAll(Arrays.asList(6, 8));
        nextNum.get(2).addAll(Arrays.asList(7, 9));
        nextNum.get(3).addAll(Arrays.asList(4, 8));
        nextNum.get(4).addAll(Arrays.asList(0, 3, 9));
        nextNum.get(6).addAll(Arrays.asList(0, 1, 7));
        nextNum.get(7).addAll(Arrays.asList(2, 6));
        nextNum.get(8).addAll(Arrays.asList(1, 3));
        nextNum.get(9).addAll(Arrays.asList(2, 4));
    }
    private int mod = 1000_000_007;

    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }
        int[] pre = new int[10];
        int[] next = new int[10];
        int[] tmp;
        for (int i = 0; i < 10; i++) {
            pre[i] = 1;
        }
        while (--n > 0) {
            for (int i = 0; i < 10; i++) {
                if (pre[i] > 0) {
                    for (int e : nextNum.get(i)) {
                        next[e] += pre[i];
                        if (next[e] > mod) {
                            next[e] %= mod;
                        }
                    }
                }
                pre[i] = 0;
            }
            tmp = pre;
            pre = next;
            next = tmp;
        }
        for (int i : pre) {
            ans += i;
            if (ans >= mod) {
                ans %= mod;
            }
        }
        return ans % mod;
    }

    private void dfs(int num, int n) {
        if (n == 0) {
            ans++;
            if (ans > mod) {
                ans %= mod;
            }
            return;
        }
        for (int next : nextNum.get(num)) {
            dfs(next, n - 1);
        }
    }
}
