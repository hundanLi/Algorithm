package explore.algorithm.high.dynamic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-03 11:15
 * 思路：res[i]表示s[0:i]子串能不能拆分，则res[i] = res[j] && s[j:i] in dict, j = [min, max]
 **/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        int[] range = lengthRange(wordDict);
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] canBreak = new boolean[s.length()];
        int min = range[0];
        int max = range[1];
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
        return canBreak[s.length() - 1];
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
        String s = "leetcode";
        List<String> list = Arrays.asList("leet", "code");
        boolean b = new WordBreak().wordBreak(s, list);
        System.out.println(b);
    }
}
