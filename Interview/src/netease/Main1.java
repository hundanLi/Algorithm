package netease;


import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-02 19:02
 * 思路：先对字符串整体reverse，在对每个单词reverse
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str != null) {
            String wholeReverse = reverse(str);
            StringBuilder sb = new StringBuilder();
            StringBuilder word;
            for (int i = 0; i < wholeReverse.length(); i++) {
                int j = i;
                word = new StringBuilder();
                while (j < wholeReverse.length()
                        && ((wholeReverse.charAt(j) >= 'A' && wholeReverse.charAt(j) <= 'Z')
                        || (wholeReverse.charAt(j) >= 'a' && wholeReverse.charAt(j) <= 'z')
                        || (wholeReverse.charAt(j) >= '0' && wholeReverse.charAt(j) <= '9')
                )) {
                    word.append(wholeReverse.charAt(j));
                    j++;
                }
                if (word.length() > 0) {
                    sb.append(reverse(word.toString()));
                }
                if (j < wholeReverse.length()) {
                    sb.append(wholeReverse.charAt(j));
                }
                i = j;
            }
            System.out.println(sb.toString());
        }
    }

    private static String reverse(String string) {
        int length = string.length();
        char[] chars = string.toCharArray();
        int i = 0;
        int j = length - 1;
        while (i < j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
        return new String(chars);
    }
}
