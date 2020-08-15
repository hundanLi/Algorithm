package problems.greedy;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-19 11:55
 **/
public class MinDeletionSize {
    public int minDeletionSize(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int n = strs[0].length();
        int m = strs.length;
        int size = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    size++;
                    break;
                }
            }
        }
        return size;
    }
}
