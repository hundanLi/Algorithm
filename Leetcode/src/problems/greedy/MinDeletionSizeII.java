package problems.greedy;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-19 13:31
 **/
public class MinDeletionSizeII {

    public static int minDeletionSize1(String[] strs){
        if (strs == null || strs.length < 2) {
            return 0;
        }
        int arrLen = strs.length;
        int strLen = strs[0].length();
        // 如果cuts[i] = true， 那么我们不需要再检查 strs[i][j] > strs[i+1][j]
        boolean[] cuts = new boolean[arrLen];
        int ans = 0;
        boolean delete;

        for (int j = 0; j < strLen; j++) {
            delete = false;
            for (int i = 0; i < arrLen - 1; i++) {
                if (!cuts[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    ans++;
                    delete = true;
                    break;
                }
            }
            if (!delete) {
                // 更新cuts
                for (int i = 0; i < arrLen - 1; i++) {
                    if (strs[i].charAt(j) < strs[i + 1].charAt(j)) {
                        cuts[i] = true;
                    }
                }
            }
        }
        return ans;
    }

    public static int minDeletionSize(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int arrLen = strs.length;
        int strLen = strs[0].length();
        int delete = 0;
        String[] keep = new String[arrLen];
        Arrays.fill(keep, "");

        for (int i = 0; i < strLen; i++) {
            String[] temp = Arrays.copyOf(keep, arrLen);
            for (int j = 0; j < arrLen; j++) {
                temp[j] += strs[j].charAt(i);
            }
            if (isSorted(temp)) {
                keep = temp;
            } else {
                delete++;
            }

        }
        return delete;
    }

    private static boolean isSorted(String[] strings) {
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].compareTo(strings[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"abx", "agz", "bgc", "bfc"};
        int size = minDeletionSize(strs);
        System.out.println(size);

    }
}
