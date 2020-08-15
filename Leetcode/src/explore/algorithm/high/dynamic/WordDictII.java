package explore.algorithm.high.dynamic;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-03 11:59
 **/
public class WordDictII {
    private int min;
    private int max;
    private Set<String> dict;

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new LinkedList<>();
        if (wordDict == null || wordDict.size() == 0) {
            return list;
        }
        int[] range = lengthRange(wordDict);
        Set<String> wordSet = new HashSet<>(wordDict);
        dict = wordSet;

        boolean[] canBreak = new boolean[s.length()];
        min = range[0];
        max = range[1];
        boolean can;
        if (wordSet.contains(s.substring(0, min))) {
            canBreak[min - 1] = true;
        }
        for (int i = min; i < s.length(); i++) {
            can = false;
            for (int j = i - max + 1; j <= i - min + 1; j++) {
                if (j < 0) {
                    continue;
                }
                if ((j == 0 || canBreak[j - 1]) && wordSet.contains(s.substring(j, i + 1))) {
                    can = true;
                    break;
                }
            }
            canBreak[i] = can;
        }
        if (!canBreak[s.length() - 1]) {
            return list;
        }
        dfs(list, s, new StringBuilder(), 0);
        return list;
    }

    private void dfs(List<String> list, String s, StringBuilder sb, int start) {
        if (start == s.length()) {
            list.add(sb.toString().trim());
            return;
        }
        for (int i = min; i <= max && start + i <= s.length(); i++) {
            if (dict.contains(s.substring(start, start + i))) {
                int len = sb.length();
                sb.append(s, start, start + i).append(" ");
                dfs(list, s, sb, start + i);
                sb.setLength(len);
            }
        }
    }

    private int[] lengthRange(List<String> list) {
        int min = list.get(0).length();
        int max = list.get(0).length();
        for (String s : list) {
            min = Math.min(min, s.length());
            max = Math.max(max, s.length());
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> strings = new WordDictII().wordBreak(s, list);
        System.out.println(strings);

    }
}
