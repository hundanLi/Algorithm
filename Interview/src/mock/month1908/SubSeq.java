package mock.month1908;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-02 09:39
 **/
public class SubSeq {

    public int numMatchingSubseq(String s, String[] words) {
        int cnt = 0;
        Map<String, Integer> count = new HashMap<>();

        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (subSeq(s, entry.getKey())) {
                cnt += entry.getValue();
            }
        }
        return cnt;
    }

    /**
     * 动态规划思想
     * 设dp[i][j] 表示word[0:j-1]是否为s[0:i-1]的子序列，则
     * dp[i][j] = dp[i-1][j] || (dp[i-1][j-1] && s[i-1] == word[j-1])
     * 初始化：
     *  dp[0][0] = true
     */
    private boolean subSeq(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == word.length();
    }
}

