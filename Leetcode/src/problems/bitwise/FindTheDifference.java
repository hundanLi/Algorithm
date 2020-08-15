package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-11 14:22
 **/
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int mask1 = 0;
        int mask2 = 0;
        for (int i = 0; i < s.length(); i++) {
            mask1 ^= 1 << (s.charAt(i) - 'a');
        }
        for (int i = 0; i < t.length(); i++) {
            mask2 ^= 1 << (t.charAt(i) - 'a');
        }
        int diff = mask1 ^ mask2;
        int c = -1;
        while (diff != 0) {
            c++;
            diff >>>= 1;
        }
        return (char) (c + 'a');
    }
}
