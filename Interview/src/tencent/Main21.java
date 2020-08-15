package tencent;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-05 20:13
 **/
public class Main21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        String s = in.nextLine();

    }

    private int solve(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        if (chars[0] != chars[1]) {
            count++;
        }
        for (int i = 1; i < chars.length; i++) {
            if (i == 1 && count > 0) {
                continue;
            }

        }
        return 0;
    }
}
