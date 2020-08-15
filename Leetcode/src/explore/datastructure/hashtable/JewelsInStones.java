package explore.datastructure.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-10 09:41
 **/
public class JewelsInStones {
    public int numJewelsInStones(String j, String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < j.length(); i++) {
            set.add(j.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
