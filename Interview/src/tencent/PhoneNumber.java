package tencent;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-20 20:04
 **/
public class PhoneNumber {
    private static boolean isValid(String s) {
        if (s == null || s.length() < 11) {
            return false;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '8') {
                return n - i >= 11;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            in.nextLine();
            String s = in.nextLine();
            if (isValid(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
