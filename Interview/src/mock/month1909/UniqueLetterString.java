package mock.month1909;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-07 10:27
 **/
public class UniqueLetterString {
    public int uniqueLetterString1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                num += uniqueNum(s, i, j);
            }
        }
        return num;
    }

    private int uniqueNum(String s, int begin, int end) {
        int num = 0;
        Map<Character, Integer> map = new HashMap<>(end - begin + 1);
        for (int i = begin; i <= end; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                num++;
            }
        }
        return num;
    }

    public int uniqueLetterString2(String s) {
        Map<Character, List<Integer>> indexMap = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            indexMap.putIfAbsent(c, new ArrayList<>());
            indexMap.get(c).add(i);
        }
        long ans = 0;
        for (List<Integer> index : indexMap.values()) {
            for (int i = 0; i < index.size(); i++) {
                long prev = i > 0 ? index.get(i - 1) : -1;
                long next = i < index.size() - 1 ? index.get(i + 1) : s.length();
                ans += (index.get(i) - prev) * (next - index.get(i));
            }
        }
        return (int) (ans % 1_000_000_007);
    }

    private static class Tuple {
        int prev;
        int next;
    }

    public int uniqueLetterString3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 维护prev数组保存该字母的前一出现位置
        int[] prev = new int[26];
        // 保存s中位置i上字母的前一出现位置（前驱）和后一出现位置（后继）
        // 即在tuples[i].prev, i, tuples[i].next位置上的字母相同
        Tuple[] tuples = new Tuple[s.length()];
        // 初始化
        for (int i = 0; i < s.length(); i++) {
            tuples[i] = new Tuple();
        }
        for (int i = 0; i < 26; i++) {
            prev[i] = -1;
        }
        // 填充tuples
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            // 更新当前字母的前驱和后继
            tuples[i].prev = prev[c];
            tuples[i].next = s.length();
            // 更新前一相同字母的后继
            if (prev[c] >= 0) {
                tuples[prev[c]].next = i;
            }
            // 更新字母s[i]的前一出现位置为i，以便后续使用
            prev[c] = i;
        }
        long ans = 0;
        // 分别计算仅包含一个s[i]的子串个数，累加起来就是所要求的结果
        for (int i = 0; i < s.length(); i++) {
            ans += (i - tuples[i].prev) * (tuples[i].next - i);
        }
        return (int) (ans % 1_000_000_007);
    }


    public int uniqueLetterString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 维护prev数组保存该字母的前一出现位置
        int[] prev = new int[26];
        // 保存s中位置i上字母的前一出现位置（前驱）和后一出现位置（后继）
        // 即在tuples[i].prev, i, tuples[i].next位置上的字母相同
        int[][] tuples = new int[s.length()][2];
        // 初始化
        for (int i = 0; i < 26; i++) {
            prev[i] = -1;
        }
        // 填充tuples
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            // 更新当前字母的前驱和后继
            tuples[i][0] = prev[c];
            tuples[i][1] = s.length();
            // 更新前一相同字母的后继
            if (prev[c] >= 0) {
                tuples[prev[c]][1] = i;
            }
            // 更新字母s[i]的前一出现位置为i，以便后续使用
            prev[c] = i;
        }
        int ans = 0;
        // 分别计算仅包含一个s[i]的子串个数，累加起来就是所要求的结果
        for (int i = 0; i < s.length(); i++) {
            ans += (i - tuples[i][0]) * (tuples[i][1] - i);
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(new UniqueLetterString().uniqueLetterString3(s));
    }
}