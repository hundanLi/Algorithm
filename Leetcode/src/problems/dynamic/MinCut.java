package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-11 09:43
 * 思路：
 * times[i]表示s[0:i]的最小切割次数，则
 * times[i] = min(times[j] + 1)，当s[j:i]是回文串
 **/
public class MinCut {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int step = 1; step < n; step++) {
            for (int i = 0; i < n - step; i++) {
                if (s.charAt(i) == s.charAt(i + step) && (step == 1 || isPalindrome[i + 1][i + step - 1])) {
                    isPalindrome[i][i + step] = true;
                }
            }
        }
        int[] times = new int[n + 1];
        times[0] = -1;
        for (int j = 1; j <= n; j++) {
            times[j] = j - 1;
            for (int i = 0; i < j; i++) {
                if (isPalindrome[i][j - 1]) {
                    times[j] = Math.min(times[j], times[i] + 1);
                }
            }
        }
        return times[n];
    }

    public static void main(String[] args) {
        String s = "aabbcba";
        int i = new MinCut().minCut(s);
        System.out.println(i);
    }
}
