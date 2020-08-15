package leetcodecup.spring2020;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-18 15:19
 **/
public class GetTriggerTime {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        if (requirements.length == 0) {
            return null;
        }
        if (increase.length == 0) {
            return new int[requirements.length];
        }
        int[][] map = new int[3][10 * increase.length + 1];
        for (int[] ints : map) {
            Arrays.fill(ints, -1);
        }
        for (int j = 0; j < increase[0].length; j++) {
            map[j][0] = 0;
            for (int k = 1; k <= increase[0][j]; k++) {
                map[j][k] = 1;
            }
        }
        for (int i = 1; i < increase.length; i++) {
            for (int j = 0; j < increase[i].length; j++) {
                increase[i][j] += increase[i - 1][j];
                for (int k = increase[i - 1][j] + 1; k <= increase[i][j]; k++) {
                    map[j][k] = i + 1;
                }
            }
        }

        int[] ans = new int[requirements.length];
        Arrays.fill(ans, -1);
        for (int j = 0; j < requirements.length; j++) {
            int[] requirement = requirements[j];
            if (requirement[0] > 10 * increase.length || requirement[1] > 10 * increase.length || requirement[2] > 10 * increase.length) {
                ans[j] = -1;
                continue;
            }
            int c = map[0][requirement[0]];
            int r = map[1][requirement[1]];
            int h = map[2][requirement[2]];
            if (c == -1 || r == -1 || h == -1) {
                ans[j] = -1;
            } else {
                ans[j] = Math.max(c, Math.max(r, h));
            }
        }
        return ans;
    }
}
