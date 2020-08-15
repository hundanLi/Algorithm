package mock.month1908;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-10 12:44
 **/
public class ReverseVowels {
    private Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        int l = 0;
        int r = s.length() - 1;
        char[] chars = new char[s.length()];
        while (l <= r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            if (!set.contains(cl)) {
                chars[l] = s.charAt(l++);
                continue;
            }
            if (!set.contains(cr)) {
                chars[r] = s.charAt(r--);
                continue;
            }
            if (set.contains(cl) && set.contains(cr)) {
                chars[l++] = cr;
                chars[r--] = cl;
            }
        }
        return new String(chars);
    }
}
