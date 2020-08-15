package problems.dynamic;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-20 10:47
 **/
public class VideoStitching {
    public int videoStitching(int[][] clips, int t) {
        Arrays.sort(clips, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int last = 0;
        int num = 0;
        for (int i = 0; i < clips.length && last < t;) {
            if (clips[i][0] <= last) {
                int curLast = last;
                while (i < clips.length && clips[i][0] <= curLast) {
                    last = Math.max(last, clips[i][1]);
                    i++;
                }
                num++;
            } else {
                break;
            }
        }
        return last >= t ? num : -1;

    }
}
