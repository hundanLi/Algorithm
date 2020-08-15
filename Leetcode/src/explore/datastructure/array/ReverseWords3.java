package explore.datastructure.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-15 11:21
 **/
public class ReverseWords3 {
    public String reverseWords(String s) {
        if (s == null || "".equals(s.trim())) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        int i = -1;
        int j = 0;
        int k;
        while (j <= s.length()) {
            if (j == s.length() || s.charAt(j) == ' ') {
                k = j - 1;
                while (k > i) {
                    sb.append(s.charAt(k--));
                }
                if (j < s.length()) {
                    sb.append(' ');
                }
                i = j;
            }
            j++;
        }
        return sb.toString();
    }


    class Solution {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int startIndex = 0;
            while (startIndex < s.length()) {
                int endIndex = s.indexOf(' ', startIndex + 1);
                if (endIndex == -1) {
                    endIndex = s.length();
                }
                reverse(startIndex, endIndex, chars);
                startIndex = endIndex + 1;
            }
            return String.valueOf(chars);

        }

        private void reverse(int startIndex, int endIndex, char[] chars) {

            for (int i = startIndex, k = endIndex - 1; i < k; i++, k--) {
                char temp = chars[i];
                chars[i] = chars[k];
                chars[k] = temp;
            }

        }
    }
}
