package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-29 12:00
 **/
public class MaxProduct {
    public int maxProduct(String[] words) {
        int res = 0;
        if (words == null || words.length < 2) {
            return res;
        }
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            for (int j = 0; j < len; j++) {
                bits[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

}
