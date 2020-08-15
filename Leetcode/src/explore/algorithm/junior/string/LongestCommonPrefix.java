package explore.algorithm.junior.string;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-15 17:21
 **/
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = strs[0].length();
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
            }
        }
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != ch) {
                    return prefix.toString();
                }
            }
            prefix.append(ch);
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] test1 = new String[]{"flower", "flow", "flight"};
        String[] test2 = new String[]{"dog", "racecar", "car"};
        String[] test3 = new String[]{};
        String s = longestCommonPrefix(test3);
        System.out.println(s);
    }
}
