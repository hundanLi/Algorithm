package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-04 19:19
 * 思路：设num[i] 表示s[0:i - 1]的解码总数(i>=1)，并初始化num[0] = 1，那么存在以下推导式：
 * 1.如果s[i-1:i]构成的数字<=26，联合解码，则 num[i] += num[i-2];
 * 2.s[i]独立解码，则　num[i] += num[i-1]
 * 最后返回num[s.length]
 **/
public class NumDecodings {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] num = new int[s.length() + 1];
        num[0] = 1;
        if (s.charAt(0) != '0') {
            num[1] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                    num[i + 1] = num[i - 1];
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                    num[i + 1] += num[i - 1];
                }
                num[i + 1] += num[i];
            }
        }
        return num[num.length - 1];
    }

    public static void main(String[] args) {
        String s = "110";
        int i = new NumDecodings().numDecodings(s);
        System.out.println(i);
    }
}
