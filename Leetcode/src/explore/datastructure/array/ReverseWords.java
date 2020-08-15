package explore.datastructure.array;

import java.util.Objects;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-15 11:01
 **/
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        s = s.trim();
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int i = words.length;
        String word;
        while (--i >= 0) {
            word = words[i].trim();
            if (!Objects.equals("", word)) {
                sb.append(word).append(" ");
            }
        }
        return sb.toString().trim();
    }

}
