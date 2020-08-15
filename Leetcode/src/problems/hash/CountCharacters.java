package problems.hash;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-21 12:56
 **/
public class CountCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] map = new int[26];
        for (char c : chars.toCharArray()) {
            int idx = c - 'a';
            map[idx]++;
        }
        int len = 0;
        for (String word : words) {
            if (canSpell(word, Arrays.copyOf(map, map.length))) {
                len += word.length();
            }
        }
        return len;
    }

    private boolean canSpell(String word, int[] map) {
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (map[idx] > 0) {
                map[idx]--;
            } else {
                return false;
            }
        }
        return true;
    }
}
