package cat;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-18 18:58
 **/
public class RotateString {
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0) {
            return;
        }
        int len = str.length;
        offset = offset % str.length;
        for (int i = 0; i < offset; i++) {
            char tail = str[len-1];
            for (int j = len - 1; j >= 1; j--) {
                str[j] = str[j - 1];
            }
            str[0] = tail;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int offset = 3;
        new RotateString().rotateString(s.toCharArray(), offset);
        System.out.println();

    }
}
