package explore.bytedance.string;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-04 12:30
 **/
public class CommonPrefix {
    public String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        int minLen = strings[0].length();
        for (String s : strings) {
            if (s.length() < minLen) {
                minLen = s.length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = strings[0].charAt(i);
            for (String s : strings) {
                if (s.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
