package problems.array;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-06 11:26
 **/
public class FrequencySort {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Counter[] fre = new Counter[128];
        for (int i = 0; i < fre.length; i++) {
            fre[i] = new Counter((char) i, 0);
        }
        for (int i = 0; i < s.length(); i++) {
            fre[s.charAt(i)].count++;
        }
        Arrays.sort(fre, (c1, c2) -> c2.count - c1.count);
        char[] chars = new char[s.length()];
        int i = 0;
        while (i < chars.length) {
            for (Counter c : fre) {
                while (c.count > 0 && i < chars.length) {
                    c.count--;
                    chars[i++] = c.c;
                }
            }
        }

        return new String(chars);
    }


    static class Counter {
        char c;
        int count;

        Counter(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }


    /**
     * 通过一个字典 dict 存储所有字符出现的次数，
     * 因为某个字符的出现次数不可能超过 s 的长度，所以我们将每个字符根据其出现次数放入数组中的对应位置，
     * 那么最后我们只要从后往前遍历数组所有位置，将不为空的位置的字符串加入结果 ret 中即可
     */
    public String frequencySort2(String s) {
        int[] freq = new int[128];
        StringBuilder[] sbs = new StringBuilder[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                if (sbs[freq[i]] == null) {
                    sbs[freq[i]] = new StringBuilder();
                }
                sbs[freq[i]].append((char) i);
            }
        }
        char[] chars = new char[s.length()];
        int idx = 0;
        for (int i = sbs.length - 1; i >= 0; i--) {
            if (sbs[i] != null) {
                for (int k = 0; k < sbs[i].length(); k++) {
                    for (int j = 0; j < i; j++) {
                        chars[idx++] = sbs[i].charAt(k);
                    }
                }
            }
        }
        return new String(chars);
    }
}