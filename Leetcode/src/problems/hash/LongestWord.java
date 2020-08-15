package problems.hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-22 13:49
 **/
public class LongestWord {
    public String longestWord(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<String> set = new HashSet<>();
        set.add("");
        String ans = null;
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (ans == null || ans.length() < word.length()) {
                    ans = word;
                } else if (ans.length() == word.length() && ans.compareTo(word) > 0) {
                    ans = word;
                }
            }
        }
        return ans == null ? "" : ans;
    }
}
