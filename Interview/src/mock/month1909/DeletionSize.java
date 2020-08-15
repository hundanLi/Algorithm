package mock.month1909;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-22 12:19
 **/
public class DeletionSize {
    public int minDeletionSize(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int ans = 0;
        int wordLen = strs[0].length();
        int len = strs.length;
        // 如果strs[i][0:j] < strs[i+1][0:j]，那么设sorted[i] = true;
        // 后续就不需要比较strs[i][j:]和strs[i][j:]
        boolean[] sorted = new boolean[len - 1];
        for (int i = 0; i < wordLen; i++) {
            int j = 0;
            for (; j < len - 1; j++) {
                if (!sorted[j] && strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    // 删除该列
                    ans++;
                    break;
                }
            }
            if (j == len - 1) {
                for (int k = 0; k < len - 1; k++) {
                    if (strs[k].charAt(i) < strs[k + 1].charAt(i)) {
                        sorted[k] = true;
                    }
                }
            }
        }
        return ans;
    }
}
