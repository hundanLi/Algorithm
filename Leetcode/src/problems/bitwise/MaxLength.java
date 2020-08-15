package problems.bitwise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-16 01:04
 **/
public class MaxLength {
    static class ValidStr {
        int mask;
        int len;

        public ValidStr(int mask, int len) {
            this.mask = mask;
            this.len = len;
        }
    }

    public int maxLength(List<String> arr) {
        List<ValidStr> list = new ArrayList<>();
        int max = 0;
        for (String s : arr) {
            int mask = 0;
            int len = s.length();
            for (char c : s.toCharArray()) {
                int shift = 1 << c - 'a';
                if ((mask & shift) == 0) {
                    mask |= shift;
                } else {
                    mask = 0;
                    break;
                }
            }
            int curSize = list.size();
            if (mask > 0) {
                list.add(new ValidStr(mask, len));
                max = Math.max(max, len);
            } else {
                continue;
            }
            for (int j = 0; j < curSize; j++) {
                ValidStr prefix = list.get(j);
                if ((mask & prefix.mask) == 0) {
                    list.add(new ValidStr(mask | prefix.mask, len + prefix.len));
                    max = Math.max(max, len + prefix.len);
                }
            }
        }
        return max;
    }

    private int maxLen = 0;

    public int maxLengthDfs(List<String> arr) {
        dfs(arr, 0, 0, 0);
        return maxLen;
    }

    private void dfs(List<String> arr, int idx, int len, int mask) {
        for (int i = idx; i < arr.size(); i++) {
            int curMask = 0;
            boolean repeat = false;
            for (char c : arr.get(i).toCharArray()) {
                int shift = 1 << c - 'a';
                if ((curMask & shift) != 0 || (mask & shift) != 0) {
                    repeat = true;
                    break;
                }
                curMask |= shift;
            }
            if (!repeat) {
                int curLen = arr.get(i).length();
                maxLen = Math.max(maxLen, len + curLen);
                dfs(arr, i + 1, len + curLen, mask | curMask);
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = {"ab", "cd", "cde", "cdef", "efg", "fgh", "abxyz"};
        List<String> list = new ArrayList<>();
        Collections.addAll(list, strings);
        System.out.println(new MaxLength().maxLength(list));
        System.out.println(new MaxLength().maxLengthDfs(list));

    }
}
