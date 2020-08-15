package problems.greedy;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-19 15:10
 **/
public class StrWithout3a3b {
    public static String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();

        while (a > 0 || b > 0) {
            boolean appendA = false;
            int len = sb.length();
            if (len > 2 && sb.charAt(len - 1) == sb.charAt(len - 2)) {
                if (sb.charAt(len - 1) == 'b') {
                    appendA = true;
                }
            } else {
                if (a > b) {
                    appendA = true;
                }
            }
            if (appendA) {
                a--;
                sb.append('a');
            } else {
                b--;
                sb.append('b');
            }
        }
        return sb.toString();
    }
}
