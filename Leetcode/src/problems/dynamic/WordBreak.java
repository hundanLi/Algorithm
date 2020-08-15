package problems.dynamic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-11 12:55
 * 思路：
 * 设dp[i] 表示s[0:i-1]能否被wordBreak，初始化dp[0]=true，则
 * dp[i] = dp[i-j] && s[i-j:i-1] in dict，对任意 minLen <= j <= maxLen
 **/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        //list -> set
        Set<String> set = new HashSet<>(wordDict);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String word : set) {
            min = Math.min(min, word.length());
            max = Math.max(max, word.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = min; i <= s.length(); i++) {
            for (int j = i - max; j <= i - min; j++) {
                if (j >= 0 && dp[j]) {
                    if (set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = Arrays.asList("leet", "code");
        boolean b = new WordBreak().wordBreak(s, list);
        System.out.println(b);
    }
}
