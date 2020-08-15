package problems.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-20 15:42
 **/
public class WordPattern {
    public boolean wordPattern(String pattern, String str){
        String[] strings = str.split(" ");
        if (strings.length != pattern.length()) {
            return false;
        }
        String[] maps = new String[26];
        Set<String> set = new HashSet<>();
        int idx;
        for (int i = 0; i < pattern.length(); i++) {
            idx = pattern.charAt(i) - 'a';
            if (maps[idx] == null && !set.contains(strings[i])) {
                maps[idx] = strings[i];
                set.add(strings[i]);
            } else {
                if (!strings[i].equals(maps[idx])) {
                    return false;
                }
            }
        }
        return true;
    }

}
