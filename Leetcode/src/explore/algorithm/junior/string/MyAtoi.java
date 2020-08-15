package explore.algorithm.junior.string;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-14 19:02
 **/
public class MyAtoi {
    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }
        if (str.length() == 1) {
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                return 0;
            }
        }
        if (!('0' <= str.charAt(0) && str.charAt(0) <= '9'
                || str.charAt(0) == '+'
                || str.charAt(0) == '-')) {
            return 0;
        }
        String flag = "+";
        if (str.charAt(0) == '-') {
            flag = "-";
        }
        int begin = 0, end = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                begin = 1;
                continue;
            }
            if (!('0' <= str.charAt(i) && str.charAt(i) <= '9')) {
                end = i;
                break;
            }
        }
        int rs = 0;
        if (begin == end) {
            if (str.charAt(begin) > '9' || str.charAt(begin) < '0') {
                return 0;
            }
        }
        try {
            rs = Integer.parseInt(flag + str.substring(begin, end));
        } catch (Exception e) {
            if ("+".equals(flag)) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        String test = "    -p2";
        int i = myAtoi(test);
        System.out.println(i);
    }
}
