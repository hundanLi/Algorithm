package explore.bytedance.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-04 11:36
 **/
public class NonRepeatSubstring {

    /**
     * 解法一：
     *  使用hashmap保存出现过的字符的索引，
     *  j和m分别保存不包含重复字符的子串的开始索引和长度
     *  遍历字符串，更新m和map
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int m = 0;
        int j = -1;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            j = Math.max(j, map.getOrDefault(c, -1));
            m = Math.max(m, i - j);
            map.put(c, i);
        }
        return m;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int m = 0;
        int[] indices = new int[128];
        Arrays.fill(indices, -1);
        int j = -1;
        for (int i = 0; i < s.length(); i++) {
            j = Math.max(indices[s.charAt(i)], j);
            m = Math.max(m, i - j);
            indices[s.charAt(i)] = i;
        }
        return m;
    }
}