package problems.string;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-18 18:50
 **/
public class Zconvert {
    public static String convert(String s, int row) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (row == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        boolean up;
        for (int i = 0; i < row; i++) {
            up = false;
            int idx = i;
            if (i == 0 || i == row - 1) {
                while (idx < s.length()) {
                    sb.append(s.charAt(idx));
                    idx += (row + row - 2);
                }
            } else {
                while (idx < s.length()) {
                    sb.append(s.charAt(idx));
                    if (up) {
                        up = false;
                        idx += (i << 1);
                    } else {
                        up = true;
                        idx += ((row - 1 - i) << 1);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int row = 3;
        System.out.println(convert(s, row));
    }
}
