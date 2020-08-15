package explore.algorithm.junior.string;

/**
 * @author li
 * @version 1.0
 * @date 18-8-15 下午12:12
 **/
public class ReverseInteger {
    public int reverse(int x) {
        String s = x + "";
        int rs = 0;
        if (s.startsWith("-")) {
            s = reverseString(s.substring(1));
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    s = s.substring(i);
                    break;
                }
            }
            try {
                rs = Integer.parseInt(("-" + s));
            } catch (Exception e) {
                return rs;
            }
        } else {
            s = reverseString(s);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    try {
                        rs = Integer.parseInt(s.substring(i));
                        break;
                    } catch (Exception e) {
                        return rs;
                    }
                }
            }
        }
        return rs;
    }

    private String reverseString(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        int test = 1534236469;
        System.out.println(new ReverseInteger().reverse(test));
    }
}
