package problems.string;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-10 09:23
 **/
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.trim().toCharArray();
        int length = chars.length;
        int i = 0;
        int j = length - 1;
        while (i < j) {
            swapChar(chars, i, j);
            i++;
            j--;
        }
        i = 0;
        j = 0;
        while (j < length) {
            while (j < length && ' ' != chars[j]) {
                j++;
            }
            int k = j - 1;
            while (i < k) {
                swapChar(chars, i, k);
                i++;
                k--;
            }
            j += 1;
            i = j;
        }
        i = 0;
        for (int k = 0; k < chars.length; k++) {
            if (chars[k] == ' ' && chars[k - 1] == ' ') {
                continue;
            }
            chars[i++] = chars[k];
        }

        return String.valueOf(chars, 0, i);
    }

    private void swapChar(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static void main(String[] args) {
        String sentence = "a good   example";
        String reverseWords = new ReverseWords().reverseWords(sentence);
        System.out.println(reverseWords);

    }
}
