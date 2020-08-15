/**
 * @author li
 * @version 1.0
 * @date 2020-04-20 11:11
 **/
public class NthSeries {
    public static String seriesSum(int n) {
        // Happy Coding ^_^
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += 1.0 / (1 + (i) * 3);
        }
        String s = Double.toString(sum);
        System.out.println(s);
        System.out.println(String.format("%.2f", sum));

        int dot = s.indexOf('.');
        if (dot + 2 >= s.length()) {
            return s + "0";
        } else if (dot + 2 == s.length() - 1) {
            return s;
        } else {
            int tail = s.charAt(dot + 3) - '0';
            if (tail < 5) {
                return s.substring(0, dot + 3);
            } else {
                // 进位
                int carry = 1;
                char[] chars = s.substring(0, dot + 3).toCharArray();
                for (int i = chars.length - 1; i >= 0; i--) {
                    if (i != dot) {
                        int num = carry + (chars[i] - '0');
                        carry = num / 10;
                        num = num % 10;
                        chars[i] = (char) (num + '0');
                    }
                }
                if (carry > 0) {
                    return "1" + String.valueOf(chars);
                }
                return String.valueOf(chars);
            }
        }
    }

    public static String seriesSum2(int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += 1.0 / (1 + (i) * 3);
        }
        return String.format("%.2f", sum);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(seriesSum2(n));
    }
}
