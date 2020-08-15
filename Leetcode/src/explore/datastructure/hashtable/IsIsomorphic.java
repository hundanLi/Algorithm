package explore.datastructure.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-09 09:51
 **/
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>(16);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsValue(t.charAt(i))) {
                map.put(c, t.charAt(i));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            sb.append(map.get(s.charAt(i)));
        }
        return sb.toString().equals(t);
    }

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            char[] sc = s.toCharArray();
            char[] tc = t.toCharArray();
            char[] map = new char[256];
            for (int i = sc.length-1;i >= 0;i--) {
                if (map[sc[i]] != map[tc[i]+128]) {
                    return false;
                }
                map[sc[i]] = map[tc[i] + 128] = sc[i];
            }
            return true;

        }
    }
}
