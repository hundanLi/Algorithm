package mock.month1908;


/**
 * @author li
 * @version 1.0
 * @date 2019-08-28 09:56
 **/
public class ValidString {
    public boolean checkValidString(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        int l = 0;
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
                h++;
            } else if (c == '*') {
                if (l > 0) {
                    l--;
                }
                h++;
            } else {
                if (h > 0) {
                    h--;
                    if (l > 0) {
                        l--;
                    }
                } else {
                    return false;
                }
            }
        }
        return l == 0;
    }

    public static void main(String[] args) {
        String s = "()";
        ValidString validString = new ValidString();
        System.out.println(validString.checkValidString(s));
    }
}
