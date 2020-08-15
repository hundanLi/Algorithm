package mock.month1909;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-24 19:45
 **/
public class StreamChecker {
    private String[] words;
    private StringBuilder sb;
    public StreamChecker(String[] words) {
        this.words = words;
        this.sb = new StringBuilder();
    }

    public boolean query(char letter) {
        sb.append(letter);
        for (String word : words) {
            if (check(sb, word)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(StringBuilder sb, String word) {
        if (sb.length() < word.length()) {
            return false;
        }
        int i = sb.length() - 1;
        int j = word.length() - 1;
        while (j >= 0) {
            if (sb.charAt(i) != word.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
