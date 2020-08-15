package mock.month1909;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-17 10:01
 **/
public class AlienSorted {
    public boolean isAlienSorted(String[] words, String order) {

        int[] dict = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            dict[c - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(dict, words[i], words[i + 1])) {
                return false;
            }
        }
        return true;

    }

    private boolean compare(int[] dict, String str1, String str2) {
        int c1;
        int c2;
        int i = 0;
        for (; i < str1.length() && i < str2.length(); i++) {
            c1 = str1.charAt(i) - 'a';
            c2 = str2.charAt(i) - 'a';
            if (dict[c1] < dict[c2]) {
                return true;
            } else if (dict[c1] > dict[c2]) {
                return false;
            }
        }
        return i >= str1.length();
    }
}
