package jd;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-13 20:11
 **/
public class Main2 {
    private static int min;
    private static int max;
    private static Set<String> dict;
    private static int maxLen;

    private static int wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return 0;
        }
        int[] range = lengthRange(wordDict);
        dict = new HashSet<>(wordDict);
        min = range[0];
        max = range[1];

        dfs(s, new LinkedList<>(), 0);
        return maxLen;
    }

    private static void dfs(String s, List<String> list, int start) {
        if (start == s.length()) {
            maxLen = Math.max(maxLen, list.size());
            return;
        }
        int nextStart = start + 1;
        for (int i = min; i <= max && start + i <= s.length(); i++) {
            if (dict.contains(s.substring(start, start + i))) {
                nextStart = start + i;
                list.add(s.substring(start, start + i));
                maxLen = Math.max(maxLen, list.size());
                dfs(s, list, start + i);
                list.remove(list.size() - 1);
            }
        }
        dfs(s, list, nextStart);
    }

    private static int[] lengthRange(List<String> list) {
        int min = list.get(0).length();
        int max = list.get(0).length();
        for (String s : list) {
            min = Math.min(min, s.length());
            max = Math.max(max, s.length());
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String word = in.next();
            list.add(word);
        }
        String s = in.next();
        int i = wordBreak(s, list);
        System.out.println(i);
    }

}
