package explore.algorithm.junior.string;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-14 11:10
 **/
public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        boolean rs = false;
        if (s.length() != t.length()) {
            return rs;
        }
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
        if (Arrays.toString(sChars).equals(Arrays.toString(tChars))) {
            rs = true;
        }
        return rs;
    }

    public static void main(String[] args) {
        boolean anagram = IsAnagram.isAnagram("anagram", "nagaram");
        System.out.println(anagram);
    }
}
