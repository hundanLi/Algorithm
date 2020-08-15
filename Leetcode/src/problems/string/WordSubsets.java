package problems.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-19 10:18
 **/
public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        if (A == null || A.length == 0) {
            return Collections.emptyList();
        }
        int[] bMax = new int[26];
        for (String b : B) {
            int[] count = new int[26];
            for (int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                bMax[i] = Math.max(bMax[i], count[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String a : A) {
            int[] map = new int[26];
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                map[c - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (map[i] < bMax[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(a);
            }
        }
        return ans;
    }
}
