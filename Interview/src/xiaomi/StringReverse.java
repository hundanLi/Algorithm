package xiaomi;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-29 10:13
 **/
public class StringReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(reverseWords(str));

    }

    private static String reverseWords(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
