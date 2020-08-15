package problems.greedy;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-14 11:44
 **/
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        if (s == null || g == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }
}
