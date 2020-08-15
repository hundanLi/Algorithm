package huawei;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-27 19:14
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String code = in.next();
        for (int i = 0; i < n; i++) {
            int index = i * 9;
            if (code.charAt(index) == '1') {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(code.substring(index + 1, index + 9));
            } else {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(reverse(code.substring(index + 1, index + 9)));
            }
        }
    }

    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0 ; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}
