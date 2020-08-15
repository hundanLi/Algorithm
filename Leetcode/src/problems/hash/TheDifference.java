package problems.hash;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-23 19:47
 **/
public class TheDifference {
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        map[t.charAt(t.length() - 1) - 'a']--;
        int i;
        for (i = 0; i < map.length; i++) {
            if (map[i] < 0) {
                break;
            }
        }
        return (char) ('a' + i);
    }

    public char findTheDifference2(String s, String t) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans ^= (s.charAt(i) ^ t.charAt(i));
        }
        ans ^= t.charAt(t.length() - 1);
        return (char) (ans);
    }
}
